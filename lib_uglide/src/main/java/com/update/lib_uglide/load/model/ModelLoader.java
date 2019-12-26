package com.update.lib_uglide.load.model;

import com.update.lib_uglide.cache.Key;
import com.update.lib_uglide.load.model.data.DataFetcher;

/**
 * @param <Model>: 表示数据的来源
 * @param <Data>:  表示加载成功后数据的类型(InputStream, byte[])
 * @author : liupu
 * @date   : 2019/12/26
 * github : https://github.com/CodeLiuPu/
 * desc   : 模型加载器
 */
public interface ModelLoader<Model, Data> {

    interface ModelLoaderFactory<Model, Data> {
        ModelLoader<Model, Data> build(ModelLoaderRegistry modelLoaderRegistry);
    }

    class LoadData<Data> {
        public final Key sourceKey;
        public final DataFetcher<Data> fetcher;

        public LoadData(Key sourceKey, DataFetcher<Data> fetcher) {
            this.sourceKey = sourceKey;
            this.fetcher = fetcher;
        }
    }

    /**
     * 创建加载数据
     */
    LoadData<Data> buildLoadData(Model model);

    /**
     * 判断处理对应 Model 的数据
     */
    boolean handles(Model model);
}
