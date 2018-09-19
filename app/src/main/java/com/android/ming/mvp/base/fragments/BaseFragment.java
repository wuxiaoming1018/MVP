package com.android.ming.mvp.base.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.ming.mvp.base.interfaces.BaseView;
import com.android.ming.mvp.base.view.BaseActivity;

public abstract class BaseFragment extends Fragment implements BaseView {

    private Context mContext;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getContentViewId(), container, false);
        this.mContext = getActivity();
        initAllMemberView(savedInstanceState);
        return mRootView;
    }

    protected abstract void initAllMemberView(Bundle savedInstanceState);

    protected abstract int getContentViewId();

    @Override
    public void showLoading() {
        checkActivityAttached();
        ((BaseActivity) mContext).showLoading();
    }

    @Override
    public void hideLoading() {
        checkActivityAttached();
        ((BaseActivity) mContext).hideLoading();
    }

    @Override
    public void showToast(String msg) {
        checkActivityAttached();
        ((BaseActivity) mContext).showToast(msg);
    }

    @Override
    public void showErr() {
        checkActivityAttached();
        ((BaseActivity) mContext).showErr();
    }

    private void checkActivityAttached() {
        if (getActivity() == null) {
            throw new ActivityNotFoundException("Fragment has disconnected from activity --00");
        }
    }
}
