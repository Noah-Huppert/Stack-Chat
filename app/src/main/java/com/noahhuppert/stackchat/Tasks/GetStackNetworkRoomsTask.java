package com.noahhuppert.stackchat.Tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.noahhuppert.stackchat.Interfaces.GetStackNetworkRoomsInterface;
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
public class GetStackNetworkRoomsTask extends AsyncTask<Integer, Void, ArrayList<StackRoom>> {
    private GetStackNetworkRoomsInterface getStackNetworkRoomsInterface;
    private StackNetwork stackNetwork;

    public GetStackNetworkRoomsTask(GetStackNetworkRoomsInterface getStackNetworkRoomsInterface, StackNetwork stackNetwork){
        this.getStackNetworkRoomsInterface = getStackNetworkRoomsInterface;
        this.stackNetwork = stackNetwork;
    }

    @Override
    protected ArrayList<StackRoom> doInBackground(Integer... pages) {
        ArrayList<StackRoom> stackRooms = new ArrayList<StackRoom>();

        try {
            for (int page : pages) {
                Document document = Jsoup.connect(stackNetwork.getUrl() + "?tab=all&sort=active&page=" + page).get();
                Elements roomCards = document.select(".roomcard");

                for(Element roomCard : roomCards){
                    String roomName = roomCard.select(".room-name").text();

                    String roomIdString = roomCard.select(".actions").select("a").get(1).attr("href").replace("/transcript/", "");
                    int roomId = Integer.parseInt(roomIdString);

                    String roomDescription = roomCard.select(".room-description").text();

                    StackRoom stackRoom = new StackRoom(roomId, roomName, roomDescription);
                    stackRooms.add(stackRoom);
                }
            }
        } catch(IOException e){

        }

        return stackRooms;
    }

    @Override
    protected void onPostExecute(ArrayList<StackRoom> rooms) {
        super.onPostExecute(rooms);

        getStackNetworkRoomsInterface.onRetrievedRooms(rooms);
    }
}
