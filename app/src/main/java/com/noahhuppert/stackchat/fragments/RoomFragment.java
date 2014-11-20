package com.noahhuppert.stackchat.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noahhuppert.stackchat.MainActivity;
import com.noahhuppert.stackchat.MessagesRecyclerViewAdapter;
import com.noahhuppert.stackchat.R;
import com.noahhuppert.stackchat.models.Message;
import com.noahhuppert.stackchat.models.Room;
import com.noahhuppert.stackchat.tasks.UpdateRoomMessagesTask;

import java.util.ArrayList;

/**
 * Created by Noah Huppert on 11/18/2014.
 */
public class RoomFragment extends Fragment {
    RecyclerView messagesRecyclerView;
    RecyclerView.LayoutManager messagesLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.messages_fragment, container, false);

        Room room15 = new Room(15);

        /*room15.addMessage(new Message(0, "message1", 10, 1));
        room15.addMessage(new Message(1, "message2", 10, 1));
        room15.addMessage(new Message(2, "message3", 10, 1));*/

        messagesRecyclerView = (RecyclerView) view.findViewById(R.id.messages_recycler_view);
        messagesRecyclerView.setHasFixedSize(true);

        messagesLayoutManager = new LinearLayoutManager(getActivity());
        messagesRecyclerView.setLayoutManager(messagesLayoutManager);

        MessagesRecyclerViewAdapter messagesRecyclerViewAdapter = new MessagesRecyclerViewAdapter(room15.getMessages());
        messagesRecyclerView.setAdapter(messagesRecyclerViewAdapter);

        new UpdateRoomMessagesTask().setArgs(room15, messagesRecyclerViewAdapter).execute();

        return view;
    }
}
