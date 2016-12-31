package com.eaccid.txttranslator.libtranslator.gtranslator_impl;

public class GTranslator implements Translator {

    GTWordTranslation translation;

    @Override
    public boolean translate(String word) {
        return false;
    }

    @Override
    public GTWordTranslation getTranslations() throws NullPointerException {
        return null;
    }

}
