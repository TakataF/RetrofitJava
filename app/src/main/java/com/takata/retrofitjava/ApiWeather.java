package com.takata.retrofitjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;

public interface ApiWeather {
    @GET("weather")
    Call<ApiPojo> getWeatherInfo(@Query("woeid") String city, @Query("locale") String locale);
}
