package com.eaccid.txttranslator.model.translator.lingualeo_impl.translator;

import com.eaccid.txttranslator.model.translator.lingualeo_impl.connection.RequestHandler;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.connection.RequestParameters;
import com.eaccid.txttranslator.model.translator.ytranslator_impl.Translator;

public class LingualeoTranslator implements Translator {

    private WordTranslation translation;

    @Override
    public boolean translate(String word) {
        RequestParameters requestParameters = new RequestParameters();
        requestParameters.addParameter("word", word);
        RequestHandler requestHandler = RequestHandler.newUnauthorizedRequestWithParameters("http://lingualeo.com/api/gettranslates", requestParameters);
        requestHandler.handleRequest();
        translation = new WordTranslation(requestHandler.getResponse());
        return !translation.isEmpty();
    }

    @Override
    public WordTranslation getTranslations() throws NullPointerException {
        if (translation == null) throw new NullPointerException("WordFromTextImpl has not been translated");
        return translation;
    }

}
