package com.rasputinstudios.upcitemdbclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ResultContainerActivity extends AppCompatActivity {


    ListView searchResultsListView;
    ArrayList<ProductItem> resultsList;
    RowAdapter adapter;
    String json = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_container);
        resultsList = new ArrayList<ProductItem>();
        adapter = new RowAdapter(this, resultsList);
        searchResultsListView = (ListView)findViewById(R.id.resultListView);
        searchResultsListView.setAdapter(adapter);
        json = LoadJSON();
        PopulateListView();
    }

    private void PopulateListView() {
        JSONArray jsonArray = null;
        try{
            JSONObject jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("items");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                //TODO: Get the "offers" array from obj and set it up the same way as "items" array
                //TODO: Rewrite ProductItem to get rid of vendorUrlPrice because fuck navigating through a 3d array

                String name = obj.getString("title");
                String description = obj.getString("description");
                String upc = obj.getString("upc");
                String ean = obj.getString("ean");
                ProductItem productItem = new ProductItem(name, description, upc, ean, null, null);
                adapter.add(productItem);
            }

        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    String LoadJSON() {
        BufferedReader in = null;
        try {
            StringBuilder buf = new StringBuilder();
            InputStream is = this.getAssets().open("TestJSON.json");
            in = new BufferedReader(new InputStreamReader(is));
            String str;
            while ( (str = in.readLine()) != null ) {
                buf.append(str);
            }
            in.close();
            return buf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
