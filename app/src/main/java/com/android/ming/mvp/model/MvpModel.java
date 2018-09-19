package com.android.ming.mvp.model;

import android.os.Handler;

import com.android.ming.mvp.interfaces.MvpCallback;


public class MvpModel {

    /**
     * 模拟网络获取数据
     *
     * @param param    请求参数
     * @param callback 数据回调接口
     */
    public static void getNetData(final String param, final MvpCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param) {
                    case "normal":
                        callback.onSuccess("根据参数" + param + "的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError();
                        break;
                }
                callback.onComplete();
            }
        }, 2000);
    }
}
