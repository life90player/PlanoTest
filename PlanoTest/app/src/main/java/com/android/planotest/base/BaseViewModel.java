package com.android.planotest.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.android.planotest.T;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BaseViewModel extends ViewModel implements LifecycleObserver {
    private Subscription mSubscription;

    public void showProgress(){
        AccountApplication.getActivities().lastElement().showLoading();
    }

    public void hideProgress(){
        AccountApplication.getActivities().lastElement().hideLoading();
    }

    public void showToast(String message){
        T.showToast(message);
    }

    public boolean isEmpty(CharSequence c){
        return T.isEmpty(c);
    }

    public <D>Subscription request(Observable<BaseResponse<D>> retrofit, BaseSubscriber<BaseResponse<D>> subscriber){
        mSubscription =  retrofit
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        return mSubscription;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy(){
        if (null == mSubscription){
            return;
        }
        mSubscription.unsubscribe();
    }

}
