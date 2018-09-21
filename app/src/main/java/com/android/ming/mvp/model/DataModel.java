package com.android.ming.mvp.model;


import com.android.ming.mvp.base.interfaces.BaseView;
import com.android.ming.mvp.base.model.BaseModel;

public class DataModel {
    public static BaseModel request(String token) {
        BaseModel model = null;
        try {
            model = (BaseModel) Class.forName(token).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }

    public static BaseModel request(Class clazz) {
        BaseModel model = null;
        // 判断class对象是不是BaseModel的实例
        try {
            //利用反射机制获得对应Model对象的引用
            if (clazz == BaseModel.class) {
                model = (BaseModel) clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}
