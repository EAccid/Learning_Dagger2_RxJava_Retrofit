package com.eaccid.txttranslator.model;

import com.eaccid.txttranslator.model.translator.ytranslator_impl.TextTranslation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WordTranslation implements TextTranslation {

    private String word;
    @SerializedName("text")
    @Expose
    private List<String> text;

    @Override
    public String getTranscription() {
        return "";
    }

    @Override
    public List<String> getTranslates() {
        return text;
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
        return text.isEmpty();
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
