package com.eaccid.txttranslator.presenter;

import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import com.eaccid.txttranslator.provider.translator.WordDataProvider;

import java.net.UnknownHostException;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter implements BasePresenter<MainActivity> {

    private MainActivity mView;
    private WordDataProvider dataProvider = new WordDataProvider();

    @Override
    public void attachView(MainActivity mainActivity) {
        mView = mainActivity;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    public void onFabClicked() {
        mView.showToast("Fab has been clicked");
    }

    public void onWordClicked(WordFromText wordFromText) {
        mView.showToast(wordFromText.getText() + " has been selected");
        dataProvider.procureTranslationsObservable(wordFromText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<String>>() {
            @Override
            public void onCompleted() {
                unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (e instanceof UnknownHostException) {
                    mView.showToast("Check internet connection");
                }
            }

            @Override
            public void onNext(List<String> translations) {
                mView.showTextTranslation(translations);
            }
        });
    }

    public void onButtonTranslateClick() {

    }
}
