package com.android.ming.commonlibrary.net;

import android.support.annotation.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class ObserveOnMainCallAdapterFactory extends CallAdapter.Factory {

    private Scheduler scheduler;

    public ObserveOnMainCallAdapterFactory(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType = getRawType(returnType);
        if (rawType != String.class) {
            return null;
        }
        final CallAdapter<Object, Single<?>> delegate = (CallAdapter<Object, Single<?>>) retrofit.nextCallAdapter(this, returnType, annotations);
        return new CallAdapter<Object, Object>() {
            @Override
            public Type responseType() {
                return delegate.responseType();
            }

            @Override
            public Object adapt(Call<Object> call) {
                Single<?> adapt = delegate.adapt(call);
                return adapt.observeOn(scheduler);
            }
        };
    }

    public static CallAdapter.Factory createMainScheduler(){
        return new ObserveOnMainCallAdapterFactory(AndroidSchedulers.mainThread());
    }
}
