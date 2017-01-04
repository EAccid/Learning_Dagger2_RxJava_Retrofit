package com.eaccid.txttranslator.presenter;

public interface BasePresenter<V extends BaseView> {
    void attachView(V v);
    void detachView();
}
