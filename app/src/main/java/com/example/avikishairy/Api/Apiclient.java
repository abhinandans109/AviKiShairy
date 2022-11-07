package com.example.avikishairy.Api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    public static Retrofit retrofit=null;
    public static Retrofit getclient(){
        if(retrofit==null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            Gson gson = new GsonBuilder().create();
            retrofit = new Retrofit.Builder().baseUrl("http://192.168.108.110/shairyapis/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }
return retrofit;
    }
}
