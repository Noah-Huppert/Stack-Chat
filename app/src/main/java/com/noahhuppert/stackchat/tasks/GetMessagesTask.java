package com.noahhuppert.stackchat.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.noahhuppert.stackchat.MainActivity;
import com.noahhuppert.stackchat.models.Room;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Noah Huppert on 11/9/2014.
 */
public class GetMessagesTask extends AsyncTask<Integer, Void, JSONObject> {
    protected JSONObject doInBackground(Integer... params){
        try {
            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), "since=0&mode=Messages&msgCount=1");

            Request request = new Request.Builder()
                    .url("http://chat.stackoverflow.com/chats/" + params[0] + "/events")
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();

            return new JSONObject(response.body().string());
        } catch (IOException e){
            return null;
        } catch (JSONException e){
            return null;
        }
    }

    protected void onPostExecute(JSONObject result){
        try{
            //Room room = MainActivity.getRoomsController().getRoomById(result.getInt("room_id"));

            JSONObject events = (JSONObject) result.get("events");

            Log.i("GetMessages", events.toString() + " " + events);
        } catch(JSONException e){

        }
    }
}
