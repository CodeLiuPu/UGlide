package com.update.lib_uglide;

import java.io.File;

/**
 * @author : liupu
 * date   : 2019/12/25
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface ModelTypes<T> {
    T load(String string);

    T load(File file);
}
