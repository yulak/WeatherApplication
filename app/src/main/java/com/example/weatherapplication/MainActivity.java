package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    List_of_cities_fragment fragCity;
    Settings_fragment fragSettings;
    FragmentTransaction fTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragCity = new List_of_cities_fragment();
        fragSettings = new Settings_fragment();

    }

    public void Change(View view){
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.city:
                fTrans.add(R.id.fragment_main, fragCity);
                break;
            case R.id.settings:
                fTrans.replace(R.id.fragment_main, fragSettings);
            default:
                break;
        }
        fTrans.commit();
    }

    /*public void Change (View view){
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
        ft.replace(R.id.fragment_main, fragment);
        ft.commit();
    }*/
}