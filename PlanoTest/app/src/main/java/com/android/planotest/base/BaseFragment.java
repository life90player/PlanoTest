package com.android.planotest.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T extends BaseViewModel,B extends ViewDataBinding> extends Fragment {
    public B mBinding;
    public T mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        if (null != mViewModel){
            getLifecycle().addObserver(mViewModel);
        }
    }

    public void showLoading(){
        if (null != getActivity()){
            ((BaseActivity)getActivity()).showLoading();
        }
    }

    public void hideLoadDing(){
        if (null != getActivity()){
            ((BaseActivity)getActivity()).hideLoading();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater,
                getLayoutId(),
                container,
                false
        );
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    public abstract void initData();

    public abstract T getViewModel();

    @LayoutRes
    public abstract int getLayoutId();

    @Override
    public void onDestroy() {
        getLifecycle().removeObserver(mViewModel);
        super.onDestroy();
    }

    public abstract void onChange();
}
