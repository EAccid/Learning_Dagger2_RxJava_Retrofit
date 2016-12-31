package com.eaccid.txttranslator.libtranslator.gtranslator_impl;

import java.util.List;

public class GTWordTranslation implements TextTranslation {
    private List<String> translates;
    private String transcription;
    private String soundUrl;
    private String picUrl;
    private String word;

    @Override
    public String getTranscription() {
        return transcription;
    }

    @Override
    public List<String> getTranslates() {
        return null;
    }

    @Override
    public String getSoundUrl() {
        return soundUrl;
    }

    @Override
    public String getPicUrl() {
        return picUrl;
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public boolean isEmpty() {
        return transcription.isEmpty();
    }
}
