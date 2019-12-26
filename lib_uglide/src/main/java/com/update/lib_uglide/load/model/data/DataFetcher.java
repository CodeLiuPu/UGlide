package com.update.lib_uglide.load.model.data;

/**
 * @author : liupu
 * date   : 2019/12/26
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface DataFetcher<T> {

    interface DataFetcherCallback<T> {
        void onFetcherReady(T data);

        void onLoadFailed(Exception e);
    }

    void loadData(DataFetcherCallback<? super T> callback);

    void cancel();

    Class<T> getDataClass();
}
