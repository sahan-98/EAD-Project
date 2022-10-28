package com.ead.fuelmart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;


public class FilterPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private Spinner spinner_district;
    private Spinner spinner_town;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_page);
        spinner_district = findViewById(R.id.spinnerDistrict);


        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);



        ArrayAdapter<CharSequence> Dadapter = ArrayAdapter.createFromResource(this,R.array.WesternDistricts, android.R.layout.simple_spinner_item);
        Dadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_district.setAdapter(Dadapter);
        spinner_district.setOnItemSelectedListener(this);


        listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> stationList =  new ArrayList<>();

        stationList.add("dsdsd");
        stationList.add("fdgg");
        stationList.add("dsdgfgdfsd");
        stationList.add("dsgdfgdsd");
        stationList.add("dsgdfgdsd");
        stationList.add("dsgdfgdsd");
        stationList.add("dsgdfgdsd");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,stationList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(FilterPage.this,DetailsPage.class);
                startActivity(intent);

                Toast.makeText(FilterPage.this,"clicked item:" +i+ " " + stationList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View arg1, int i,long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        String province = adapterView.getItemAtPosition(i).toString();

        if (province.equals("Colombo")) {
            spinner_town = findViewById(R.id.spinnerTown);

            ArrayAdapter<CharSequence> Tadapter = ArrayAdapter.createFromResource(this, R.array.ColomboTowm, android.R.layout.simple_spinner_item);
            Tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_town.setAdapter(Tadapter);
        }else if (province.equals("Gampaha")) {
            spinner_town = findViewById(R.id.spinnerTown);

            ArrayAdapter<CharSequence> Tadapter = ArrayAdapter.createFromResource(this, R.array.GampahaTowm, android.R.layout.simple_spinner_item);
            Tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_town.setAdapter(Tadapter);
        }

        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
