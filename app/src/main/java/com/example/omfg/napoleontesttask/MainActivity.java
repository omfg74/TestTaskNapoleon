package com.example.omfg.napoleontesttask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import com.example.omfg.napoleontesttask.Utils.Keyboard;
import com.example.omfg.napoleontesttask.Utils.ResponseController;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewAdapter;
import com.example.omfg.napoleontesttask.ViewControllers.TopRecyclerViewItem;

import AppObjects.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private TopRecyclerViewItem item;
    private List<TopRecyclerViewItem> items;

    EditText serchFieldEditText;
    ImageView infoImageView;
    TextView top10, shops, goods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ResponseInterface responseInterface = new ResponseController();
        List<Banner> banners = new ArrayList<>();

        infoImageView = (ImageView) findViewById(R.id.info_image_view);
        FrameLayout mainOfferstLayout = (FrameLayout) findViewById(R.id.sales_linear_layout);
        FrameLayout mainOtherLayout = (FrameLayout) findViewById(R.id.other_linear_layout);
        ResponseInterface offersResponse = new ResponseController();
        List<AppObjects.Offer> offers = new ArrayList<>();
        offers = offersResponse.createGetOffersResponse(mainOfferstLayout, mainOtherLayout, this);
        banners = responseInterface.createGetBannerResponse();


        //Описание и логика нажатия фильтра
        top10 = (TextView) findViewById(R.id.top10_text_view);
        shops = (TextView) findViewById(R.id.shops_text_view);
        goods = (TextView) findViewById(R.id.goods_text_view);

        top10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                top10.setBackgroundResource(R.drawable.rectngle_full);
                shops.setBackgroundResource(R.drawable.rectngle);
                goods.setBackgroundResource(R.drawable.rectngle);
            }
        });

        shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                top10.setBackgroundResource(R.drawable.rectngle);
                shops.setBackgroundResource(R.drawable.rectngle_full);
                goods.setBackgroundResource(R.drawable.rectngle);
            }
        });

        goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                top10.setBackgroundResource(R.drawable.rectngle);
                shops.setBackgroundResource(R.drawable.rectngle);
                goods.setBackgroundResource(R.drawable.rectngle_full);
            }
        });
        //Описание и заполнение горизонтального списка
        topRecyclerView = (RecyclerView) findViewById(R.id.top_horizontal_recycler_view);
        topRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new TopRecyclerViewAdapter(this, banners);
        topRecyclerView.setAdapter(mAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(topRecyclerView);

//Переназначенеи Enter
        serchFieldEditText = (EditText) findViewById(R.id.search_edit_text);
        serchFieldEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    Keyboard.hide(v);
                    return false;
                }
                return false;
            }
        });
//Переход на другое активити
        final Intent intent = new Intent(this, InfoActivity.class);
        infoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });


    }
}
