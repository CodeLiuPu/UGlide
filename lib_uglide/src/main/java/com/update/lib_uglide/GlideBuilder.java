package com.update.lib_uglide;

import android.content.Context;

import com.update.lib_uglide.cache.MemoryCache;
import com.update.lib_uglide.load.Engine;
import com.update.lib_uglide.recycle.BitmapPool;

/**
 * @author : liupu
 * date   : 2019/12/25
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class GlideBuilder {

    Engine engine;
    BitmapPool bitmapPool;
    MemoryCache memoryCache;
    Context context;

    public GlideBuilder(Context context) {
        this.context = context.getApplicationContext();
    }

    public GlideBuilder setBitmapPool(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }

    public Glide build() {

        if (engine == null) {
            engine = new Engine(context);
        }

        return new Glide(this);
    }

}
