package com.android.ming.mvp.base.model;

import com.android.ming.mvp.base.interfaces.CallBack;

public abstract class BaseModel<T> {

    //数据请求参数
    protected String[] mParams;

    public BaseModel params(String... mParams) {
        this.mParams = mParams;
        return this;
    }

    /**
     * 添加callback并执行数据请求
     * 具体数据请求由子类来实现
     *
     * @param callBack
     */
    public abstract void execute(CallBack<T> callBack);

    /**
     * 执行GET网络请求
     *
     * @param url
     * @param callback
     */
    public void requestGetAPI(String url, CallBack<T> callback) {

    }

    /**
     * 执行POSt网络请求
     *
     * @param url
     * @param callBack
     */
    public void requestPostAPI(String url, CallBack<T> callBack) {

    }
}
