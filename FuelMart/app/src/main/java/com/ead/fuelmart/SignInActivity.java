package com.ead.fuelmart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ead.fuelmart.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivitySignInBinding binding;

    private String BASE_URL = "http://127.0.0.1:4000/";

    Button SignInButton; // button which on clicking, sends the request
    TextView DisplayText; // a text field to display the request response
    EditText EmailDataField; // a text field where the data to be sent is entered
    EditText PasswordDataField; // a text field where the data to be sent is entered

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF9800"));
        actionBar.setBackgroundDrawable(colorDrawable);

        SignInButton = (Button) findViewById(R.id.buttonSignIn1);
        EmailDataField = (EditText) findViewById(R.id.TextUserEmailAddress);
        PasswordDataField = (EditText) findViewById(R.id.TextUserPassword);

//        if (user.equals("")||pass.equals("")||rPass.equals("")||uEmail.equals("")||uVehicleNumber.equals("")) {
//            Toast.makeText(SignUpActivity.this, "please Enter All The Fields", Toast.LENGTH_SHORT).show();
//        }else{
//
//        }
        findViewById(R.id.buttonSignUp1)
                .setOnClickListener( v -> {
                    Intent intent = new Intent(this,SignUpActivity.class);
                    startActivity(intent);
                });

        findViewById(R.id.buttonSignIn1)
                .setOnClickListener(v -> {
                    Intent intent = new Intent(this,FilterPage.class);
                    startActivity(intent);
                });
    }
}