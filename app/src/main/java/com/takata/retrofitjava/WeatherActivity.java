package com.takata.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        String city_woeid = getIntent().getStringExtra("city_woeid");

        TextView city_name = findViewById(R.id.cidade);
        TextView dateTime = findViewById(R.id.data);
        TextView temperature = findViewById(R.id.clima);
        TextView weatherDesc = findViewById(R.id.descricao);
        TextView humidity = findViewById(R.id.umidade);
        TextView maxTemp = findViewById(R.id.temp_maxima);
        TextView minTemp = findViewById(R.id.temp_minima);

        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://api.hgbrasil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiWeather httpRequest = client.create(ApiWeather.class);

        Call<ApiPojo> call = httpRequest.getWeatherInfo(city_woeid);

        call.enqueue(callback);
    }

    private Callback<ApiPojo> callback = new Callback<ApiPojo>() {

        @Override
        public void onResponse(Call<ApiPojo> call, Response<ApiPojo> response) {
            //city_name.setText(response.body().getResults().getCityName()); - ??
        }

        @Override
        public void onFailure(Call<ApiPojo> call, Throwable t) {

        }
    };
}