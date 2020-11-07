package dev.dtrix.libraries;

import dev.dtrix.libraries.gson.Asset;
import org.apache.http.client.methods.HttpGet;

import java.util.LinkedList;
import java.util.Queue;

public class AssetsDownloader extends Thread {

    private Queue<Asset> downloadQueue = new LinkedList<>();
    private MinecraftVersion version;

    public AssetsDownloader(MinecraftVersion version) {
        this.version = version;
        //giHttpGet request = new HttpGet(version.get)
    }

    @Override
    public void run() {

    }
}
