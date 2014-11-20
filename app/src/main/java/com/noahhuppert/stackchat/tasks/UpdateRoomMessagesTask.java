package com.noahhuppert.stackchat.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.noahhuppert.stackchat.MainActivity;
import com.noahhuppert.stackchat.MessagesRecyclerViewAdapter;
import com.noahhuppert.stackchat.controllers.HeaderBuilder;
import com.noahhuppert.stackchat.models.Message;
import com.noahhuppert.stackchat.models.Room;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Noah Huppert on 11/9/2014.
 */
public class UpdateRoomMessagesTask extends AsyncTask<Room, Void, ArrayList<Message>> {
    private Room room;
    private MessagesRecyclerViewAdapter adapter;

    public UpdateRoomMessagesTask setArgs(Room room, MessagesRecyclerViewAdapter adapter){
        this.room = room;
        this.adapter = adapter;

        return this;
    }

    protected ArrayList<Message> doInBackground(Room... args){
        /*if(args[0] == null || args[1] == null ){
            return null;
        }

        room = (Room) args[0];
        adapter = (MessagesRecyclerViewAdapter) args[1];*/

        OkHttpClient client = new OkHttpClient();

        //Set body content
        HeaderBuilder body = new HeaderBuilder();
        body.put("since", 0)
                .put("mode", "Messages")
                .put("count", 10);

        Request.Builder requestBuilder = new Request.Builder();//Create request builder

        String url = "http://chat.stackoverflow.com/chats/" + room.getId() + "/events";

        //Setup requestBuilder
        requestBuilder.url(url)
                .post(body.toUrlEncodedAsBody());

        Response response = null;
        JSONObject responseBody = null;
        JSONArray events = null;
        try{
            response = client.newCall(requestBuilder.build()).execute();
            responseBody = new JSONObject(response.body().string());

            events = responseBody.getJSONArray("events");

            ArrayList<Message> messages = new ArrayList<Message>();

            for(int i = 0; i < events.length(); i++){
                JSONObject event = events.getJSONObject(i);
                Message message = new Message(event.getInt("message_id"), event.getString("content"), event.getInt("time_stamp"), event.getInt("user_id"));
                messages.add(message);
            }

            return messages;
        } catch(IOException e){
            return null;
        } catch(JSONException e){
            return null;
        }
    }

    protected void onPostExecute(ArrayList<Message> messages){
        if(messages == null){
            Log.e(MainActivity.LOG_TAG, "Error retrieving room messages");
            return;
        }

        room.setMessages(messages);

        adapter.messages = room.getMessages();

        Log.w(MainActivity.LOG_TAG, "Updated messages, " + room.getMessages().size() + " " + room.getMessages().get(room.getMessages().size() - 1).getContent());

        adapter.notifyDataSetChanged();
    }
}
