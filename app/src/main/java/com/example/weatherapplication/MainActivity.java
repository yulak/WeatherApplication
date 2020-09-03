package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ListOfCitiesFragment fragCity;
    SettingsFragment fragSettings;
    FragmentTransaction fTrans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragCity = new ListOfCitiesFragment();
        fragSettings = new SettingsFragment();

    }

    public void сhange (View view){
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.city:
                fTrans.remove(fragSettings);
                fTrans.replace(R.id.fragment_main, fragCity);
                break;
            case R.id.settings:
                fTrans.replace(R.id.fragment_main, fragSettings);
                fTrans.remove(fragCity);
            default:
                break;
        }
        fTrans.commit();
    }

}