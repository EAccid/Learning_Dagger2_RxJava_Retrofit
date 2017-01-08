package com.eaccid.txttranslator.provider.translator;

import java.util.List;
import rx.Observable;

public interface DataProvider {
    Observable<List<String>> procureTranslationsObservable(String text);
    String handleTranslationException(Throwable e);
}
