package com.eaccid.txttranslator.libtranslator.ytranslator_impl;

import java.util.List;

public interface TextTranslation {
    String getTranscription();

    List<String> getTranslates();

    String getSoundUrl();

    String getPicUrl();

    String getWord();

    boolean isEmpty();

    @Override
    String toString();
}
