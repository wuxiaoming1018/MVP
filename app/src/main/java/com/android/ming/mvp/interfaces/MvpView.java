package com.android.ming.mvp.interfaces;

import com.android.ming.mvp.base.interfaces.BaseView;

public interface MvpView extends BaseView {

    /**
     * 数据请求成功后，调用此方法显示数据
     *
     * @param data 数据源
     */
    void showData(String data);
}
