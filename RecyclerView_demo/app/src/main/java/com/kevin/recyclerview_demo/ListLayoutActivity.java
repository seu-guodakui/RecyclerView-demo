package com.kevin.recyclerview_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListLayoutActivity extends ActionBarActivity {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        initdata(50);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        listAdapter = new ListAdapter(this,mDatas);
        listAdapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Toast.makeText(ListLayoutActivity.this,"click"+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnItemLongClick(View view, int position) {
                listAdapter.remove(position);
                Toast.makeText(ListLayoutActivity.this,"click"+position,Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initdata(int length){
        mDatas = new ArrayList<String>();
        for(int i=0;i<length;i++){
            mDatas.add(String.valueOf(i));
        }
    }
    public static void goToListLayoutActivity(Context context){
        Intent intent = new Intent(context,ListLayoutActivity.class);
        context.startActivity(intent);
    }

}
