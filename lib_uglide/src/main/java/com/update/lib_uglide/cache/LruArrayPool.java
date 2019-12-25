package com.update.lib_uglide.cache;

import android.util.LruCache;

public class LruArrayPool implements ArrayPool {

    public static final int ARRAY_POOL_SIZE_BYTES = 4 * 1024 * 1024;
    private final int maxSize;

    private LruCache<Integer, byte[]> cache;


    public LruArrayPool() {
        this(ARRAY_POOL_SIZE_BYTES);
    }

    public LruArrayPool(int maxSize) {
        this.maxSize = maxSize;

    }

    @Override
    public byte[] get(int len) {
        return new byte[0];
    }

    @Override
    public void put(byte[] data) {

    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public void clearMemory() {
        cache.evictAll();
    }

    @Override
    public void trimMemory(int level) {
        if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_BACKGROUND) {
            clearMemory();
        } else if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN
                || level == android.content.ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL) {
            cache.trimToSize(maxSize / 2);
        }
    }


}