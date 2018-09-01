package com.example.omfg.napoleontesttask.Networking.Interfaces;

import java.util.List;

import AppObjects.Banner;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {



    @GET("banners.json")
    Call<List<Banner>> getBanners();

    @GET("offers.json")
    Call<List<AppObjects.Offer>> getOffers();
}
