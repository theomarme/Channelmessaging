package com.theo.marme.channelmessaging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by marmet on 06/02/2017.
 */
public class MessageListAdapter extends ArrayAdapter<Message> {

    private final Context context;
    private final List<Message> values;

    public MessageListAdapter(Context context, List<Message> values) {
        super(context, R.layout.message_layout, values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.send_layout, parent, false);
        TextView tvNom = (TextView) rowView.findViewById(R.id.tvNom_id);
        TextView tvMessage = (TextView) rowView.findViewById(R.id.tvMessage_id);
        Message mes = values.get(position);
        tvNom.setText(mes.getUserId());

        tvMessage.setText("message : " + mes.getMessage());
        return rowView;
    }
}
