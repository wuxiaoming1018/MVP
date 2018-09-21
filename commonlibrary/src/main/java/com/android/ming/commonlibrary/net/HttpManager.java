package com.android.ming.commonlibrary.net;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class HttpManager {

    private Retrofit mRetrofit;
    private String mBaseUrl;
    private OkHttpClient mClient;
    private boolean debug = true;

    public HttpManager() {
    }

    public static HttpManager getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final HttpManager INSTANCE = new HttpManager();
    }

    /**
     * 设置baseUrl
     *
     * @param baseUrl
     * @return
     */
    public HttpManager setBaseUrl(String baseUrl) {
        this.mBaseUrl = baseUrl;
        return Holder.INSTANCE;
    }

    /**
     * 设置OkHttpClient
     *
     * @param client
     * @return
     */
    public HttpManager setOkHttpClient(OkHttpClient client) {
        this.mClient = client;
        return Holder.INSTANCE;
    }

    public void setRetrofit(Retrofit mRetrofit) {
        this.mRetrofit = mRetrofit;
    }

    public HttpManager setDebug(boolean debug) {
        this.debug = debug;
        return Holder.INSTANCE;
    }

    /**
     * 创建api实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getApiService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

    public Retrofit createRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(mClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addCallAdapterFactory(ObserveOnMainCallAdapterFactory.createMainScheduler());
        return builder.build();
    }
}
