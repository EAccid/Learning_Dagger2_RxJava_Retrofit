package com.eaccid.txttranslator.fromtext;

import java.io.Serializable;

public class WordFromTextImpl implements Serializable, WordFromText {

    private String text;
    private String sentence;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getSentence() {
        return sentence;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "WordFromTextImpl{" +
                "text='" + text + '\'' +
                ", sentence='" + sentence + '\'' +
                '}';
    }
}
