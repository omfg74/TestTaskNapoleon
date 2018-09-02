package com.example.omfg.napoleontesttask;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import com.example.omfg.napoleontesttask.Networking.Requests.ImageDownloader;
import com.example.omfg.napoleontesttask.Utils.DiscountCounter;
import com.example.omfg.napoleontesttask.Utils.ResponseController;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewAdapter;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewItem;
import AppObjects.Banner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TopRecyclerViewItem item;
    private List<TopRecyclerViewItem> items;

    TextView top10, shops, goods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResponseInterface responseInterface = new ResponseController();
        List<Banner> banners = new ArrayList<>();
        //
        LinearLayout mainOfferstLayout = (LinearLayout) findViewById(R.id.sales_linear_layout);
        LinearLayout mainOtherLayout = (LinearLayout) findViewById(R.id.other_linear_layout);
        ResponseInterface offersResponse = new ResponseController();
        List<AppObjects.Offer> offers= new ArrayList<>();
        offers = offersResponse.createGetOffersResponse(mainOfferstLayout,mainOtherLayout, this);
        banners = responseInterface.createGetBannerResponse();

        top10 = (TextView)findViewById(R.id.top10_text_view);
        shops = (TextView)findViewById(R.id.shops_text_view);
        goods = (TextView)findViewById(R.id.goods_text_view);

        top10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                top10.setBackground(R.drawable.rectngle_full);
                shops.setBackground(R.drawable.rectngle);
                goods.setBackground(R.drawable.rectngle);
            }
        });
        mRecyclerView  = (RecyclerView)findViewById(R.id.top_horizontal_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TopRecyclerViewAdapter(this,  banners);
        mRecyclerView.setAdapter(mAdapter);

//Заполнение списка скидок и акций.



    }
}
