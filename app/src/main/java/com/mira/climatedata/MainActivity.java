package com.mira.climatedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // url: https://pkgstore.datahub.io/core/global-temp/monthly_json/data/4c7af7363a20648a68b8f2038a6765d6/monthly_json.json

    TextView txtTitle, txtJanLabel, txtFebLabel, txtMarLabel, txtAprLabel, txtMayLabel, txtJunLabel, txtJulLabel, txtAugLabel, txtSepLabel, txtOctLabel, txtNovLabel, txtDecLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle=findViewById(R.id.txtTitle);
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
    }
}