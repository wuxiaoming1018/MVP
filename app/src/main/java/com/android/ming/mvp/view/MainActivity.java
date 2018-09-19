package com.android.ming.mvp.view;

import android.app.ProgressDialog;
import android.view.View;
import android.widget.TextView;

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
        presenter.showData("normal");
    }

    public void getDataForFailure(View view) {
        presenter.showData("failure");
    }

    // button 点击事件调用方法
    public void getDataForError(View view) {
        presenter.showData("error");
    }


    @Override
    public void showData(String data) {
        text.setText(data);
    }
}
