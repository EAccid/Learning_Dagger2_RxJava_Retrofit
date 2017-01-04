package com.eaccid.txttranslator.model.translator.ytranslator_impl.ytranslator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class YandexRetrofitService {

    public static YandexTranslationService createTranslationService() {
        Gson gson = new GsonBuilder().create();
        String BASE_URL = "https://translate.yandex.net";
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit.create(YandexTranslationService.class);
    }
}
