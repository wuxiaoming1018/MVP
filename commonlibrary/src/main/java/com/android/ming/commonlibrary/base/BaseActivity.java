package com.android.ming.commonlibrary.base;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayoutId());
        init(savedInstanceState);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        List<String> granted = new ArrayList<>();//允许的权限
        List<String> denied = new ArrayList<>();//拒绝的权限
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i]== PackageManager.PERMISSION_GRANTED) {
                granted.add(permissions[i]);
            }else{
                denied.add(permissions[i]);
            }
        }
        //允许的权限
        if (granted.size()>0) {
            onPermissionGranted(requestCode,granted);
        }
        //拒绝权限
        if (denied.size()>0) {
            onPermissionDenied(requestCode,denied);
        }
        if (denied.size()==0&&granted.size()>0) {
            //所有权限都通过
            onAllPermissionGranted(requestCode);
        }
    }

    protected void onAllPermissionGranted(int requestCode) {

    }

    /**
     *
     * @param requestCode
     * @param denied
     */
    protected void onPermissionDenied(int requestCode, List<String> denied) {

    }

    protected void onPermissionGranted(int requestCode, List<String> granted) {

    }

    public void start(Class<? extends AppCompatActivity> clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }

    public void start(Class<? extends AppCompatActivity> clazz,Bundle bundle){
        Intent intent = new Intent(this,clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startForResult(Class<? extends AppCompatActivity> clazz,int requestCode){
        Intent intent = new Intent(this,clazz);
        startActivityForResult(intent,requestCode);
    }

    public void startForResult(Class<? extends AppCompatActivity> clazz,int requestCode,Bundle bundle){
        Intent intent = new Intent(this,clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent,requestCode);
    }

    protected abstract int getResourceLayoutId();

    protected abstract void init(Bundle savedInstanceState);
}
