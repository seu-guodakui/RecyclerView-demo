package com.kevin.recyclerview_demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.list_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ListLayoutActivity.goToListLayoutActivity(MainActivity.this);
            }
        });

        findViewById(R.id.grid_layout).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });

        findViewById(R.id.staggergrid_layout).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}
