package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alex on 5/21/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> records) {
        super(context, 0, records);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentRecord = getItem(position);

        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude_textview);
        magnitude.setText(String.valueOf(currentRecord.getMagnitude()));

        TextView location = (TextView) listItemView.findViewById(R.id.location_textview);
        location.setText(currentRecord.getLocation());

        TextView date = (TextView) listItemView.findViewById(R.id.date_textview);
        date.setText(currentRecord.getDate());

        return listItemView;
    }
}
