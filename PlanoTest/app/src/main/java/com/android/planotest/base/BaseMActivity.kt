package com.android.planotest.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

@SuppressLint("Registered")
abstract class BaseMActivity<vm : BaseViewModel, b : ViewDataBinding> : BaseActivity() {
    lateinit var mBinding: b
    lateinit var mViewModel:vm


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,getLayoutId())
        mViewModel = createViewModel()
        lifecycle.addObserver(mViewModel)
        mBinding.lifecycleOwner = this
        initData()
    }

    @LayoutRes
    abstract fun getLayoutId():Int

    abstract fun createViewModel():vm

    abstract fun initData()

    override fun onDestroy() {
        mBinding.unbind()
        lifecycle.removeObserver(mViewModel)
        super.onDestroy()
    }
}