package com.example.listviewwithprojecttwo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends ArrayAdapter<User> {

    private Activity context;
    private ArrayList<User> arrayList;

    public MyAdapter(Activity context, ArrayList<User> arrayList) {
        super(context, R.layout.eachitem, arrayList);
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.eachitem, null);

        CircleImageView image = view.findViewById(R.id.profile_image);
        TextView name = view.findViewById(R.id.tVName);
        TextView lastMsg = view.findViewById(R.id.tVLastMessage);
        TextView lastMsgTime = view.findViewById(R.id.tVLastMsgTime);

        name.setText(arrayList.get(position).getName());
        lastMsg.setText(arrayList.get(position).getLastMsg());
        lastMsgTime.setText(arrayList.get(position).getLastMsgTime());
        image.setImageResource(arrayList.get(position).getImageId());

        return view;
    }
}
