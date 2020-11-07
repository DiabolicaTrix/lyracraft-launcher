package dev.dtrix.auth;

public class Test {

    public static void main(String[] args) {
        new AuthRequest(RequestType.AUTHENTICATE).username("DiabolicaTrix").password("s").build();
    }

}
