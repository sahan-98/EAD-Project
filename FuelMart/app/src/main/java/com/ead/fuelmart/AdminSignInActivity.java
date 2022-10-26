package com.ead.fuelmart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;

public class AdminSignInActivity extends AppCompatActivity {
    Button AdminSignInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_in);

        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#FF9800"));
        actionBar.setBackgroundDrawable(colorDrawable);

        AdminSignInButton = (Button) findViewById(R.id.buttonAdminSignUp);
        findViewById(R.id.buttonAdminSignUp)
                .setOnClickListener( v -> {
                    Intent intent = new Intent(this,AdminSignUpActivity.class);
//                    intent.putExtra("name",'1');
                    startActivity(intent);
                });
    }
}