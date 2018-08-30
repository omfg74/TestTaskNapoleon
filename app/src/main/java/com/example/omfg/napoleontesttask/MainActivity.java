package com.example.omfg.napoleontesttask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TopRecyclerViewItem item;
    private List<TopRecyclerViewItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = new TopRecyclerViewItem();
        items = new ArrayList<>();
        mRecyclerView  = (RecyclerView)findViewById(R.id.top_horizontal_recycler_view);


        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TopRecyclerViewAdapter(this,  items);
        mRecyclerView.setAdapter(mAdapter);
    }
}
