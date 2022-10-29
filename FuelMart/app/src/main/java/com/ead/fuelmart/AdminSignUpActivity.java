package com.ead.fuelmart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ead.fuelmart.databinding.ActivityAdminSignUpBinding;
import com.ead.fuelmart.databinding.ActivitySignUpBinding;
import com.ead.fuelmart.model.Station;
import com.ead.fuelmart.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminSignUpActivity extends AppCompatActivity {

    APIInterface apiInterface;
    Button SignUpButton;
    EditText name,password,rePass,province,district,town;
    private ActivityAdminSignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        Context context;
        context = this ;

        binding = ActivityAdminSignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(binding.toolbar);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        name = (EditText) findViewById(R.id.textstationName);
        password = (EditText) findViewById(R.id.textStationSignUpPassword);
        rePass= (EditText) findViewById(R.id.textStationRePassword);
//        province = (EditText) findViewById(R.id.TextVehicleNumber);
//        district = (EditText) findViewById(R.id.TextVehicleNumber);
//        town = (EditText) findViewById(R.id.TextVehicleNumber);

        SignUpButton = (Button) findViewById(R.id.buttonStationSignUp);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String station = name.getText().toString();
                String pass = password.getText().toString();
                String rPass = rePass.getText().toString();
//                String uVehicleNumber = vehicleNumber.getText().toString();
//                String vehicleType = vehicleTypeString;


                if (station.equals("")||pass.equals("")||rPass.equals("")) {
                    Toast.makeText(AdminSignUpActivity.this, "please Enter All The Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(rPass)) {

                        Station stationObj = new Station(station, pass, "Western province","Colombo", "Kadawatha");
                        Call<Station> call1 = apiInterface.createStation(stationObj);
                        call1.enqueue(new Callback<Station>() {
                            @Override
                            public void onResponse(Call<Station> call, Response<Station> response) {
                                Station station = response.body();
                                Toast.makeText(getApplicationContext(), station.station , Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(context,AdminSignInActivity.class);
                                startActivity(intent);
                            }



                            @Override
                            public void onFailure(Call<Station> call, Throwable t) {
                                call.cancel();
                                Toast.makeText(getApplicationContext(), "Error" , Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(AdminSignUpActivity.this, "Passwords are not matching.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF9800"));
        actionBar.setBackgroundDrawable(colorDrawable);
    }
}