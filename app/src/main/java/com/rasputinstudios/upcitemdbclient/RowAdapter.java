package com.rasputinstudios.upcitemdbclient;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mafia on 8/24/2016.
 */

public class RowAdapter extends ArrayAdapter<ProductItem> {

    public RowAdapter(Context context, ArrayList<ProductItem> values){
        super(context, 0, values);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ProductItem item = getItem(i);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.product_item, viewGroup, false);
        }

        TextView itemNameTextView = (TextView)view.findViewById(R.id.itemNameTextView);
        TextView descriptionTextView = (TextView)view.findViewById(R.id.descriptionTextView);
        TextView upcTextView = (TextView)view.findViewById(R.id.upcTextView);
        TextView eanTextView = (TextView)view.findViewById(R.id.eanTextView);
        LinearLayout rootLayout = (LinearLayout)view.findViewById(R.id.resultRootLayout);

        itemNameTextView.setText(item.getProductName());
        descriptionTextView.setText(item.getProductDescription());
        upcTextView.setText(item.getUPC());
        eanTextView.setText(item.getEAN());
        if (i % 2 == 0) {
            rootLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        } else {
            rootLayout.setBackgroundColor(Color.parseColor("#d9ebff"));
        }
        return view;
    }
}
