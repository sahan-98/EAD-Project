package com.ead.fuelmart;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;

import com.ead.fuelmart.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ead.fuelmart.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySignUpBinding binding;

    TextView responseText;
    APIInterface apiInterface;
    Button SignUpButton;
    EditText name,password,rePass,email,vehicleType,vehicleNumber,fuelType;
    Spinner spinnerVehicleType, spinnerFuelType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        spinnerVehicleType=findViewById(R.id.spinnerVehicleType);
        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.VehicleTypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerVehicleType.setAdapter(adapter);
        spinnerVehicleType.setOnItemSelectedListener(this);


        name = (EditText) findViewById(R.id.TextUserName);
        email = (EditText) findViewById(R.id.TextUserEmailAddress1);
        password = (EditText) findViewById(R.id.TextUserPassword1);
        rePass= (EditText) findViewById(R.id.TextUserRePassword);
        vehicleNumber = (EditText) findViewById(R.id.TextVehicleNumber);

        SignUpButton = (Button) findViewById(R.id.buttonSignUp);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String uEmail = email.getText().toString();
                String pass = password.getText().toString();
                String rPass = rePass.getText().toString();
                String uVehicleNumber = vehicleNumber.getText().toString();

                if (user.equals("")||pass.equals("")||rPass.equals("")||uEmail.equals("")||uVehicleNumber.equals("")) {
                    Toast.makeText(SignUpActivity.this, "please Enter All The Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pass.equals(rPass)) {

                        User userObj = new User(user, uEmail, pass, "car", uVehicleNumber, "petrol");
                        Call<User> call1 = apiInterface.createUser(userObj);
                        call1.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                User user1 = response.body();
                                Toast.makeText(getApplicationContext(), user1.name + " " + user1.email , Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                call.cancel();
                                Toast.makeText(getApplicationContext(), "Error" , Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(SignUpActivity.this, "Passwords are not matching.", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

}