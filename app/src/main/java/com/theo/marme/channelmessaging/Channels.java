package com.theo.marme.channelmessaging;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marmet on 23/01/2017.
 */
public class Channels {

    private List<Channel> channels;

    public List<Channel> getChannels(){
        return channels;

    }
    public void setChannels(List<Channel> channels){
        this.channels=channels;
    }

    public Channels(List<Channel> channels){
        this.channels=channels;
    }
}
