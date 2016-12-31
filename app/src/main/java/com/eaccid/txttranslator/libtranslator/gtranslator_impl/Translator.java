package com.eaccid.txttranslator.libtranslator.gtranslator_impl;

public interface Translator {

    boolean translate(String word);

    TextTranslation getTranslations();
}
