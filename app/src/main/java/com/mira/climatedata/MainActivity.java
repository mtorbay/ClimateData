package com.mira.climatedata;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // url: https://pkgstore.datahub.io/core/global-temp/monthly_json/data/4c7af7363a20648a68b8f2038a6765d6/monthly_json.json

    // labels
    TextView txtTitle, txtYear, txtJanLabel, txtFebLabel, txtMarLabel, txtAprLabel, txtMayLabel, txtJunLabel, txtJulLabel, txtAugLabel, txtSepLabel, txtOctLabel, txtNovLabel, txtDecLabel;

    // textviews that will actually have data
    TextView txtJan, txtFeb, txtMar, txtApr, txtMay, txtJun, txtJul, txtAug, txtSep, txtOct, txtNov, txtDec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // labels
        txtTitle=findViewById(R.id.txtTitle);
        txtYear=findViewById(R.id.txtYear);
        txtJanLabel=findViewById(R.id.txtJanLabel);
        txtFebLabel=findViewById(R.id.txtFebLabel);
        txtMarLabel=findViewById(R.id.txtMarLabel);
        txtAprLabel=findViewById(R.id.txtAprLabel);
        txtMayLabel=findViewById(R.id.txtMayLabel);
        txtJunLabel=findViewById(R.id.txtJunLabel);
        txtJulLabel=findViewById(R.id.txtJulLabel);
        txtAugLabel=findViewById(R.id.txtAugLabel);
        txtSepLabel=findViewById(R.id.txtSepLabel);
        txtOctLabel=findViewById(R.id.txtOctLabel);
        txtNovLabel=findViewById(R.id.txtNovLabel);
        txtDecLabel=findViewById(R.id.txtDecLabel);

        // textviews for data
        txtJan=findViewById(R.id.txtJan);
        txtFeb=findViewById(R.id.txtFeb);
        txtMar=findViewById(R.id.txtMar);
        txtApr=findViewById(R.id.txtApr);
        txtMay=findViewById(R.id.txtMay);
        txtJun=findViewById(R.id.txtJun);
        txtJul=findViewById(R.id.txtJul);
        txtAug=findViewById(R.id.txtAug);
        txtSep=findViewById(R.id.txtSep);
        txtOct=findViewById(R.id.txtOct);
        txtNov=findViewById(R.id.txtNov);
        txtDec=findViewById(R.id.txtDec);

        afficher();
    }

    public void afficher()
    {
        String url="https://pkgstore.datahub.io/core/global-temp/monthly_json/data/4c7af7363a20648a68b8f2038a6765d6/monthly_json.json";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    //Premier objet de l'array
                    JSONObject jan=response.getJSONObject(0);

                    //Log.d("premier", "resultat ="+premier.toString());
                    Log.d("jan", "resultat ="+jan.getString("Date"));

                    //temp rounding
                    int TEMPjan=(int)Math.round(jan.getDouble("Mean"));
                    String TEMP01=String.valueOf(TEMPjan);

                    txtYear.setText("2016");
                    txtJan.setText(TEMP01);



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
