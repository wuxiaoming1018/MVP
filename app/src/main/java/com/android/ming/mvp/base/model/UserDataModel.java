package com.android.ming.mvp.base.model;

import android.os.Handler;

import com.android.ming.mvp.base.interfaces.CallBack;

public class UserDataModel extends BaseModel<String> {
    @Override
    public void execute(final CallBack<String> callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (mParams[0]) {
                    case "normal":
                        callback.onSuccess("根据参数" + mParams[0] + "的请求网络数据成功");
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
