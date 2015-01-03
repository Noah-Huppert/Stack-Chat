package com.noahhuppert.stackchat.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.Interfaces.ViewHolderClickListener;
import com.noahhuppert.stackchat.ViewHolders.ClickableViewHolder;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by Noah Huppert on 1/2/2015.
 */
public abstract class BaseRecylerViewAdapter<DataType, ViewHolderType extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolderType> implements ViewHolderClickListener {
    private ArrayList<DataType> data;
    private ViewHolderClickListener onClickListener;
    private int itemView;
    private Class<ViewHolderType> viewHolderType;

    public BaseRecylerViewAdapter(ArrayList<DataType> data, int itemView, Class<ViewHolderType> viewHolderType, ViewHolderClickListener onClickListener){
        setData(data);
        setItemView(itemView);
        setViewHolderType(viewHolderType);
        setOnClickListener(onClickListener);
    }

    public BaseRecylerViewAdapter(ArrayList<DataType> data, int itemView, Class<ViewHolderType> viewHolderType){
        setData(data);
        setItemView(itemView);
        setViewHolderType(viewHolderType);
    }

    public BaseRecylerViewAdapter(ArrayList<DataType> data, int itemView){
        setData(data);
        setItemView(itemView);
    }

    /* Actions */
    @Override
    public void onClick(int index) {
        if(getOnClickListener() != null){
            getOnClickListener().onClick(index);
        }
    }

    public abstract void runOnBindViewHolder(ViewHolderType holder, int position);

    /* Adapter Actions */
    @Override
    public ViewHolderType onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(getItemView(), viewGroup, false);

        try{
            return viewHolderType.getConstructor(View.class).newInstance(view);
        } catch (NoSuchMethodException e){
            Log.wtf("ClickableRecyclerViewAdapter", e.toString());
        } catch (InvocationTargetException e) {
            Log.wtf("ClickableRecyclerViewAdapter", e.toString());
        } catch (InstantiationException e) {
            Log.wtf("ClickableRecyclerViewAdapter", e.toString());
        } catch (IllegalAccessException e) {
            Log.wtf("ClickableRecyclerViewAdapter", e.toString());
        }

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderType holder, int position) {
        runOnBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return getData().size();
    }

    /* Getters */
    public ArrayList<DataType> getData() {
        return data;
    }

    public int getItemView() {
        return itemView;
    }

    public ViewHolderClickListener getOnClickListener() {
        return onClickListener;
    }

    public Class<ViewHolderType> getViewHolderType() {
        return viewHolderType;
    }

    /* Setters */
    public void setData(ArrayList<DataType> data) {
        this.data = data;
    }

    public void setItemView(int itemView) {
        this.itemView = itemView;
    }

    public void setOnClickListener(ViewHolderClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setViewHolderType(Class<ViewHolderType> viewHolderType) {
        this.viewHolderType = viewHolderType;
    }
}
