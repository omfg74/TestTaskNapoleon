package com.example.omfg.napoleontesttask.Networking;

import com.example.omfg.napoleontesttask.BuildConfig;
import com.example.omfg.napoleontesttask.Networking.Interfaces.RetrofitInterface;
import com.example.omfg.napoleontesttask.AppObjects.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;

    private RetrofitInterface retrofitInterface;

    public RetrofitClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addInterceptor(loggingInterceptor);

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        client = okHttpBuilder.build();

        retrofit = new Retrofit.Builder().baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }

        return instance;
    }

    public RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }
}
