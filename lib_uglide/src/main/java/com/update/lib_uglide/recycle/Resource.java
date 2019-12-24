package com.update.lib_uglide.recycle;

import android.graphics.Bitmap;

import com.update.lib_uglide.cache.Key;

/**
 * @author : liupu
 * date   : 2019/12/24
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Resource {

    private Bitmap bitmap;

    /**
     * 引用计数
     * 当为0时, 回调ResourceListener
     * 将图片存入内存缓存
     */
    private int acquired;

    private Key key;

    private ResourceListener listener;

    public interface ResourceListener {
        void onResourceReleased(Key key, Resource resource);
    }

    public Resource(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setResourceListener(Key key, ResourceListener listener) {
        this.key = key;
        this.listener = listener;
    }

    public void acquire() {
        if (null != bitmap && bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        ++acquired;
    }

    public void release() {
        if (--acquired == 0) {
            listener.onResourceReleased(key, this);
        }
    }

    public void recycle() {
        if (acquired > 0) {
            return;
        }
        if (null != bitmap && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
}
