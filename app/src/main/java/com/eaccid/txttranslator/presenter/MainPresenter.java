package com.eaccid.txttranslator.presenter;

import com.eaccid.txttranslator.provider.fromtext.WordFromText;
import com.eaccid.txttranslator.provider.translator.WordDataProvider;

import java.util.List;

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

    }

    public void onWordClicked(WordFromText wordFromText) {
        mView.showToast(wordFromText.getText());
        List<String> translations = dataProvider.procureTranslations(wordFromText);
        mView.showTextTranslation(translations);
    }

}
