package com.eaccid.txttranslator.model.translator.lingualeo_impl.connection;

import java.util.List;


class LingualeoCookies {

    private String cookies = "";

    void setCookies(String cookies) {
        if (cookies == null) return;
        this.cookies = cookies;
    }

    String getCookies() {
        return cookies;
    }

    void setCookies(List<String> cookies) {

        StringBuilder sbCookie = new StringBuilder();
        for (String cookie: cookies
             ) {
            sbCookie.append(cookie.concat(";"));
        }
        this.cookies = sbCookie.toString();
    }
}
