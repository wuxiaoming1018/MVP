package com.android.ming.mvp.presenter;

import com.android.ming.mvp.interfaces.MvpCallback;
import com.android.ming.mvp.interfaces.MvpView;
import com.android.ming.mvp.model.MvpModel;

public class MvpPresenter {
    //持有View层引用
    private MvpView mView;
    //持有model层引用
    private MvpModel mModel;

    public MvpPresenter(MvpView mView) {
        this.mView = mView;
        mModel = new MvpModel();
    }

    /**
     * 链接V层和M层，进行数据传递
     * @param params
     */
    public void getData(String params){
        mView.showLoading();
        mModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                mView.showData(data);
            }

            @Override
            public void onFailure(String msg) {
                mView.showFailureMessage(msg);
            }

            @Override
            public void onError() {
                mView.showErrorMessage();
            }

            @Override
            public void onComplete() {
                mView.hideLoading();
            }
        });
    }
}
