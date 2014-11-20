package com.noahhuppert.stackchat;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    public ArrayList<Message> messages;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView messageContent;
        public TextView messageAuthor;

        public ViewHolder(View itemView){
            super(itemView);
            messageContent = (TextView) itemView.findViewById(R.id.messageContent);
            messageAuthor = (TextView) itemView.findViewById(R.id.messageAuthor);
        }
    }

    public MessagesRecyclerViewAdapter(ArrayList<Message> messages){
        this.messages = messages;
    }

    @Override
    public MessagesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message_view, parent, false);

        ViewHolder viewholder = new ViewHolder(view);//(TextView) view.findViewById(R.id.messageContent));

        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position){
        viewHolder.messageContent.setText(messages.get(position).getContent());
        viewHolder.messageAuthor.setText("User Id: " + messages.get(position).getUserId());
    }

    @Override
    public int getItemCount(){
        return messages.size();
    }

    //TODO Make recyclerview update correctly when notifyDataSetChange
}
