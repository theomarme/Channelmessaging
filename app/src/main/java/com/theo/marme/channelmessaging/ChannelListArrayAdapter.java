package com.theo.marme.channelmessaging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by marmet on 27/01/2017.
 */
public class ChannelListArrayAdapter extends ArrayAdapter<Channel> {


    public ChannelListArrayAdapter(Context context, List<Channel> channels) {
        super(context, 0, channels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Channel channel = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_channel_list, parent, false);
        }
        TextView channelsName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView channelsNbPers = (TextView) convertView.findViewById(R.id.textViewuserconnected);
        channelsName.setText(channel.getName());
        channelsNbPers.setText("Nombre de personnes connectées : " + channel.getConnectedusers().toString());
        return convertView;
    }
}
