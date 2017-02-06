package com.theo.marme.channelmessaging;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by marmet on 06/02/2017.
 */
public class MessageListAdapter extends ArrayAdapter<Channel> {

    private final Context context;
    private final List<Channel> values;

    public MessageListAdapter(Context context, List<Channel> values) {
        super(context, R.layout.message_layout, values);
        this.context = context;
        this.values = values;
    }
}
