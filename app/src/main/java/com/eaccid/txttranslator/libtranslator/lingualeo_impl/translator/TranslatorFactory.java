package com.eaccid.txttranslator.libtranslator.lingualeo_impl.translator;

import com.eaccid.txttranslator.libtranslator.ytranslator_impl.YandexTranslator;
import com.eaccid.txttranslator.libtranslator.ytranslator_impl.Translator;

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