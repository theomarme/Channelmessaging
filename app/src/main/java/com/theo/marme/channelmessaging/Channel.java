package com.theo.marme.channelmessaging;

/**
 * Created by marmet on 23/01/2017.
 */
public class Channel {

   public int channelID;
    public String name;
    public int connectedusers;

    public Channel(int channelID, String name, int connectedusers) {
        this.channelID = channelID;
        this.name = name;
        this.connectedusers = connectedusers;
    }

    public int getChannelID() {
        return channelID;
    }

    public String getName() {
        return name;
    }

    public int getConnectedusers() {
        return connectedusers;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConnectedusers(int connectedusers) {
        this.connectedusers = connectedusers;
    }
}
