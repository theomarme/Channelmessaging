package vincent.riva.channelmessaging.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import vincent.riva.channelmessaging.AsyncTaskClass;
import vincent.riva.channelmessaging.ChannelActivity;
import vincent.riva.channelmessaging.ChannelArrayAdapter;
import vincent.riva.channelmessaging.FriendsActivity;
import vincent.riva.channelmessaging.OnCompleteRequestListener;
import vincent.riva.channelmessaging.R;
import vincent.riva.channelmessaging.ResponseChannel;
import vincent.riva.channelmessaging.ResponseChannelList;

/**
 * Created by marmet on 27/03/2017.
 */
public class ChannelListFragment extends Fragment{


/*
    private ResponseChannelList channelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.layout_fragment, container, false);
        final ListView listViewChannels = (ListView)v.findViewById(R.id.listView_frag);

        Button buttonAmis = (Button)v.findViewById(R.id.button_frag);
        buttonAmis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), FriendsActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences settings = getActivity().getSharedPreferences("MyPrefs", 0);
        String token = settings.getString("accesstoken", "");

        AsyncTaskClass async = new AsyncTaskClass();
        async.setOnCompleteRequestListener(new OnCompleteRequestListener() {
            @Override
            public void onCompleteRequest(String response) {
                Gson gson = new Gson();
                channelList = gson.fromJson(response, ResponseChannelList.class);
                listViewChannels.setAdapter(new ChannelArrayAdapter(getActivity().getApplicationContext(), channelList.getChannels()));
                listViewChannels.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ResponseChannel channel = channelList.getChannels().get(position);
                        Intent myIntent2 = new Intent(getActivity().getApplicationContext(), ChannelActivity.class);
                        myIntent2.putExtra("channelID", channel.getChannelID());
                        startActivity(myIntent2);
                    }
                });
            }
        });
        async.execute("http://www.raphaelbischof.fr/messaging/?function=getchannels", "accesstoken", token);
    }*/
}
