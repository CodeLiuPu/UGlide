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


    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {

    }

    @Override
    public byte[] getKeyBytes() {
        return new byte[0];
    }
}
