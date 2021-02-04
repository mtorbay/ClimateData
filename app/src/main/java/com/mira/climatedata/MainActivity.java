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
                    //Objets
                    JSONObject dec=response.getJSONObject(0);
                    JSONObject nov=response.getJSONObject(2);
                    JSONObject oct=response.getJSONObject(4);
                    JSONObject sep=response.getJSONObject(6);
                    JSONObject aug=response.getJSONObject(8);
                    JSONObject jul=response.getJSONObject(10);
                    JSONObject jun=response.getJSONObject(12);
                    JSONObject may=response.getJSONObject(14);
                    JSONObject apr=response.getJSONObject(16);
                    JSONObject mar=response.getJSONObject(18);
                    JSONObject feb=response.getJSONObject(20);
                    JSONObject jan=response.getJSONObject(22);

                    //Log.d("premier", "resultat ="+premier.toString());
                    Log.d("dec", "resultat ="+dec.getString("Date"));

                    //temp double --> string
                    double TEMPjan=jan.getDouble("Mean");
                    String TEMP01=String.valueOf(TEMPjan);

                    double TEMPfeb=feb.getDouble("Mean");
                    String TEMP02=String.valueOf(TEMPfeb);

                    double TEMPmar=mar.getDouble("Mean");
                    String TEMP03=String.valueOf(TEMPmar);

                    double TEMPapr=apr.getDouble("Mean");
                    String TEMP04=String.valueOf(TEMPapr);

                    double TEMPmay=may.getDouble("Mean");
                    String TEMP05=String.valueOf(TEMPmay);

                    double TEMPjun=jun.getDouble("Mean");
                    String TEMP06=String.valueOf(TEMPjun);

                    double TEMPjul=jul.getDouble("Mean");
                    String TEMP07=String.valueOf(TEMPjul);

                    double TEMPaug=aug.getDouble("Mean");
                    String TEMP08=String.valueOf(TEMPaug);

                    double TEMPsep=sep.getDouble("Mean");
                    String TEMP09=String.valueOf(TEMPsep);

                    double TEMPoct=oct.getDouble("Mean");
                    String TEMP10=String.valueOf(TEMPoct);

                    double TEMPnov=nov.getDouble("Mean");
                    String TEMP11=String.valueOf(TEMPnov);

                    double TEMPdec=dec.getDouble("Mean");
                    String TEMP12=String.valueOf(TEMPdec);

                    txtYear.setText("2016");
                    txtJan.setText(TEMP01);
                    txtFeb.setText(TEMP02);
                    txtMar.setText(TEMP03);
                    txtApr.setText(TEMP04);
                    txtMay.setText(TEMP05);
                    txtJun.setText(TEMP06);
                    txtJul.setText(TEMP07);
                    txtAug.setText(TEMP08);
                    txtSep.setText(TEMP09);
                    txtOct.setText(TEMP10);
                    txtNov.setText(TEMP11);
                    txtDec.setText(TEMP12);



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
