package com.eaccid.txttranslator;

public interface BasePresenter<V extends BaseView> {
    void attachView(V v);
    void detachView();
}
