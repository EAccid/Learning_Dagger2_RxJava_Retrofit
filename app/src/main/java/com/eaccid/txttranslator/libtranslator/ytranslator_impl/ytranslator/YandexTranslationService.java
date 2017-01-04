package com.eaccid.txttranslator.libtranslator.ytranslator_impl.ytranslator;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface YandexTranslationService {
    @POST("/api/v1.5/tr.json/translate")
    Call<Object> translate(
            @Query("key") String key,
            @Query("text") String text,
            @Query("lang") String lang
    );
}
