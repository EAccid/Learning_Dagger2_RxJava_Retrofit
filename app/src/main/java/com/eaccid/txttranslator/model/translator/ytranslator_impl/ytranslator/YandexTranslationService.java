package com.eaccid.txttranslator.model.translator.ytranslator_impl.ytranslator;

import com.eaccid.txttranslator.model.WordTranslation;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface YandexTranslationService {

    @POST("api/v1.5/tr.json/translate")
    Observable<WordTranslation> translate(
            @Query("key") String key,
            @Query("text") String text,
            @Query("lang") String lang
    );

}
