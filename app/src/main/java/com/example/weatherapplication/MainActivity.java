package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListOfCitiesFragment fragCity;
    SettingsFragment fragSettings;
    FragmentTransaction fTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_main, new ListOfCitiesFragment())
                    .commit();
            }
        final Button site = findViewById(R.id.internet_temperature);
        Button go = findViewById(R.id.internet_temperature);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = site.getText().toString();
                Uri uri = Uri.parse("https://yandex.ru/pogoda/moscow");
                Intent browser = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(browser);
            }
        });
        }

    public void сhange (View view){
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.button_clear:
                fTrans.remove(fragSettings);
                fTrans.remove(fragCity);
                break;
            case R.id.city:
                fTrans.replace(R.id.fragment_main, new ListOfCitiesFragment());
                break;
            case R.id.settings:
                fTrans.replace(R.id.fragment_main, new SettingsFragment());
                default:
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();

    }


}