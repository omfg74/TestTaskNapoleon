package com.example.omfg.napoleontesttask.Networking.Requests;

import com.example.omfg.napoleontesttask.Networking.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import AppObjects.Banner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerRequst {
    List<Banner>banners =new ArrayList<>();
    public List<Banner> getBanners(){



        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        try {
            Call<List<Banner>> response =  retrofitClient.getRetrofitInterface().getBanners();
            response.enqueue(new Callback<List<Banner>>() {
                @Override
                public void onResponse(Call<List<Banner>> call, Response<List<Banner>> response) {
                    if(response.isSuccessful()){
                        for (int i = 0; i <response.body().size() ; i++) {
                            Banner banner = new Banner();

                            banner.setId(response.body().get(i).getId());
                            banner.setDesc(response.body().get(i).getDesc());
                            banner.setImage(response.body().get(i).getImage());
                            banner.setTitle(response.body().get(i).getTitle());
                            System.out.println(banner.getId());
                            System.out.println(banner.getDesc());
                            System.out.println(banner.getImage());
                            System.out.println(banner.getTitle());
                            banners.add(banner);
                        }
                    }else {
                        System.out.println("Response fail");
                    }
                }

                @Override
                public void onFailure(Call<List<Banner>> call, Throwable t) {

                }
            });


            


        } catch (Exception e) {
            e.printStackTrace();
        }


        return banners;
    }
}
