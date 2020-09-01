package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Change (View view){
        Fragment fragment = null;

        switch (view.getId()){
            case R.id.city: //нажимая эту кнопку вылезут города
                fragment = new List_of_cities_fragment();
                break;
            case R.id.settings: //нажимая эту кнопку вылезут настройки
                fragment = new Settings_fragment();
                break;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_main, fragment);
        ft.commit();
    }
}