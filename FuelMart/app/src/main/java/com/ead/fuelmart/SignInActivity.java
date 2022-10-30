package com.ead.fuelmart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ead.fuelmart.databinding.ActivitySignInBinding;
import com.ead.fuelmart.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.ead.fuelmart.model.AuthUser;

public class SignInActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivitySignInBinding binding;

    Button SignInButton;
    TextView DisplayText;
    EditText EmailDataField;
    EditText PasswordDataField;
    APIInterface apiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Context context;
        context = this ;

        apiInterface = APIClient.getClient().create(APIInterface.class);

        EmailDataField = (EditText) findViewById(R.id.TextUserEmailAddress);
        PasswordDataField = (EditText) findViewById(R.id.TextUserPassword);

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

        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = EmailDataField.getText().toString();
                String pass = PasswordDataField.getText().toString();


                if (pass.equals("")||Email.equals("")) {
                    Toast.makeText(SignInActivity.this, "please Enter All The Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                        AuthUser authObj = new AuthUser(Email, pass);
                        Call<AuthUser> call = apiInterface.AuthUser(authObj);
                        call.enqueue(new Callback<AuthUser>() {
                            @Override
                            public void onResponse(Call<AuthUser> call, Response<AuthUser> response) {
                                AuthUser user1 = response.body();
                                Intent intent = new Intent(context,FilterPage.class);
                                startActivity(intent);
//                                intent.putExtra("email", user1.email);
                            }

                            @Override
                            public void onFailure(Call<AuthUser> call, Throwable t) {
                                call.cancel();
                                Toast.makeText(getApplicationContext(), "Error" , Toast.LENGTH_SHORT).show();
                            }
                        });
                }
            }
        });


        findViewById(R.id.buttonSignUp1)
                .setOnClickListener( v -> {
                    Intent intent = new Intent(this,SignUpActivity.class);
                    startActivity(intent);
                });


    }
}