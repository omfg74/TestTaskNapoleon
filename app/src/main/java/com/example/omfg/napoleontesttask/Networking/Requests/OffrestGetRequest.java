package com.example.omfg.napoleontesttask.Networking.Requests;

import com.example.omfg.napoleontesttask.Networking.Interfaces.ResponseInterface;
import com.example.omfg.napoleontesttask.Networking.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import AppObjects.Offer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffrestGetRequest {

    List<AppObjects.Offer> offers = new ArrayList<>();

    public List<AppObjects.Offer> getOffers(){
        RetrofitClient retrofitClient = new RetrofitClient();

        try{
            Call<List<AppObjects.Offer>> response =retrofitClient.getRetrofitInterface().getOffers();
            response.enqueue(new Callback<List<Offer>>() {
                @Override
                public void onResponse(Call<List<Offer>> call, Response<List<Offer>> response) {
                    if(response.isSuccessful()){
                        for (int i = 0; i <response.body().size() ; i++) {
                            Offer offer = new Offer();
                            offer.setDesc(response.body().get(i));
                            offer.setDiscount(response.body().get(i));
                            offer.setGroupName(response.body().get(i));
                            offer.setId(response.body().get(i));
                            offer.setImage(response.body().get(i));
                            offer.setName(response.body().get(i));
                            offer.setPrice(response.body().get(i));
                            offer.setType(response.body().get(i));

                        }
                    }else {
                        System.out.println("fail");
                    }
                }

                @Override
                public void onFailure(Call<List<Offer>> call, Throwable t) {

                }
            });
        }


        return offers;
    }
}
