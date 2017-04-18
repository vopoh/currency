package com.example.a1.currency.api;

import com.example.a1.currency.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface FixerApi {
    @GET("latest")
    Observable<Response> getRates(
            @Query("base") String base,
            @Query("symbols") String symbols
    );
}
