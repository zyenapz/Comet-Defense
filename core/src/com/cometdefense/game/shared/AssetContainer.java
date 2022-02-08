package com.cometdefense.game.shared;

import com.badlogic.gdx.graphics.Texture;

import java.util.Hashtable;

public class AssetContainer {
    private Hashtable<AssetID, Texture> texturesHashtable;

    public AssetContainer() {
        texturesHashtable = new Hashtable<AssetID, Texture>();
    }
    public void loadTexture(AssetID id, String path) {
        Texture texture = new Texture(path);
        texturesHashtable.put(id, texture);
    }
    public Texture fetchTexture(AssetID id) {
        Texture fetched = texturesHashtable.get(id);

        if(fetched != null) {
            return fetched;
        }
        else {
            String errorMsg = "[ERROR]: AssetContainer tried to fetch texture resource " + id.toString() + ", but texture does not exist.";
            System.out.println(errorMsg);
            return null;
        }

    }
    public void dispose() {
        for(Texture tex : texturesHashtable.values()) {
            tex.dispose();
        }
    }
}
