package com.eaccid.txttranslator.model.translator.lingualeo_impl.translator;

import com.eaccid.txttranslator.model.translator.translator.Translator;
import com.eaccid.txttranslator.model.translator.translator.TranslatorRx;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.YandexTranslator;

public class TranslatorFactory {
    private TranslatorFactory() {
    }

    public static Translator newTranslator(Translators tr) {

        switch (tr) {
            case LINGUALEO:
                return new LingualeoTranslator();
            default:
                throw new RuntimeException("smth goes wrong!");
        }

    }

    public static TranslatorRx newRxTranslator(Translators yandexTranslator) {
        return new YandexTranslator();    }
}