package com.rasputinstudios.upcitemdbclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText searchText;
    Button searchButton;
    Button scanUPCButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchText = (EditText)findViewById(R.id.searchEditText);
        searchButton = (Button)findViewById(R.id.searchButton);
        scanUPCButton = (Button)findViewById(R.id.scanButton);
    }

    public void doSearch(View view) {
        /*String s = searchText.getText().toString().trim();
        String query;
        if (s.length() == 0) return;
        if (s.matches("\\d+") && (s.length() == 12 || s.length() == 13)) {
            //if string is numeric and its length is 12 or 13, we use the 'lookup' query, else 'search'
            query = getApplicationContext().getString(R.string.core_Lookup) + s;
        }
        else{
            query = getApplicationContext().getString(R.string.core_Search) + s;
            } */

        Intent intent = new Intent(this, ResultContainerActivity.class);
        startActivity(intent);


    }
}
