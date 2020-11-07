package dev.dtrix.libraries;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.Getter;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MinecraftVersion {

    public static final String ASSETS_URL = "https://launchermeta.mojang.com/";
    @Getter
    private String versionId;

    public MinecraftVersion(String version) {
        this.versionId = version;
    }


}
