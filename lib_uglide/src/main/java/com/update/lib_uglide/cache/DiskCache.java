package com.update.lib_uglide.cache;

import java.io.File;

/**
 * @author : liupu
 * date   : 2019/12/26
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface DiskCache {

    interface Writer {
        boolean write(File file);
    }

    File get(Key key);

    void put(Key key, Writer writer);

    void delete(Key key);

    void clear();
}
