package com.ead.fuelmart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ead.fuelmart.model.Admin;
import com.ead.fuelmart.model.Station;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsPage extends AppCompatActivity {

    private Button petrolQueueBtn;
    private Button dieselQueueBtn;
    private Button addQue;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    private String id;
    Integer textp1,textp2,textp3,textd1,textd2,textd3;
    String tp1;

    APIInterface apiInterface;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        petrolQueueBtn = findViewById(R.id.PetrolButton);
        dieselQueueBtn = findViewById(R.id.DieselButton);
        addQue = findViewById(R.id.AddQue);

        addQue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsPage.this,FullOrExit.class);
                startActivity(intent);
            }
        });
        textView1 = findViewById(R.id.textAvPetrol);
        textView2 = findViewById(R.id.textAvDiesel);

        textView3 = findViewById(R.id.P1textView);
        textView4 = findViewById(R.id.P2textView);
        textView5 = findViewById(R.id.P3textView);
        textView6 = findViewById(R.id.D1textView);
        textView7 = findViewById(R.id.D2textView);
        textView8 = findViewById(R.id.D3textView);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Intent intent = getIntent();
        id = intent.getStringExtra("stationId");

        System.out.println(id);


        Call<Station> call = apiInterface.doGetStationById(id);
        call.enqueue(new Callback<Station>() {
            @Override
            public void onResponse(Call<Station> call, Response<Station> response) {

                Station station = response.body();
                Boolean text1 = station.petrol;
                Boolean text2 = station.diesel;

                System.out.println(text1);
                System.out.println(station);

               if (text1 == false){

                   textView1.setText("Not Available");
               }else
                {
                    textView1.setText("Available");
                }

               if(text2 == true){
                   textView2.setText("Available");
               }else {
                   textView2.setText("Not Available");
               }


            }


            @Override
            public void onFailure(Call<Station> call, Throwable t) {

            }
        });

        Call<Admin> call1 = apiInterface.doGetStationQue(id);
        call1.enqueue(new Callback<Admin>() {
            @Override
            public void onResponse(Call<Admin> call, Response<Admin> response) {
                Admin admin = response.body();

                 textp1 = admin.totalArivalBycicles;
                 textp2 = admin.totalArivalPOtherVehicles;
                 textp3 = admin.totalArivalThreewheels;
                 textd1 = admin.totalArivalLorries;
                 textd2 = admin.totalArivalBuses;
                 textd3 = admin.totalArivalDOtherVehicles;

                 System.out.println(textp1);

                 tp1 = String.valueOf(textp1);

//                textView3.setText(textp1);
//                textView4.setText(textp2);
//                textView5.setText(textp3);
//                textView6.setText(textd1);
//                textView7.setText(textd2);
//                textView8.setText(textd3);


            }

            @Override
            public void onFailure(Call<Admin> call, Throwable t) {

            }
        });



        petrolQueueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPretolQue();
            }
        });

        dieselQueueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDieselQue();
            }
        });

    }
    private void showPretolQue(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.show_pretol_que_dpage);

        Button btnClose = dialog.findViewById(R.id.PCloseButton);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        textView3.setText(tp1);
//        textView4.setText(Integer.toString(textp2));
//        textView5.setText(Integer.toString(textp3));


        dialog.show();
    }

    private void showDieselQue(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.show_diesel_que_dpage);

        Button btnClose = dialog.findViewById(R.id.DCloseButton);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

//        textView6.setText(Integer.toString(textd1));
//        textView7.setText(Integer.toString(textd2));
//        textView8.setText(Integer.toString(textd3));

        dialog.show();
    }





}