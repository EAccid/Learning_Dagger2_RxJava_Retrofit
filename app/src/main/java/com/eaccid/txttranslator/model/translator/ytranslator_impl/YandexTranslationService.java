package com.eaccid.txttranslator.model.translator.ytranslator_impl;

import com.eaccid.txttranslator.model.YandexWordTranslation;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface YandexTranslationService {

    @POST("api/v1.5/tr.json/translate")
    Observable<YandexWordTranslation> translate(
            @Query("key") String key,
            @Query("text") String text,
            @Query("lang") String lang
    );

}
