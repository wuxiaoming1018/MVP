package com.android.ming.mvp.model;

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
}
