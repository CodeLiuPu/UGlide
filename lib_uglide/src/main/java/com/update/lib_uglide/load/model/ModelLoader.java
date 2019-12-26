package com.update.lib_uglide.load.model;

import com.update.lib_uglide.cache.Key;
import com.update.lib_uglide.load.model.data.DataFetcher;

/**
 * @author : liupu
 * date   : 2019/12/26
 * desc   :
 * github : https://github.com/CodeLiuPu/
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
    LoadData<Data> buildLoadData(Model model);

    boolean handles(Model model);
}
