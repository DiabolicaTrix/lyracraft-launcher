package dev.dtrix.auth;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.util.HashMap;

public class AuthRequest {
    public static final String MOJANG_URL = "https://authserver.mojang.com";
    private static final Gson gson = new Gson();

    private final RequestType type;
    private final HashMap<String, String> paramsMap = new HashMap<>();

    public AuthRequest(RequestType type){
        this.type = type;
    }

    public AuthRequest string(String key, String value) {
        paramsMap.put(key, value);
        return this;
    }

    public AuthRequest username(String username) {
        string("username", username);
        return this;
    }

    public AuthRequest password(String password) {
        string("password", password);
        return this;
    }

    public AuthResult build() {
        HttpPost request = new HttpPost(MOJANG_URL + "/" + type.endpoint);
        request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json; utf-8");
        request.addHeader(HttpHeaders.ACCEPT, "application/json");
        try {
            request.setEntity(new StringEntity(getParams()));
        } catch (UnsupportedEncodingException e) {
            //TODO handle exceptions
            e.printStackTrace();
        }
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)){
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AuthResult(AuthResult.ResultType.SUCCESS, "test");
    }

    public AuthRequest addDefaultHeader() {
        Gson gson = new Gson();
        HashMap<String, String> test = new HashMap<>();
        //TODO Remove hardcoded values
        test.put("name", "Minecraft");
        test.put("version", "1");
        paramsMap.put("agent", gson.toJson(test));
        return this;
    }

    private String getParams() {
        return gson.toJson(paramsMap);
    }

}
