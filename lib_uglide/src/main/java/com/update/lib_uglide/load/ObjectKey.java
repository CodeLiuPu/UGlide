package com.update.lib_uglide.load;

import com.update.lib_uglide.cache.Key;

import java.security.MessageDigest;

/**
 * @author : liupu
 * date    : 2019/12/24
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class ObjectKey implements Key {

    private final Object model;

    public ObjectKey(Object model) {
        this.model = model;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(model.toString().getBytes());
    }

    @Override
    public byte[] getKeyBytes() {
        return new byte[0];
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ObjectKey objectKey = (ObjectKey) object;

        return model != null ? model.equals(objectKey.model) : objectKey.model == null;
    }

    @Override
    public int hashCode() {
        return model != null ? model.hashCode() : 0;
    }
}
