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
import java.util.List;

import com.ead.fuelmart.model.Station;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilterPage extends AppCompatActivity {


    private Spinner spinner_district;
    private Spinner spinner_town;
    private ListView listView;

    String district = "",town = "" ;
    APIInterface apiInterface;

    ArrayList<String> stationList =  new ArrayList<>();
    ArrayList<String> stationList2 =  new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_page);
        spinner_district = findViewById(R.id.spinnerDistrict);
        spinner_town = findViewById(R.id.spinnerTown);
        listView = findViewById(R.id.listView);


        apiInterface = APIClient.getClient().create(APIInterface.class);



        ActionBar actionBar;
        actionBar = getSupportActionBar();

        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);



        ArrayAdapter<CharSequence> Dadapter = ArrayAdapter.createFromResource(this,R.array.WesternDistricts, android.R.layout.simple_spinner_item);
        Dadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_district.setAdapter(Dadapter);

        spinner_district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                district = spinner_district.getSelectedItem().toString();

                System.out.println(district);

                if (district.equals("Colombo")) {


                    ArrayAdapter<CharSequence> Tadapter = ArrayAdapter.createFromResource(FilterPage.this, R.array.ColomboTowm, android.R.layout.simple_spinner_item);
                    Tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_town.setAdapter(Tadapter);


                }else if (district.equals("Gampaha")) {

                    ArrayAdapter<CharSequence> Tadapter = ArrayAdapter.createFromResource(FilterPage.this, R.array.GampahaTowm, android.R.layout.simple_spinner_item);
                    Tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner_town.setAdapter(Tadapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_town.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                town = spinner_town.getSelectedItem().toString();

                System.out.println(town);

                Call<Station> call2 = apiInterface.doGetStationList(district,town);

                call2.enqueue(new Callback<Station>() {
                    @Override
                    public void onResponse(Call<Station> call, Response<Station> response) {

                        Station station = response.body();
                        List<Station.Datum> datumList = station.data;

                        for (Station.Datum datum : datumList) {
                            stationList.add(datum.stationName);
                            stationList2.add(datum.stationid);


                        }

                        ArrayAdapter arrayAdapter = new ArrayAdapter(FilterPage.this, android.R.layout.simple_list_item_1,stationList);
                        listView.setAdapter(arrayAdapter);
                    }

                    @Override
                    public void onFailure(Call<Station> call, Throwable t) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String shedId = stationList2.get(i);

                System.out.println(shedId);

                Intent intent = new Intent(FilterPage.this,DetailsPage.class);
                intent.putExtra("stationId",shedId);
                startActivity(intent);

                Toast.makeText(FilterPage.this,"clicked item:" +i+ " " + stationList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
