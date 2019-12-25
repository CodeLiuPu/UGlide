package com.update.lib_uglide.recycle;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

/**
 * @author : liupu
 * date   : 2019/12/25
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class LruBitmapPool extends LruCache<LruBitmapPool.Key, Bitmap> implements BitmapPool {

    public LruBitmapPool(int maxSize) {
        super(maxSize);
    }

    @Override
    public void put(Bitmap bitmap) {
        // 必须是可变的才能复用
        if (!bitmap.isMutable()) {
            bitmap.recycle();
            return;
        }

        // bitmap太大, 不复用
        int size = getSize(bitmap);
        if (size >= maxSize()) {
            bitmap.recycle();
            return;
        }

        Key key = new Key(size, bitmap.getConfig());
        put(key, bitmap);
    }

    @Override
    public Bitmap get(int width, int height, Bitmap.Config config) {
        return null;
    }

    @Override
    public void clearMemory() {
        evictAll();
    }

    @Override
    public void trimMemory(int level) {
        if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_BACKGROUND) {
            clearMemory();
        } else if (level >= android.content.ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            trimToSize(maxSize() / 2);
        }
    }

    public int getSize(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return bitmap.getAllocationByteCount();
        } else {
            return bitmap.getByteCount();
        }
    }

    public int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        } else {
            return 2;
        }
    }

    public int getSize(int width, int height, Bitmap.Config config) {
        return width * height * getBytesPerPixel(config);
    }

    @Override
    protected int sizeOf(Key key, Bitmap value) {
        return getSize(value);
    }

    @Override
    protected void entryRemoved(boolean evicted, Key key, Bitmap oldValue, Bitmap newValue) {
        oldValue.recycle();
    }

    class Key {
        int size;
        Bitmap.Config config;

        public Key(int size, Bitmap.Config config) {
            this.size = size;
            this.config = config;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Key key = (Key) obj;
            if (size != key.size) {
                return false;
            }

            return config == key.config;
        }

        @Override
        public int hashCode() {
            int result = size;
            result = 31 * result + (config != null ? config.hashCode() : 0);
            return result;
        }
    }
}
