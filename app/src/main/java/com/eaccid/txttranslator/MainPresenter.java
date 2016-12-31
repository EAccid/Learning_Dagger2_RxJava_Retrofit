package com.eaccid.txttranslator;

public class MainPresenter implements BasePresenter<MainActivity> {

    MainActivity mView;

    @Override
    public void attachView(MainActivity mainActivity) {
        mView = mainActivity;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
