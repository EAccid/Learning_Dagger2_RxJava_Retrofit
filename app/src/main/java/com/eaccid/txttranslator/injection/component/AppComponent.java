package com.eaccid.txttranslator.injection.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.eaccid.txttranslator.injection.module.AppModule;
import com.eaccid.txttranslator.injection.ApplicationContext;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.dictionary.LingualeoServiceCookiesImpl;

import javax.inject.Singleton;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

    void inject(LingualeoServiceCookiesImpl leoCookies);

    @ApplicationContext
    Context context();

    SharedPreferences sharedPreferences();

}
