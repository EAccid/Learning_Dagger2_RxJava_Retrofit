package com.eaccid.txttranslator;

import android.app.Application;
import android.support.annotation.VisibleForTesting;
import com.eaccid.txttranslator.injection.component.AppComponent;
import com.eaccid.txttranslator.injection.component.DaggerAppComponent;
import com.eaccid.txttranslator.injection.module.AppModule;
import com.eaccid.txttranslator.injection.module.HttpModule;

public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponent();
    }

    public static AppComponent getAppComponent() {
        return component;
    }

    private void buildComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    //todo from properties
                    .httpModule(new HttpModule("https://translate.yandex.net"))
                    .build();
        }
    }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    public static void setComponent(AppComponent appComponent) {
        component = appComponent;
    }

}
