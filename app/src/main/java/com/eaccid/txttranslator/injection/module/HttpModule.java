package com.eaccid.txttranslator.injection.module;

import android.app.Application;

import com.eaccid.txttranslator.presenter.NetworkAvailablenessImpl;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncornette.cache.OkCacheControl;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModule {
    private final String baseUrl;

    public HttpModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    /**
     * /todo: handle cache
     * isNetworkAvailable() -> true: Interceptor to cache data and maintain it for four weeks.
     * isNetworkAvailable() -> false: Interceptor to cache data and maintain it for a minute.
     */
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient
                .Builder()
                .cache(cache)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    if (new NetworkAvailablenessImpl().isNetworkAvailable()) {
                        request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                    } else {
                        //TODO doesn't work correctly: return "HTTP 504 Unsatisfiable Request (only-if-cached)"
                        request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 28).build();
                    }
                    return chain.proceed(request);
                })
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
    }

    private OkCacheControl.NetworkMonitor provideNetworkMonitor() {
        return () -> new NetworkAvailablenessImpl().isNetworkAvailable();
    }

}