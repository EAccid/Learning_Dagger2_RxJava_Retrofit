package com.eaccid.txttranslator.fromtext;

public interface WordFromText {
    String getText();
    String getSentence();
    void setText(String text);
    void setSentence(String sentence);
    @Override
    String toString();
}
