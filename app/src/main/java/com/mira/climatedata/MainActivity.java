package com.mira.climatedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

    String year="2016";

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)menuItem.getActionView();
        searchView.setQueryHint("Enter a year");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                year=query;
                int yearInt=Integer.parseInt(year);
                int date=(-24*(yearInt-2011)+120);
                afficher();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    public void afficher()
    {
        String url="https://pkgstore.datahub.io/core/global-temp/monthly_json/data/4c7af7363a20648a68b8f2038a6765d6/monthly_json.json";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    int yearInt=Integer.parseInt(year);
                    // equation: https://www.desmos.com/calculator/3y901fs87p
                    int date=(-24*(yearInt-2011)+120);

                        // Objects
                        JSONObject dec = response.getJSONObject(0 + date);
                        JSONObject nov = response.getJSONObject(2 + date);
                        JSONObject oct = response.getJSONObject(4 + date);
                        JSONObject sep = response.getJSONObject(6 + date);
                        JSONObject aug = response.getJSONObject(8 + date);
                        JSONObject jul = response.getJSONObject(10 + date);
                        JSONObject jun = response.getJSONObject(12 + date);
                        JSONObject may = response.getJSONObject(14 + date);
                        JSONObject apr = response.getJSONObject(16 + date);
                        JSONObject mar = response.getJSONObject(18 + date);
                        JSONObject feb = response.getJSONObject(20 + date);
                        JSONObject jan = response.getJSONObject(22 + date);

                        Log.d("dec", "resultat =" + dec.getString("Date"));

                        //temp double --> string
                        double TEMPjan = jan.getDouble("Mean");
                        String TEMP01 = String.valueOf(TEMPjan);

                        double TEMPfeb = feb.getDouble("Mean");
                        String TEMP02 = String.valueOf(TEMPfeb);

                        double TEMPmar = mar.getDouble("Mean");
                        String TEMP03 = String.valueOf(TEMPmar);

                        double TEMPapr = apr.getDouble("Mean");
                        String TEMP04 = String.valueOf(TEMPapr);

                        double TEMPmay = may.getDouble("Mean");
                        String TEMP05 = String.valueOf(TEMPmay);

                        double TEMPjun = jun.getDouble("Mean");
                        String TEMP06 = String.valueOf(TEMPjun);

                        double TEMPjul = jul.getDouble("Mean");
                        String TEMP07 = String.valueOf(TEMPjul);

                        double TEMPaug = aug.getDouble("Mean");
                        String TEMP08 = String.valueOf(TEMPaug);

                        double TEMPsep = sep.getDouble("Mean");
                        String TEMP09 = String.valueOf(TEMPsep);

                        double TEMPoct = oct.getDouble("Mean");
                        String TEMP10 = String.valueOf(TEMPoct);

                        double TEMPnov = nov.getDouble("Mean");
                        String TEMP11 = String.valueOf(TEMPnov);

                        double TEMPdec = dec.getDouble("Mean");
                        String TEMP12 = String.valueOf(TEMPdec);

                        // setting textView values w/ data
                        txtYear.setText(year);
                        txtJan.setText(TEMP01+"°C");
                        txtFeb.setText(TEMP02+"°C");
                        txtMar.setText(TEMP03+"°C");
                        txtApr.setText(TEMP04+"°C");
                        txtMay.setText(TEMP05+"°C");
                        txtJun.setText(TEMP06+"°C");
                        txtJul.setText(TEMP07+"°C");
                        txtAug.setText(TEMP08+"°C");
                        txtSep.setText(TEMP09+"°C");
                        txtOct.setText(TEMP10+"°C");
                        txtNov.setText(TEMP11+"°C");
                        txtDec.setText(TEMP12+"°C");


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
