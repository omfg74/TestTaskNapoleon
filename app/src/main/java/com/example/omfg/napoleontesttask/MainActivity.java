package com.example.omfg.napoleontesttask;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewAdapter;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewItem;

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
        items = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            item = new TopRecyclerViewItem();
            item.setTextView("TEST "+i);
            items.add(item);
        }
        mRecyclerView  = (RecyclerView)findViewById(R.id.top_horizontal_recycler_view);


        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        for (int i = 0; i <items.size() ; i++) {
            System.out.println(items.get(i).getTextView());
        }
        mAdapter = new TopRecyclerViewAdapter(this,  items);
        mRecyclerView.setAdapter(mAdapter);


        LinearLayout mainDiscountLayout = (LinearLayout)findViewById(R.id.sales_linear_layout);

        ConstraintLayout constraintLayout = new ConstraintLayout(MainActivity.this);
        constraintLayout.setId(R.id.sales_constrant_layout);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        constraintLayout.setLayoutParams(params);
        mainDiscountLayout.addView(constraintLayout);
        setContentView(R.id.sales_constrant_layout);



    }
}
