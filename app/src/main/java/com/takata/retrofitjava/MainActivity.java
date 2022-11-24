package com.takata.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner menu_cidade = (Spinner) findViewById(R.id.spinner_cidade);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu_cidade.setAdapter(adapter);

        Button btn_search = findViewById(R.id.btn_consultar);
        btn_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                Long city_id = menu_cidade.getSelectedItemId();
                String woeid = "";

                if (city_id == 0) {
                    woeid = "455918"; //Umuarama
                } else if (city_id == 1) {
                    woeid = "455883"; //Maringá
                } else if (city_id == 2){
                    woeid = "455832"; //Londrina
                }

                intent.putExtra("city_woeid", woeid);
                startActivity(intent);
                Log.e("CityIntent", "City WOEID: " + woeid);

            }
        });
    }
}