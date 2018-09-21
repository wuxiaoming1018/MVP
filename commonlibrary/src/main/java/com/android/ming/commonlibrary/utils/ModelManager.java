package com.android.ming.commonlibrary.utils;

import com.android.ming.commonlibrary.base.IBaseModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public class ModelManager {

    private final ConcurrentHashMap<Class<? extends IBaseModel>, ? extends IBaseModel> DATA_CACHE;

    public ModelManager() {
        DATA_CACHE = new ConcurrentHashMap<>();
    }

    public static ModelManager getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final ModelManager INSTANCE = new ModelManager();
    }

    public <M extends IBaseModel> M create(Class<?> clazz) {
        IBaseModel model = DATA_CACHE.get(clazz);
        if (model != null) {
            return (M) model;
        }
        synchronized (DATA_CACHE) {
            model = DATA_CACHE.get(clazz);
            if (model == null) {
                try {
                    Constructor<M> constructor = (Constructor<M>) clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);
                    model = constructor.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return (M) model;
    }
}
