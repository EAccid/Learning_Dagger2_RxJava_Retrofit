package com.eaccid.txttranslator.libtranslator.ytranslator_impl;

import com.eaccid.txttranslator.libtranslator.ytranslator_impl.ytranslator.YandexTranslationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YandexTranslator implements Translator {

    private static final String BASE_URL = "https://translate.yandex.net";
    private static final String KEY = "trnsl.1.1.20170102T182143Z.3aee628aacf9fe84.e192f0a3b45ee5803afc2cdefc545fcdb49ddcf4";

    private YandexWordTranslation translation;

    @Override
    public boolean translate(String sourceText) {

        Gson gson = new GsonBuilder().create();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        YandexTranslationService service = retrofit.create(YandexTranslationService.class);
        Call<Object> call = service.translate(
                KEY,
                sourceText,
                "en-ru"
        );

        try {
            Response<Object> response = call.execute();
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;

    }

    @Override
    public YandexWordTranslation getTranslations() throws NullPointerException {
        return translation;
    }


}
