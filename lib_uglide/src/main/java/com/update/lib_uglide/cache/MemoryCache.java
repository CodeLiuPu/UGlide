package com.update.lib_uglide.cache;

import com.update.lib_uglide.recycle.Resource;

/**
 * @author : liupu
 * date    : 2019/12/24
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public interface MemoryCache {

    interface ResourceRemovedListener {
        void onResourceRemoved(Resource resource);
    }

    Resource remove2(Key key);

    Resource put(Key key, Resource resource);

    void setResourceRemovedListener(ResourceRemovedListener listener);

    void clearMemory();

    void trimMemory(int level);
}
