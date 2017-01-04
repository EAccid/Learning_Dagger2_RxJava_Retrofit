package com.eaccid.txttranslator.model.translator.ytranslator_impl;

public interface Translator {

    boolean translate(String word);

    TextTranslation getTranslations();
}
