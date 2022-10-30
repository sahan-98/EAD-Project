package com.ead.fuelmart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//import com.android.volley.AuthFailureError;
//import com.android.volley.NetworkResponse;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.ServerError;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.HttpHeaderParser;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class PumpVolume extends AppCompatActivity {
    private Button submit_btn;
    private String stationId, fuelType, pumpedVolume;
    private EditText amount;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pump_fuel_volume);

//        Intent intent = getIntent();
//        stationId = intent.getStringExtra("stationId");
//
//        submit_btn = findViewById(R.id.btn_pumpSave);
//
//        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.FuelTypes, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
//
//        amount = findViewById(R.id.pumped_vol);
//        pumpedVolume = amount.getText().toString();
//
//        submit_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                exitAfterPumping();
//            }
//        });
//    }
//    public void exitAfterPumping() {
//        final HashMap<String, String> params = new HashMap<>();
//        params.put("stationId", stationId);
//        params.put("fuelType", fuelType);
//        params.put("pumpedVolume", pumpedVolume);

        String apiKey = "https://ead-fuel-app.herokuapp.com/api/fuel-station/exit-after-pump";
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
//                apiKey, new JSONObject(params), new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    if (response.getBoolean("success")) {
//                        Log.e("HttpClient", "inside onResponse");
//                        String msg = response.getString("message"); //access response body
//
//                        //navigate user back to login interface
//                        Toast.makeText(PumpVolume.this, "Thank you!", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(PumpVolume.this, SignInActivity.class);
//                        startActivity(intent);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//                NetworkResponse response = error.networkResponse;
//                if (error instanceof ServerError && response != null) {
//                    try {
//                        String res = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                        JSONObject obj = new JSONObject(res);
//                        Toast.makeText(PumpVolume.this, "Couldn't update fuel volume", Toast.LENGTH_SHORT).show();
//                    } catch (JSONException | UnsupportedEncodingException je) {
//                        je.printStackTrace();
//                    }
//                }
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<>();
//                headers.put("Content-Type", "application/json");
//                return params;
//            }
//        };
//        // request add
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(jsonObjectRequest);
    }
}

