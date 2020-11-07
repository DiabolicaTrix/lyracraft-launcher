package dev.dtrix.libraries;

import com.google.gson.Gson;
import dev.dtrix.libraries.gson.Version;
import dev.dtrix.libraries.gson.Versions;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.omg.IOP.CodecFactoryPackage.UnknownEncoding;

import java.io.IOException;

public class VersionManager {

    private Versions CACHED_VERSION_LIST;

    private void fetchVersions() {
        HttpGet request = new HttpGet(MinecraftVersion.ASSETS_URL + "/mc/game/version_manifest.json");
        request.addHeader(HttpHeaders.ACCEPT, "application/json");
        try(CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse response = httpClient.execute(request)){
            Gson gson = new Gson();
            CACHED_VERSION_LIST = gson.fromJson(EntityUtils.toString(response.getEntity()), Versions.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Version getVersion(MinecraftVersion version) {
        if(CACHED_VERSION_LIST == null) {
            fetchVersions();
        }
        //TODO handle unknow version
        return CACHED_VERSION_LIST.getVersionList().stream().filter(element -> version.getVersionId().equalsIgnoreCase(element.getId())).findAny().orElse(null);
    }

    private String getAssetsUrl(MinecraftVersion version) {
        return getVersion(version).url;
    }

}
