package com.eaccid.txttranslator.model.translator.ytranslator_impl;

import com.eaccid.txttranslator.App;
import javax.inject.Inject;
import retrofit2.Retrofit;

public class YandexRetrofitService {

    @Inject
    Retrofit retrofit;

    public YandexRetrofitService() {
        App.getAppComponent().inject(this);
    }

    public YandexTranslationService createTranslationService() {
        return retrofit.create(YandexTranslationService.class);
    }
}
