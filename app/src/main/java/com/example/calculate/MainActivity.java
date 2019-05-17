package com.example.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void progress(View view) {
        EditText expText = (EditText) findViewById(R.id.expRate);
        float expRate = Float.parseFloat(expText.getText().toString()) / 100;

        EditText buyText = (EditText) findViewById(R.id.buyRate);
        float buyRate = Float.parseFloat(buyText.getText().toString()) / 100;

        EditText sellText = (EditText) findViewById(R.id.sellRate);
        float sellRate = Float.parseFloat(sellText.getText().toString()) / 100;

        EditText sellPriceText = (EditText) findViewById(R.id.sellPrice);
        float sellPrice = Float.parseFloat(sellPriceText.getText().toString());

        EditText periodText = (EditText) findViewById(R.id.period);
        float period = Float.parseFloat(periodText.getText().toString());

        float price = ((1-buyRate)*sellPrice) / (expRate*period+1);

        EditText priceText = (EditText) findViewById(R.id.price);
        priceText.setText(Float.toString(price));
    }
}
