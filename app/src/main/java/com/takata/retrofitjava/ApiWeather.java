package com.takata.retrofitjava;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiWeather {
    @GET("weather?woeid={city}&locale=pt")
    Call<ApiPojo> getWeatherInfo(@Path("city") String city);
}
