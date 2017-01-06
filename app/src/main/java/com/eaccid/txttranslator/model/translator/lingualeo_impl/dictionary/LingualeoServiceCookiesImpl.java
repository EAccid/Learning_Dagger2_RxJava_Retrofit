package com.eaccid.txttranslator.model.translator.lingualeo_impl.dictionary;

import android.content.SharedPreferences;
import com.eaccid.txttranslator.App;
import javax.inject.Inject;

public class LingualeoServiceCookiesImpl implements LingualeoServiceCookies {

    private static final String LINGUALEO_COOKIES = "lingualeo_cookies";

    @Inject
    SharedPreferences sp;

    public LingualeoServiceCookiesImpl() {
        App.getAppComponent().inject(this);
    }

    @Override
    public void storeCookies(String cookies) {
        storeCookiesOnDevice(cookies);
    }

    @Override
    public String loadCookies() {
        return loadCookiesFromDevice();
    }

    private void storeCookiesOnDevice(String cookies) {

        SharedPreferences.Editor editor = sp.edit();
        editor.putString(LINGUALEO_COOKIES, cookies);
        editor.apply();
    }

    private String loadCookiesFromDevice() {
        return sp.getString(LINGUALEO_COOKIES, "");
    }

}