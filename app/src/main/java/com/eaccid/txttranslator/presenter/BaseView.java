package com.eaccid.txttranslator.presenter;

import java.util.List;

public interface BaseView {
    BasePresenter getPresenter();
    void showTextTranslation(List<String> text);
}
