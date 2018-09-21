package com.android.ming.commonlibrary.base;

public interface IBaseView {

    /**
     * 显示文本信息
     * @param msg
     */
    void showMsg(String msg);

    /**
     * 显示loading
     */
    void showLoading();

    /**
     * 显示带文本loading
     * @param msg
     */
    void showLoading(String msg);

    /**
     * 隐藏loading
     */
    void hideLoading();
}
