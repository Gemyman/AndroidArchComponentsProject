package com.ex.androidarchcomponentsproject.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Serverconnection {
    public static Retrofit retrofit = null;

    public static Retrofit getApiClien() {
        if (retrofit == null) {
                        OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS).build();
            retrofit = new Retrofit.Builder().baseUrl(Url.ServerUrl).
                    addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit;
    }

}
