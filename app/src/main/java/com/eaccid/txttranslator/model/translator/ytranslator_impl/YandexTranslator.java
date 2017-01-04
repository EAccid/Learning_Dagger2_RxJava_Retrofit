package com.eaccid.txttranslator.model.translator.ytranslator_impl;

import android.util.Log;

import com.eaccid.txttranslator.model.WordTranslation;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.ytranslator.YandexRetrofitService;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.ytranslator.YandexTranslationService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class YandexTranslator implements Translator {

    private static final String KEY = "trnsl.1.1.20170102T182143Z.3aee628aacf9fe84.e192f0a3b45ee5803afc2cdefc545fcdb49ddcf4";

    private YandexWordTranslation translation;

    @Override
    public boolean translate(final String sourceText) {

//        Gson gson = new GsonBuilder().create();
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .baseUrl(BASE_URL)
//                .build();
//        YandexTranslationService service = retrofit.create(YandexTranslationService.class);
//        Call<Object> call = service.translate(
//                KEY,
//                sourceText,
//                "en-ru"
//        );

//        try {
//            Response<Object> response = call.execute();
//            System.out.println(response.body());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        YandexTranslationService retrofitService = YandexRetrofitService.createTranslationService();
        Observable<WordTranslation> wordObs = retrofitService.translate(KEY,
                sourceText,
                "en-ru");

        wordObs.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(wordTranslation -> {
                    wordTranslation.setWord(sourceText);
                    return wordTranslation;
                })
                .subscribe(word -> {
                    Log.i("YandexTranslator", "" + word.getWord() + " - " +  word.getTranslates());
                });

        return false;

    }

    @Override
    public YandexWordTranslation getTranslations() throws NullPointerException {
        return translation;
    }


}
