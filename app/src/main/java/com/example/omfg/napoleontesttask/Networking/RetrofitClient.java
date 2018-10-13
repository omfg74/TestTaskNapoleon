package com.example.omfg.napoleontesttask.Networking;

import com.example.omfg.napoleontesttask.BuildConfig;
import com.example.omfg.napoleontesttask.Networking.Interfaces.RetrofitInterface;
import com.example.omfg.napoleontesttask.AppObjects.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//Клиент для работы с апи. Небыло острой необходимости выносиь его в отдельный класс, однако
//если бы запросов было больше это значительно бы сэкономило время
public class RetrofitClient {
    private static RetrofitClient instance = null;
    private Retrofit retrofit;
    private OkHttpClient client;
    public static final String API_URL = "http://s3.eu-central-1.amazonaws.com/sl.files/";
    private RetrofitInterface retrofitInterface;

    public RetrofitClient() {
//Перехватчик ответов сервера, работает тольок при отладочной сборке, здесь исключительно для отладки запросов
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.addInterceptor(loggingInterceptor);

        if (BuildConfig.DEBUG) {
            okHttpBuilder.addInterceptor(loggingInterceptor);
        }

        client = okHttpBuilder.build();

        retrofit = new Retrofit.Builder().baseUrl(API_URL)
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
