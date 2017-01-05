package com.eaccid.txttranslator.model.translator.ytranslator_impl;

import android.util.Log;

import com.eaccid.txttranslator.model.YandexWordTranslation;
import com.eaccid.txttranslator.model.translator.translator.TextTranslation;
import com.eaccid.txttranslator.model.translator.translator.Translator;

import java.net.SocketTimeoutException;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class YandexTranslator implements Translator {

    private static final String KEY = "trnsl.1.1.20170102T182143Z.3aee628aacf9fe84.e192f0a3b45ee5803afc2cdefc545fcdb49ddcf4";
    private TextTranslation translation;

    public YandexTranslator() {
        translation = new YandexWordTranslation();
    }

    //TODO refactor: add OkHttpClient, injections
    //temp translation
    @Override
    public boolean translate(final String sourceText) {
        YandexTranslationService retrofitService = YandexRetrofitService.createTranslationService();
        retrofitService.translate(KEY, sourceText, "en-ru")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(wordTranslation -> {
                    wordTranslation.setWord(sourceText);
                    return wordTranslation;
                })
                .subscribe(new Subscriber<YandexWordTranslation>() {
                    @Override
                    public void onCompleted() {
                        unsubscribe();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if(e instanceof SocketTimeoutException){
                            //TODO handle exception
                        }
                    }

                    @Override
                    public void onNext(YandexWordTranslation word) {
                        setTranslation(word);
                        Log.i("YandexTranslator", "translation: " + word.getWord() + " - " + word.getTranslates());
                    }
                });
        return true;

    }

    @Override
    public TextTranslation getTranslation() throws NullPointerException {
        return translation;
    }

    public void setTranslation(TextTranslation translation) {
        this.translation = translation;
    }
}
