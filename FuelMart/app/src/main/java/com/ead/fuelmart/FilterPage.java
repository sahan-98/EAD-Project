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
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


public class FilterPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner_province;
    private Spinner spinner_district;
//    private ArrayAdapter<String> adapterDistrict,adapterCity;

    private Button AddButton; // button which on clicking, sends the request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_page);
        spinner_province = findViewById(R.id.spinnerProvince);

        AddButton = findViewById(R.id.buttonDetails);

        ActionBar actionBar;
        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#0F9D58"));
        actionBar.setBackgroundDrawable(colorDrawable);

        findViewById(R.id.buttonDetails)
                .setOnClickListener( v -> {
                    Intent intent = new Intent(this,DetailsPage.class);
//                    intent.putExtra("name",'1');
                    startActivity(intent);
                });




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.provinces, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_province.setAdapter(adapter);
        spinner_province.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View arg1, int i,long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        String province = adapterView.getItemAtPosition(i).toString();

        if (province.equals("Western")) {
            spinner_district = findViewById(R.id.spinnerDistrict);

            ArrayAdapter<CharSequence> Dadapter = ArrayAdapter.createFromResource(this, R.array.WesternDistricts, android.R.layout.simple_spinner_item);
            Dadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_district.setAdapter(Dadapter);
        }else if (province.equals("Southern")) {
            spinner_district = findViewById(R.id.spinnerDistrict);

            ArrayAdapter<CharSequence> Dadapter = ArrayAdapter.createFromResource(this, R.array.SouthernDistricts, android.R.layout.simple_spinner_item);
            Dadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_district.setAdapter(Dadapter);
        }

        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
