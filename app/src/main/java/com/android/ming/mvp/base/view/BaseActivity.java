package com.android.ming.mvp.base.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.ming.mvp.R;
import com.android.ming.mvp.base.interfaces.BaseView;
import com.android.ming.mvp.base.presenter.BasePresenter;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressDialog mProgressDialog;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourcesId());
        initView();
        initPresenter();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mContext = this;
        if(getPresenter()!=null){
            getPresenter().attachView(this);
        }
    }

    protected abstract BasePresenter getPresenter();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract int getResourcesId();

    @Override
    public void showLoading() {
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        showToast(getResources().getString(R.string.api_error_msg));
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
