package com.kevin.recyclerview_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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
        recyclerView.addItemDecoration(new ListItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_layout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_first:
                listAdapter.add(0, "add first");
                break;
            case R.id.add_last:
                listAdapter.add(listAdapter.getItemCount(), "add last");
                break;
            case R.id.remove_first:
                String value = listAdapter.remove(0);
                Toast.makeText(ListLayoutActivity.this, "remove:" + value, Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_last:
                String value1 =  listAdapter.remove(listAdapter.getItemCount()-1);
                Toast.makeText(ListLayoutActivity.this, "remove:" + value1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.horizontal:
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                recyclerView.addItemDecoration(new ListItemDecoration(this, LinearLayoutManager.HORIZONTAL));
                break;
            case R.id.vertical:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.addItemDecoration(new ListItemDecoration(this, LinearLayoutManager.VERTICAL));
                break;
        }
        return super.onOptionsItemSelected(item);
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
