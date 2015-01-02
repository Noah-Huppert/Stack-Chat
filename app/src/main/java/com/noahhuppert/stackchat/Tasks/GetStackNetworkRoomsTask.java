package com.noahhuppert.stackchat.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.noahhuppert.stackchat.Models.GetStackNetworkRoomsBundle;
import com.noahhuppert.stackchat.Models.StackNetwork;
import com.noahhuppert.stackchat.Models.StackRoom;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Noah Huppert on 1/1/2015.
 */
public class GetStackNetworkRoomsTask extends AsyncTask<GetStackNetworkRoomsBundle, Void, ArrayList<StackRoom>> {
    @Override
    protected ArrayList<StackRoom> doInBackground(GetStackNetworkRoomsBundle... data) {
        try {
            ArrayList<StackRoom> stackRooms = new ArrayList<StackRoom>();

            Document document = Jsoup.connect(data[0].getStackNetwork().getUrl() + "?tab=all&sort=active&page=" + data[0].getPage()).get();
            Elements roomsIndex = document.select(".roomcard");

            for(Element element : roomsIndex){
                String roomName = element.select(".room-name").text();
                String roomIdString = element.id();
                //TODO Figure out why element.id() is not returning the Id
                //TODO Serialize a list of StackRooms from data
                Log.d("GetStackNetworkRooms", roomIdString);
            }
            return null;
        }catch (IOException e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<StackRoom> rooms) {
        super.onPostExecute(rooms);
    }
}
