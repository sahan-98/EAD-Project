package com.ead.fuelmart;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsPage extends AppCompatActivity {

    private Button petrolQueueBtn;
    private Button dieselQueueBtn;
    private Button addQue;

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

        dialog.show();
    }





}