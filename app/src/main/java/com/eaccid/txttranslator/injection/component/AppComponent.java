package com.eaccid.txttranslator.injection.component;

import android.content.Context;
import android.content.SharedPreferences;
import com.eaccid.txttranslator.injection.module.AppModule;
import com.eaccid.txttranslator.injection.ApplicationContext;
import com.eaccid.txttranslator.injection.module.HttpModule;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.dictionary.LingualeoServiceCookiesImpl;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.YandexRetrofitService;
import com.eaccid.txttranslator.injection.module.NetworkAvailablenessImpl;
import javax.inject.Singleton;
import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = {AppModule.class, HttpModule.class})
@Singleton
public interface AppComponent {

    void inject(LingualeoServiceCookiesImpl leoCookies);
    void inject(NetworkAvailablenessImpl networkAvailableness);
    void inject(YandexRetrofitService yandexRetrofitService);

    @ApplicationContext
    Context context();

    SharedPreferences sharedPreferences();

    Retrofit retrofit();

}
