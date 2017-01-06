package com.eaccid.txttranslator.model;

import com.eaccid.txttranslator.model.translator.translator.TextTranslation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class YandexWordTranslation implements TextTranslation {

    private String word;
    @SerializedName("text")
    @Expose
    private List<String> translations;

    @Override
    public String getTranscription() {
        return "";
    }

    @Override
    public List<String> getTranslates() {
        return translations;
    }

    @Override
    public String getSoundUrl() {
        return "";
    }

    @Override
    public String getPicUrl() {
        return "";
    }

    @Override
    public String getWord() {
        return word;
    }

    @Override
    public boolean isEmpty() {
        return translations.isEmpty();
    }

    public void setText(List<String> text) {
        this.translations = text;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
