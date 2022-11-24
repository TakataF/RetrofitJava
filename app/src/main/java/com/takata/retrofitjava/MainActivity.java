package com.takata.retrofitjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button bt_consultar;

    Spinner menu_cidade = (Spinner) findViewById(R.id.spinner_cidade);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city_array, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu_cidade.setAdapter(adapter);

        bt_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void IniciarComponentes(){
        bt_consultar = findViewById(R.id.bt_consulta);
    }
}