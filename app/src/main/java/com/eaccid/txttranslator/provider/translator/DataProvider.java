package com.eaccid.txttranslator.provider.translator;

import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import java.util.List;
import rx.Observable;

public interface DataProvider {
    Observable<List<String>> procureTranslationsObservable(WordFromText wordFromText);
}
