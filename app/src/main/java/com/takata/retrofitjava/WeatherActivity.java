package com.takata.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    private static TextView city_name, dateTime, temperature, weatherDesc, humidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        String city_woeid = getIntent().getStringExtra("city_woeid");

        city_name = findViewById(R.id.cidade);
        dateTime = findViewById(R.id.data);
        temperature = findViewById(R.id.clima);
        weatherDesc = findViewById(R.id.descricao);
        humidity = findViewById(R.id.umidade);

        Retrofit client = new Retrofit.Builder()
                .baseUrl("https://api.hgbrasil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiWeather httpRequest = client.create(ApiWeather.class);

        Call<ApiPojo> call = httpRequest.getWeatherInfo(city_woeid, "pt");

        call.enqueue(callback);
    }

    private Callback<ApiPojo> callback = new Callback<ApiPojo>() {

        @Override
        public void onResponse(Call<ApiPojo> call, Response<ApiPojo> response) {

            city_name.setText(response.body().getResults().getCityName());
            dateTime.setText(response.body().getResults().getDate() + " - " + response.body().getResults().getTime());
            temperature.setText(response.body().getResults().getTemp() + " °C");
            weatherDesc.setText(response.body().getResults().getDescription());
            humidity.setText(String.valueOf(response.body().getResults().getHumidity()));

        }

        @Override
        public void onFailure(Call<ApiPojo> call, Throwable t) {
            Log.e("CallbackFail", "Erro de retorno: " + t.toString());
        }
    };
}