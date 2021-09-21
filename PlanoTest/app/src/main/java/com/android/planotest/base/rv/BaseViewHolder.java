package com.android.planotest.base.rv;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private B mBinding;

    public BaseViewHolder(B binding) {
        super(binding.getRoot());
        mBinding = binding;

    }

    public B getBinding(){
        return mBinding;
    }

}
