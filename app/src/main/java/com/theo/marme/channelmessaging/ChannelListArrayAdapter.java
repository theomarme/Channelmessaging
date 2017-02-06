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
    private final Context context;
    private final List<Channel> values;


    public ChannelListArrayAdapter(Context context, List<Channel> values) {
        super(context, R.layout.channellayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.channellayout, parent, false);
        TextView tvName = (TextView) rowView.findViewById(R.id.textViewName);
        TextView tvUser = (TextView) rowView.findViewById(R.id.textViewuserconnected);
        Channel chan = values.get(position);
        tvName.setText(chan.getName());
        tvUser.setText("nombre d'utilisateurs connectés : " + chan.getConnectedusers());
        return rowView;
    }
}
