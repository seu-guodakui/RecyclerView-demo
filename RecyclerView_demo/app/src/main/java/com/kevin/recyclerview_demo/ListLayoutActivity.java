package com.kevin.recyclerview_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ListLayoutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
    }

    public static void goToListLayoutActivity(Context context){
        Intent intent = new Intent(context,ListLayoutActivity.class);
        context.startActivity(intent);
    }

}
