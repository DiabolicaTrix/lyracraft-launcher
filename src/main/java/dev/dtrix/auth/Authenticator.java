package dev.dtrix.auth;

public class Authenticator {

    private static Authenticator instance;

    private Authenticator() {}

    public AuthResult authenticate(String token) {
        return new AuthRequest(RequestType.REFRESH).string("accessToken", token).build();
    }

    public AuthResult authenticate(String username, String password) {
        return new AuthRequest(RequestType.AUTHENTICATE).username(username).password(password).addDefaultHeader().build();
    }

    public static Authenticator getInstance() {
        if(instance == null){
            instance = new Authenticator();
        }
        return instance;
    }
}
