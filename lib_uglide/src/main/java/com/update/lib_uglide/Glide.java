package com.update.lib_uglide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;

/**
 * @author : liupu
 * date   : 2019/12/24
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class Glide implements ComponentCallbacks2 {

    private static volatile Glide glide;
    private final Context context;
    private final Registry registry;

    Glide(Context context) {
        this.context = context.getApplicationContext();

        // 注册机
        registry = new Registry();
    }

    @Override
    public void onTrimMemory(int level) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onLowMemory() {

    }
}
