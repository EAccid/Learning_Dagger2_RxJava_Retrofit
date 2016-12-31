package com.eaccid.txttranslator.libtranslator.lingualeo_impl.connection;

import java.util.Objects;

public enum ServiceStatus {

    SUCCEEDED, FAILED, UNAUTHORIZED, CONNECTION_ERROR;

    private ServiceStatus() {
    }

    public boolean getBooleanStatus() {
        return (Objects.equals(name(), SUCCEEDED.name()));
    }
}


