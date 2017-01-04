package com.eaccid.txttranslator.presenter;

import com.eaccid.txttranslator.model.translator.ytranslator_impl.TextTranslation;

public interface BaseView {
    BasePresenter getPresenter();
    void showTextTranslation(TextTranslation text);
}
