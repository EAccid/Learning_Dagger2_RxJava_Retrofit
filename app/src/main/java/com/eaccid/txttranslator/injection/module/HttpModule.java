package com.eaccid.txttranslator.injection.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncornette.cache.OkCacheControl;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
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

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        final OkCacheControl.NetworkMonitor networkMonitor = provideNetworkMonitor();
        final long timeValue = 30;
        final TimeUnit timeUnit = TimeUnit.SECONDS;
        return OkCacheControl
                .on(new OkHttpClient.Builder())
                //TODO doesn't work correctly: return "HTTP 504 Unsatisfiable Request (only-if-cached)"
                .forceCacheWhenOffline(networkMonitor)
                .overrideServerCachePolicy(timeValue, timeUnit)
                .apply()
                .cache(cache)
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