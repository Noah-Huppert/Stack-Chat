package com.noahhuppert.stackchat;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noahhuppert.stackchat.models.Message;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 11/18/2014.
 */
public class MessagesRecyclerViewAdapter extends RecyclerView.Adapter<MessagesRecyclerViewAdapter.ViewHolder>{
    private ArrayList<Message> messages;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public ViewHolder(TextView view){
            super(view);
            textView = view;
        }
    }

    public MessagesRecyclerViewAdapter(ArrayList<Message> messages){
        this.messages = messages;
    }

    @Override
    public MessagesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.messages_fragment, viewGroup, false);

        ViewHolder viewholder = new ViewHolder((TextView) view.findViewById(R.id.messageContent));

        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        viewHolder.textView.setText(messages.get(position).getContent());
    }

    @Override
    public int getItemCount(){
        return messages.size();
    }

    //TODO Make recyclerview update correctly when notifyDataSetChange
}
