package com.android.ming.mvp.interfaces;

public interface MvpView {
    /**
     * 显示正在加载的进度框
     */
    void showLoading();

    /**
     * 隐藏正在加载的进度框
     */
    void hideLoading();

    /**
     * 数据请求成功后，调用此方法显示数据
     * @param data
     */
    void showData(String data);

    /**
     * 当数据请求失败后，调用此方法
     * @param msg
     */
    void showFailureMessage(String msg);

    /**
     * 当数据请求异常,调用此方法
     */
    void showErrorMessage();
}
