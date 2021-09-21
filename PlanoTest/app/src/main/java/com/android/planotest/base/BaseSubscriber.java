package com.android.planotest.base;

import rx.Subscriber;

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onError(Throwable e) {
        onCompleted();
        onException(e);
    }

    public abstract void onException(Throwable e);
}
