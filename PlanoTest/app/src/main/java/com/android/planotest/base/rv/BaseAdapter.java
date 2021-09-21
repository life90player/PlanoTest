package com.android.planotest.base.rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.android.planotest.base.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T,D extends ViewDataBinding> extends RecyclerView.Adapter<BaseViewHolder<D>> {
    public List<T> mList = new ArrayList<>();

    protected OnItemClickListener mOnItemClickListener;

    @LayoutRes
    private int mLayoutId;

    public BaseAdapter() {
        mLayoutId = getLayoutId();
    }

    @LayoutRes
    public abstract int getLayoutId();

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mOnItemClickListener = mListener;
    }

    public List<T> getData(){
        return mList;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<D> holder, int position) {
        bind(holder.getBinding(),mList.get(position),position);
        holder.getBinding().executePendingBindings();
    }

    protected D createItemView(Context context, ViewGroup viewGroup){
        return DataBindingUtil.inflate(LayoutInflater.from(context),mLayoutId,viewGroup,false);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    protected abstract void bind(D binding, T data,int position);
}
