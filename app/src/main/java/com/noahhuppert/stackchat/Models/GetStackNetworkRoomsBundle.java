package com.noahhuppert.stackchat.Models;

/**
 * Created by Noah Huppert on 1/1/2015.
 */
public class GetStackNetworkRoomsBundle {
    private StackNetwork stackNetwork;
    private int page;

    public GetStackNetworkRoomsBundle(StackNetwork stackNetwork, int page) {
        this.stackNetwork = stackNetwork;
        this.page = page;
    }

    /* Getters */
    public StackNetwork getStackNetwork() {
        return stackNetwork;
    }

    public int getPage() {
        return page;
    }

    /* Setters */
    public void setStackNetwork(StackNetwork stackNetwork) {
        this.stackNetwork = stackNetwork;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
