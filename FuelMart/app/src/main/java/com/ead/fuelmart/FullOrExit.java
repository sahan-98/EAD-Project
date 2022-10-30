package com.ead.fuelmart;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FullOrExit extends AppCompatActivity {

    private String stationId, userid, vehicleType, fuelType;
    private TextView exitHeading;
    private Button exitBeforePump, exitAfterPump;

    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_or_exit);

        exitAfterPump = findViewById(R.id.btn_full);

        exitAfterPump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FullOrExit.this,PumpVolume.class);
                startActivity(intent);
            }
        });

//            Intent intent = getIntent();
//            stationId = intent.getStringExtra("stationId");
//            userid = intent.getStringExtra("userid");
//            fuelType = intent.getStringExtra("fuelType");
//            vehicleType = intent.getStringExtra("vehicleType");
//
//            //set dynamic heading at the top of the exit screen
//            exitHeading = findViewById(R.id.exitHeading);
//            exitHeading.setText("Are you sure you want to exit the "+vehicleType+" queue?");
//
//            exitBeforePump = findViewById(R.id.btn_exit);
//            exitAfterPump = findViewById(R.id.btn_full);

//            exitBeforePump.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    //exit the user from the correct queue
////                    exitUserFromCorrectFuelQueue();
//
//                    Toast.makeText(FullOrExit.this, "You Exit the queue. Thank you!", Toast.LENGTH_SHORT).show();
//                    //navigate user back to login interface
//                    Intent intent = new Intent(FullOrExit.this, SignInActivity.class);
//                    startActivity(intent);
//                }
//            });
//
//            exitAfterPump.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    //exit the user from the correct queue
////                    exitUserFromCorrectFuelQueue();
//
//                    //navigate user to the next interface to get pumped fuel amount
//                    Intent intent = new Intent(FullOrExit.this, PumpVolume.class);
//                    intent.putExtra("stationId", stationId);
//                    startActivity(intent);
//                }
//            });
//        }
//        public void exitUserFromCorrectFuelQueue() {
//            final HashMap<String, String> params = new HashMap<>();
//            params.put("stationId", stationId);
//            params.put("userid", userid);
//            params.put("fuelType", fuelType);
//            params.put("vehicleType", vehicleType);

//
//            String apiKey = "http://localhost:4000/api/fuel-station/exit-queue";
//
//            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
//                    apiKey, new JSONObject(params), new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
//                    try {
//                        if (response.getBoolean("success")) {
//                            Log.e("HttpClient", "inside onResponse");
//                            String msg = response.getString("message"); //access response body
//                            Toast.makeText(FullOrExit.this, msg, Toast.LENGTH_SHORT).show();
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                    NetworkResponse response = error.networkResponse;
//                    if (error instanceof ServerError && response != null) {
//                        try {
//                            String res = new String(response.data, HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                            JSONObject obj = new JSONObject(res);
//                            Toast.makeText(FullOrExit.this, "You should be joined first before exit", Toast.LENGTH_SHORT).show();
//                        } catch (JSONException | UnsupportedEncodingException je) {
//                            je.printStackTrace();
//                        }
//                    }
//                }
//            }) {
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                    HashMap<String, String> headers = new HashMap<>();
//                    headers.put("Content-Type", "application/json");
//                    return params;
//                }
//            };
//
//            // request add
//            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            requestQueue.add(jsonObjectRequest);
//        }
    }
}
