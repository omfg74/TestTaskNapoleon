package com.example.omfg.napoleontesttask;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import com.example.omfg.napoleontesttask.Utils.ResponseController;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewAdapter;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewItem;
import AppObjects.Banner;

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
        ResponseInterface responseInterface = new ResponseController();
        List<Banner> banners = new ArrayList<>();

        banners = responseInterface.createGetBannerResponse();

        mRecyclerView  = (RecyclerView)findViewById(R.id.top_horizontal_recycler_view);


        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TopRecyclerViewAdapter(this,  banners);
        mRecyclerView.setAdapter(mAdapter);


        for (int i = 0; i <2 ; i++) {


            LinearLayout mainDiscountLayout = (LinearLayout) findViewById(R.id.sales_linear_layout);

            LayoutInflater layoutInflater = getLayoutInflater();
            View constLayout = layoutInflater.inflate(R.layout.sales_layout, mainDiscountLayout, false);

            TextView textView = (TextView) constLayout.findViewById(R.id.item_name_TextView);
            textView.setText("THIS IS TEST IMPLEMENTATION");
            mainDiscountLayout.addView(constLayout);
        }


    }
}
