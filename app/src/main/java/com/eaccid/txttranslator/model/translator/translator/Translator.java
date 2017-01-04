package com.eaccid.txttranslator.model.translator.translator;

public interface Translator {
    boolean translate(String word);
    TextTranslation getTranslation();
}
