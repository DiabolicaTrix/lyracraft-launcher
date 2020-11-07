package dev.dtrix.libraries.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import dev.dtrix.libraries.MinecraftVersion;
import lombok.Getter;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
@Getter
public class Versions {

    public List<Version> versionList;

}
