package com.example.weatherapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final String[] days3 = {"1 day Temp", "2 day Temp", "3 day Temp", "4 day Temp"};
    private final String[] days = {"1 day Temp", "2 day Temp", "3 day Temp", "4 day Temp", "5 day Temp"};

    final DaysAdapter adapter = new DaysAdapter();

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


        final RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        /*final Button buttonDeleteTwoDays = findViewById(R.id.buttonThreeDay);
        buttonDeleteTwoDays.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTwoDay(Arrays.asList(days3));
            }
        });*/

        addDays(Arrays.asList(days));

        }

        /*public void deleteTwoDay (List<String> days){
        adapter.justSetDays(days);
            adapter.notifyItemRemoved(3);
            adapter.notifyItemRemoved(4);
        }*/

        public void addDays(List<String> days){
        adapter.setDays(days);

        }


    public void сhange (View view){
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (view.getId()){

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