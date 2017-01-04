package com.eaccid.txttranslator.model.translator.lingualeo_impl.translator;

import com.eaccid.txttranslator.model.translator.translator.Translator;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.YandexTranslator;

public class TranslatorFactory {
    private TranslatorFactory() {
    }

    public static Translator newTranslator(Translators tr) {

        switch (tr) {
            case LINGUALEO:
                return new LingualeoTranslator();
            case YANDEX_TRANSLATOR:
                return new YandexTranslator();
            default:
                throw new RuntimeException("smth goes wrong!");
        }

    }
}