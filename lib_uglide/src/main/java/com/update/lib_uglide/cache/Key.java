package com.update.lib_uglide.cache;

import java.security.MessageDigest;

/**
 * @author : liupu
 * date    : 2019/12/24
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public interface Key {
    void updateDiskCacheKey(MessageDigest messageDigest);

    byte[] getKeyBytes();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
}
