package com.update.lib_uglide.recycle;

import android.graphics.Bitmap;

/**
 * @author : liupu
 * date   : 2019/12/24
 * desc   : 复用池
 * github : https://github.com/CodeLiuPu/
 */
public interface BitmapPool {


    void put(Bitmap bitmap);

    Bitmap get(int width, int height, Bitmap.Config config);

    void clearMemory();

    void trimMemory();
}
