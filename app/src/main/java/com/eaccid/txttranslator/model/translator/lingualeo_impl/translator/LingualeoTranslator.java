package com.eaccid.txttranslator.model.translator.lingualeo_impl.translator;

import com.eaccid.txttranslator.model.LeoWordTranslation;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.connection.RequestHandler;
import com.eaccid.txttranslator.model.translator.lingualeo_impl.connection.RequestParameters;
import com.eaccid.txttranslator.model.translator.translator.Translator;

public class LingualeoTranslator implements Translator {

    private LeoWordTranslation translation;

    @Override
    public boolean translate(String word) {
        RequestParameters requestParameters = new RequestParameters();
        requestParameters.addParameter("word", word);
        RequestHandler requestHandler = RequestHandler.newUnauthorizedRequestWithParameters("http://lingualeo.com/api/gettranslates", requestParameters);
        requestHandler.handleRequest();
        translation = new LeoWordTranslation(requestHandler.getResponse());
        return !translation.isEmpty();
    }

    @Override
    public LeoWordTranslation getTranslation() throws NullPointerException {
        if (translation == null) throw new NullPointerException("WordFromTextImpl has not been translated");
        return translation;
    }

}
