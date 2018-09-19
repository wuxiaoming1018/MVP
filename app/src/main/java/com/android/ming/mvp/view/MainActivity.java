package com.android.ming.mvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.ming.mvp.R;
import com.android.ming.mvp.base.view.BaseActivity;
import com.android.ming.mvp.interfaces.MvpView;
import com.android.ming.mvp.presenter.MvpPresenter;

public class MainActivity extends BaseActivity implements MvpView {

    private ProgressDialog progressDialog;
    private TextView text;
    private MvpPresenter presenter;

    @Override
    protected void initView() {
        text = (TextView) findViewById(R.id.text);
        presenter = new MvpPresenter();
        presenter.attachView(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public void getData(View view) {
        presenter.getData("normal");
    }

    public void getDataForFailure(View view) {
        presenter.getData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view) {
        presenter.getData("error");
    }


    @Override
    public void showData(String data) {
        text.setText(data);
    }
}
