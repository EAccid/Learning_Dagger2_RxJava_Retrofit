package com.eaccid.txttranslator.injection.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.eaccid.txttranslator.App;
import com.eaccid.txttranslator.injection.ApplicationContext;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final App appContext;

    public AppModule(App appContext) {
        this.appContext = appContext;
    }

    @ApplicationContext
    @Provides
    @Singleton
    public Context provideContext() {
        return appContext;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return appContext;
    }


    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences() {
        return appContext.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
