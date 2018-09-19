package com.android.ming.mvp.presenter;

import com.android.ming.mvp.base.interfaces.CallBack;
import com.android.ming.mvp.base.model.Token;
import com.android.ming.mvp.base.model.UserDataModel;
import com.android.ming.mvp.base.presenter.BasePresenter;
import com.android.ming.mvp.interfaces.MvpCallback;
import com.android.ming.mvp.interfaces.MvpView;
import com.android.ming.mvp.model.DataModel;
import com.android.ming.mvp.model.MvpModel;

public class MvpPresenter extends BasePresenter<MvpView> {


    /**
     * 链接V层和M层，进行数据传递
     *
     * @param params
     */
    public void getData(String params) {
        if (!isViewAttached()) {
            return;
        }
        getView().showLoading();
        MvpModel.getNetData(params, new MvpCallback() {
            @Override
            public void onSuccess(String data) {
                if (isViewAttached()) {
                    getView().showData(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()) {
                    getView().showToast(msg);
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()) {
                    getView().showErr();
                }
            }

            @Override
            public void onComplete() {
                if (isViewAttached()) {
                    getView().hideLoading();
                }
            }
        });
    }

    public void showData(String params){
        if (!isViewAttached()) {
            return;
        }
        getView().showLoading();
        DataModel.request(UserDataModel.class)
                .params(params)
                .execute(new CallBack<String>(){

                    @Override
                    public void onSuccess(String data) {
                        if (isViewAttached()) {
                            getView().showData(data);
                        }
                    }

                    @Override
                    public void onFailure(String msg) {
                        if (isViewAttached()) {
                            getView().showToast(msg);
                        }
                    }

                    @Override
                    public void onError() {
                        if (isViewAttached()) {
                            getView().showErr();
                        }
                    }

                    @Override
                    public void onComplete() {
                        if (isViewAttached()) {
                            getView().hideLoading();
                        }
                    }
                });
    }
}
