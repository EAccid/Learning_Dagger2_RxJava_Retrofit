package com.eaccid.txttranslator.presenter;

import android.os.AsyncTask;
import com.eaccid.txttranslator.libtranslator.lingualeo_impl.translator.TranslatorFactory;
import com.eaccid.txttranslator.libtranslator.lingualeo_impl.translator.Translators;
import com.eaccid.txttranslator.libtranslator.ytranslator_impl.Translator;
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
        new AsyncTest().execute();
    }

    private class AsyncTest extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {

            Translator translator = TranslatorFactory.newTranslator(Translators.YANDEX_TRANSLATOR);
            translator.translate("mad");
            System.out.println(translator.getTranslations());

            return null;
        }

    }

}
