package com.eaccid.txttranslator.model.translator.ytranslator_impl;

import com.eaccid.txttranslator.model.translator.translator.TextTranslation;
import com.eaccid.txttranslator.model.translator.translator.TranslatorRx;

import rx.Observable;

public class YandexTranslator implements TranslatorRx {
    private static final String KEY = "trnsl.1.1.20170102T182143Z.3aee628aacf9fe84.e192f0a3b45ee5803afc2cdefc545fcdb49ddcf4";

    //TODO refactor: add OkHttpClient, injections
    //temp translation
    @Override
    public Observable<TextTranslation> translateObservable(final String sourceText) {
        YandexTranslationService retrofitService = YandexRetrofitService.createTranslationService();
        return retrofitService.translate(KEY, sourceText, "en-ru")
                .map(wordTranslation -> {
                    wordTranslation.setWord(sourceText);
                    return wordTranslation;
                });
    }
}