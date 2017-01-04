package com.eaccid.txttranslator.presenter;

import com.eaccid.txttranslator.model.translator.lingualeo_impl.translator.TranslatorFactory;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.translator.Translators;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.Translator;
import com.eaccid.txttranslator.provider.fromtext.WordFromText;

public class MainPresenter implements BasePresenter<MainActivity> {

    private MainActivity mView;

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
        Translator translator = TranslatorFactory.newTranslator(Translators.YANDEX_TRANSLATOR);
        translator.translate(wordFromText.getText());
        System.out.println(translator.getTranslations());
    }

}
