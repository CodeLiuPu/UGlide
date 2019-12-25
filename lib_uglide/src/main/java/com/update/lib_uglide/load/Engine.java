package com.update.lib_uglide.load;

import android.content.Context;

import com.update.lib_uglide.cache.ActiveResources;
import com.update.lib_uglide.cache.Key;
import com.update.lib_uglide.cache.MemoryCache;
import com.update.lib_uglide.recycle.Resource;

/**
 * @author : liupu
 * date   : 2019/12/25
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Engine implements Resource.ResourceListener {
    private Context context;

    ActiveResources activeResources;
    MemoryCache memoryCache;

    public Engine(Context context,MemoryCache memoryCache) {
        this.context = context;
        this.activeResources = new ActiveResources(this);
        this.memoryCache = memoryCache;
    }

    /**
     * 引用计数为 0 回调
     * 将其从正在使用集合移除, 并 加入内存缓存
     */
    @Override
    public void onResourceReleased(Key key, Resource resource) {

    }
}
