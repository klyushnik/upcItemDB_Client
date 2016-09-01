package com.rasputinstudios.upcitemdbclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.client.android.*;

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

    public void scan(View view) {
        Intent intent = new Intent(getApplicationContext(), CaptureActivity.class);
        intent.setAction("com.google.zxing.client.android.SCAN");
        intent.putExtra("SAVE_HISTORY", false);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0){
            if (resultCode == RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
                searchText.setText(contents);
            }
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, getApplicationContext().getString(R.string.error_Empty), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
