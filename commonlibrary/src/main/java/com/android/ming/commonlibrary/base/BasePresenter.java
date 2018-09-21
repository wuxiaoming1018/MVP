package com.android.ming.commonlibrary.base;

import com.android.ming.commonlibrary.utils.ModelManager;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends IBaseView> {

    protected V mView;

    private CompositeDisposable mDisposables;

    /**
     * 绑定view层
     *
     * @param view
     * @param <T>
     */
    public <T extends IBaseView> void attachView(T view) {
        this.mView = (V) view;
        mDisposables = new CompositeDisposable();
    }

    /**
     * 解绑
     */
    public void detachView() {
        mDisposables.clear();
        mDisposables = null;
        mView = null;
    }

    private boolean addDisposable(Disposable disposable) {
        if (isNullOrDisposed(disposable)) {
            return false;
        }
        return mDisposables.add(disposable);
    }

    private boolean isNullOrDisposed(Disposable disposable) {
        return disposable == null || disposable.isDisposed();
    }

    protected <M extends IBaseModel> M getModel(Class<M> clazz){
        return ModelManager.getInstance().create(clazz);
    }
}
