package com.eaccid.txttranslator.provider.translator;

import com.eaccid.txttranslator.model.translator.translator.Translator;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.translator.TranslatorFactory;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.translator.Translators;
import com.eaccid.txttranslator.provider.fromtext.WordFromText;

import java.util.List;

public class WordDataProvider implements DataProvider{

    @Override
    public List<String> procureTranslations(WordFromText wordFromText) {
        Translator translator = TranslatorFactory.newTranslator(Translators.YANDEX_TRANSLATOR);
        translator.translate(wordFromText.getText());
        return translator.getTranslation().getTranslates();
    }

}
