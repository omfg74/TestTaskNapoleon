package com.example.omfg.napoleontesttask.Networking.Interfaces;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {



    @GET("")
    Call<Objects.Banner > getBanners();

}
