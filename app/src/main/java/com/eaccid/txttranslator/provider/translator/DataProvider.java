package com.eaccid.txttranslator.provider.translator;

import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import java.util.List;

public interface DataProvider {
    List<String> procureTranslations(WordFromText wordFromText);
}
