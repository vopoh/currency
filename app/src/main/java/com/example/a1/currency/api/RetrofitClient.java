package com.example.a1.currency.api;

import com.example.a1.currency.constants.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitClient {

    private static FixerApi fixerApi;
    private static Retrofit retrofit;

    public static FixerApi getApi() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        retrofit = builder
                .client(httpClient.build())
                .build();

        fixerApi = retrofit.create(FixerApi.class);

        return fixerApi;
    }
}
