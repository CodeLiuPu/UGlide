package com.update.lib_uglide.load;

import com.update.lib_uglide.cache.Key;

import java.security.MessageDigest;

/**
 * @author : liupu
 * date    : 2019/12/24
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class EngineKey implements Key {

    private final Object model;
    private final int width;
    private final int height;
    private int hashCode;

    public EngineKey(Object model, int width, int height) {
        this.model = model;
        this.width = width;
        this.height = height;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(getKeyBytes());
    }

    @Override
    public byte[] getKeyBytes() {
        return toString().getBytes();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null && getClass() != obj.getClass()) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (width != engineKey.width
                || height != engineKey.height
                || hashCode != engineKey.hashCode) {
            return false;
        }
        return model != null ? model.equals(engineKey.model) : engineKey.model == null;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + width;
        result = 31 * result + height;
        result = 31 * result + hashCode;
        return result;
    }

    @Override
    public String toString() {
        return "EngineKey{" +
                "model=" + model +
                ", width=" + width +
                ", height=" + height +
                ", hashCode=" + hashCode +
                '}';
    }
}
