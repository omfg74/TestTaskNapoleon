package com.example.omfg.napoleontesttask.Networking.Requests;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import com.example.omfg.napoleontesttask.Networking.RetrofitClient;
import com.example.omfg.napoleontesttask.R;
import com.example.omfg.napoleontesttask.Utils.DiscountCounter;
import com.example.omfg.napoleontesttask.Utils.LayoutMover;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import AppObjects.Offer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OfferstGetRequest {

    List<AppObjects.Offer> offers = new ArrayList<>();
    FrameLayout linearLayout;
    FrameLayout linearLayout2;
    Context context;

    public OfferstGetRequest(List<Offer> offers, FrameLayout linearLayout, FrameLayout linearLayout2, Context context) {
        this.offers = offers;
        this.linearLayout = linearLayout;
        this.context = context;
        this.linearLayout2 = linearLayout2;

    }

    //Запрос отвечающий за получение данных по скидкам и акциям
    public List<AppObjects.Offer> getOffers() {
        RetrofitClient retrofitClient = new RetrofitClient();

        try {
            Call<List<AppObjects.Offer>> response = retrofitClient.getRetrofitInterface().getOffers();
            response.enqueue(new Callback<List<Offer>>() {
                @Override
                public void onResponse(Call<List<Offer>> call, Response<List<Offer>> response) {
                    if (response.isSuccessful()) {
                        for (int i = 0; i < response.body().size(); i++) {
                            // Заполнение листа скидок необходимости в наличии листа здесь нет, но всучае дальнейшей доработки его можно будет использовать.
                            Offer offer = new Offer();
                            offer.setDesc(response.body().get(i).getDesc());
                            offer.setDiscount(response.body().get(i).getDiscount());
                            offer.setGroupName(response.body().get(i).getGroupName());
                            offer.setId(response.body().get(i).getId());
                            offer.setImage(response.body().get(i).getImage());
                            offer.setName(response.body().get(i).getName());
                            offer.setPrice(response.body().get(i).getPrice());
                            offer.setType(response.body().get(i).getType());
                            offers.add(offer);


                            //Отрисовка и заполнение отдельных полей со скидками
                            View constLayout;
                            LayoutInflater layoutInflater = LayoutInflater.from(context);
                            if (offers.get(i).getGroupName().equalsIgnoreCase("Акции")) {
                                constLayout = layoutInflater.inflate(R.layout.sales_layout, linearLayout, false);

                            } else {
                                constLayout = layoutInflater.inflate(R.layout.sales_layout, linearLayout2, false);
                            }
                            TextView NametextView = (TextView) constLayout.findViewById(R.id.item_name_TextView);
                            TextView descTextView = (TextView) constLayout.findViewById(R.id.item_group_TextView);
                            TextView discountAmmountTextView = (TextView) constLayout.findViewById(R.id.discount_ammount);
                            TextView oldPriceTextView = (TextView) constLayout.findViewById(R.id.old_old_price);
                            TextView newPriceTextView = (TextView) constLayout.findViewById(R.id.new_price);
                            ImageView itemImageView = (ImageView) constLayout.findViewById(R.id.item_Photo_ImageView);
                            ImageView cartImageView = (ImageView) constLayout.findViewById(R.id.cart_imageView);

                            ImageDownloader imageDownloader = new ImageDownloader();
                            imageDownloader.execute(offers.get(i).getImage());
                            NametextView.setText(offers.get(i).getName());
                            descTextView.setText(offers.get(i).getDesc());

                            if (offers.get(i).getDiscount() != null) {
                                Double disc = 1 - offers.get(i).getDiscount();
                                disc *= -100;
                                System.out.println("ALLLERET " + disc);
                                System.out.println();
                                discountAmmountTextView.setText(String.valueOf(disc.intValue()) + "%");
                            }
                            if (offers.get(i).getPrice() != null) {
                                String s = String.valueOf(offers.get(i).getPrice());
                                oldPriceTextView.setText(s);
                                DiscountCounter discountCounter = new DiscountCounter();
                                newPriceTextView.setText(discountCounter.count(offers.get(i).getPrice(), offers.get(i).getDiscount()));
                            }
                            oldPriceTextView.setPaintFlags(oldPriceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                            try {
                                itemImageView.setImageBitmap(imageDownloader.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            if (offers.get(i).getGroupName().equalsIgnoreCase("Акции")) {

                                linearLayout.addView(constLayout);
                                linearLayout.setOnTouchListener(new LayoutMover(context) {
                                    @Override
                                    public void onSwipe() {
                                        super.onSwipe();
                                        Log.d("SWIPE", "SUCSESS");
                                        Animation animation = AnimationUtils.loadAnimation(context, R.anim.transform_to_left);

                                        linearLayout.startAnimation(animation);
                                    }
                                });
                            } else {
                                linearLayout2.addView(constLayout);
                            }

                        }
                    } else {
                        System.out.println("fail");
                    }
                }

                @Override
                public void onFailure(Call<List<Offer>> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        return offers;
    }
}
