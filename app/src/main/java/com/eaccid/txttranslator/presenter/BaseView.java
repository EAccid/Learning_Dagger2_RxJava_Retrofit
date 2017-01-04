package com.eaccid.txttranslator.presenter;

import com.eaccid.txttranslator.libtranslator.ytranslator_impl.TextTranslation;

public interface BaseView {
    BasePresenter getPresenter();
    void showTextTranslation(TextTranslation text);
}
