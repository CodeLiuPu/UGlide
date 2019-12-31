package com.update.lib_uglide.load.codec;

import android.graphics.Bitmap;

import java.io.IOException;

/**
 * @author : liupu
 * date   : 2019/12/31
 * github : https://github.com/CodeLiuPu/
 * desc   :
 */
public interface ResourceDecoder<T> {

    boolean handles(T source) throws IOException;

    Bitmap decode(T source, int width, int height) throws IOException;

}
