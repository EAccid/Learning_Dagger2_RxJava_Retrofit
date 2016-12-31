package com.eaccid.txttranslator;

import com.eaccid.txttranslator.libtranslator.gtranslator_impl.TextTranslation;

public interface BaseView {
    BasePresenter getPresenter();
    void showTextTranslation(TextTranslation text);
}
