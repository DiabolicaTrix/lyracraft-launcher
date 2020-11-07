package dev.dtrix.auth;

import java.util.List;

public enum RequestType {
    AUTHENTICATE("authenticate"),
    REFRESH("refresh");

    String endpoint;

    RequestType(String endpoint) {
        this.endpoint = endpoint;
    }
}
