package com.eaccid.txttranslator.presenter;

import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import com.eaccid.txttranslator.provider.translator.WordTranslationProvider;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter implements BasePresenter<MainActivity> {

    private MainActivity mView;
    private WordTranslationProvider dataProvider = new WordTranslationProvider();
    private Subscription subscription;

    @Override
    public void attachView(MainActivity mainActivity) {
        mView = mainActivity;
    }

    @Override
    public void detachView() {
        mView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void onFabClicked() {
        mView.showToast("Fab has been clicked");
    }

    public void onWordClicked(WordFromText wordFromText) {
        makeTranslation(wordFromText.getText());
    }

    public void onButtonTranslateClick(String inputText) {
        makeTranslation(inputText);
    }

    private void makeTranslation(String text) {
        mView.showToast(text + " has been translated");
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = dataProvider
                .procureTranslationsObservable(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        String message = dataProvider.handleTranslationException(e);
                        mView.showToast(message);
                    }

                    @Override
                    public void onNext(List<String> translations) {
                        mView.showTextTranslation(translations);
                    }
                });
    }

}
