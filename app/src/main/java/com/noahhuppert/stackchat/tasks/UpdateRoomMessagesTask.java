package com.noahhuppert.stackchat.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.noahhuppert.stackchat.MainActivity;
import com.noahhuppert.stackchat.controllers.HeaderBuilder;
import com.noahhuppert.stackchat.models.Message;
import com.noahhuppert.stackchat.models.Room;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Noah Huppert on 11/9/2014.
 */
public class UpdateRoomMessagesTask extends AsyncTask<Room, Void, ArrayList<Message>> {
    private Room room;

    protected ArrayList<Message> doInBackground(Room... rooms){
        if(rooms[0] == null){
            return null;
        }

        room = rooms[0];

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
        Object responseBody = null;
        try{
            response = client.newCall(requestBuilder.build()).execute();
            responseBody = new JSONObject(response.body().string()).get("events");
        } catch(IOException e){
            return null;
        } catch(JSONException e){
            return null;
        }

        ArrayList<Message> messages = new ArrayList<Message>();

        Log.w(MainActivity.LOG_TAG, responseBody.toString());

        //TODO Convert to ArrayList<Message>

        return messages;
    }

    protected void onPostExecute(ArrayList<Message> messages){
        if(messages == null){
            Log.e(MainActivity.LOG_TAG, "Error retrieving room messages");
            return;
        }

        room.setMessages(messages);
    }
}
