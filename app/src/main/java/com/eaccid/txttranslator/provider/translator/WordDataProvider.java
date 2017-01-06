package com.eaccid.txttranslator.provider.translator;

import com.eaccid.txttranslator.model.translator.translator.TextTranslation;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.translator.TranslatorFactory;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.translator.Translators;
import com.eaccid.txttranslator.model.translator.translator.TranslatorRx;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

public class WordDataProvider implements DataProvider {

    @Override
    public Observable<List<String>> procureTranslationsObservable(String text) {
        TranslatorRx translator = TranslatorFactory.newRxTranslator(Translators.YANDEX_TRANSLATOR);
        return translator.translateObservable(text).flatMap(new Func1<TextTranslation, Observable<List<String>>>() {
            @Override
            public Observable<List<String>> call(TextTranslation textTranslation) {
                return Observable.just(textTranslation.getTranslates());
            }
        });
    }

    public String handleTranslationException(Throwable e) {
        e.printStackTrace();
        if (e instanceof UnknownHostException || e instanceof SocketTimeoutException) {
            return "Check internet connection";
        }
        return "Exception under development";
    }
}
