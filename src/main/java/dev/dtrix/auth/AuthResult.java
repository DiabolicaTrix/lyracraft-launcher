package dev.dtrix.auth;

import lombok.Getter;

@Getter
public class AuthResult {

    private ResultType type;
    private String message;

    public AuthResult(ResultType type, String message) {
        this.type = type;
        this.message = message;
    }

    public enum ResultType {
        SUCCESS,
        ERROR;
    }
}
