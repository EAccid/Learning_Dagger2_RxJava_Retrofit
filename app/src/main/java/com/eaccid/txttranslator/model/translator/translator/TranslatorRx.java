package com.eaccid.txttranslator.model.translator.translator;
import rx.Observable;

public interface TranslatorRx {
    Observable<TextTranslation> translateObservable(String word);
}
