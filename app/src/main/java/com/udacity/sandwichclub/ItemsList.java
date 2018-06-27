package com.udacity.sandwichclub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class ItemsList extends BaseAdapter{

    Context context;
    String[] sandwichArray;

    public ItemsList(Context context, String[] sandwichArray)
    {
        this.context = context;
        this.sandwichArray = sandwichArray;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.item_layout, null, true);

        ImageView imageView = listViewItem.findViewById(R.id.imageSandwich);
        TextView textView = listViewItem.findViewById(R.id.nameSandwich);


        String json = sandwichArray[position];
        Sandwich sandwich = JsonUtils.parseSandwichJson(json);

        Picasso.with(context).load(sandwich.getImage()).placeholder(R.drawable.image_not_available).into(imageView);

        textView.setText(sandwich.getMainName());
        return listViewItem;
    }
}
