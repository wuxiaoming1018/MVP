package com.android.ming.mvp.base.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.ming.mvp.R;
import com.android.ming.mvp.base.interfaces.BaseView;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ProgressDialog mProgressDialog;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mContext = this;
    }

    protected abstract void initView();

    protected abstract int getLayout();

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
