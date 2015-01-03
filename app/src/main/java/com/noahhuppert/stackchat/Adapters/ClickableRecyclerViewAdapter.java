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
public abstract class ClickableRecyclerViewAdapter<DataType, ViewHolderType extends ClickableViewHolder> extends BaseRecylerViewAdapter<DataType, ViewHolderType> {

    protected ClickableRecyclerViewAdapter(ArrayList<DataType> data, int itemView, Class<ViewHolderType> viewHolderType, ViewHolderClickListener onClickListener) {
        super(data, itemView, viewHolderType, onClickListener);
    }

    protected ClickableRecyclerViewAdapter(ArrayList<DataType> data, int itemView, Class<ViewHolderType> viewHolderType) {
        super(data, itemView, viewHolderType);
    }

    protected ClickableRecyclerViewAdapter(ArrayList<DataType> data, int itemView) {
        super(data, itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderType holder, int position) {
        holder.setupClickListener(position, getOnClickListener());
        runOnBindViewHolder(holder, position);
    }
}
