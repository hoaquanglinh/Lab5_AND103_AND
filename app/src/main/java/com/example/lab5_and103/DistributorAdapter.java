package com.example.lab5_and103;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab5_and103.model.Distributor;

import java.util.List;

public class DistributorAdapter extends BaseAdapter {
    List<Distributor> list;
    Context context;
    MainActivity activity;

    public DistributorAdapter(List<Distributor> list, Context context, MainActivity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_distributor, null);

        TextView name = (TextView) rowView.findViewById(R.id.tvName);

        name.setText(String.valueOf(list.get(position).getName()));

        rowView.findViewById(R.id.btnSua).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Distributor distributor = list.get(position);
                activity.them(context, 1, distributor);
            }
        });

        rowView.findViewById(R.id.btnXoa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.xoa(list.get(position).get_id());
            }
        });

        return rowView;
    }
}

