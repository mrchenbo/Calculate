package com.example.calculate;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initField();
    }

    private void initField(){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);

        String expRate = sharedPref.getString(getString(R.string.save_except_rate), "2.8");
        EditText expText = findViewById(R.id.expRate);
        expText.setText(expRate);

        String buyRate = sharedPref.getString(getString(R.string.save_buying_rate), "0");
        EditText buyText = findViewById(R.id.buyRate);
        buyText.setText(buyRate);

        String sellRate = sharedPref.getString(getString(R.string.save_sell_rate), "0.1");
        EditText sellText = findViewById(R.id.sellRate);
        sellText.setText(sellRate);

        String sellPrice = sharedPref.getString(getString(R.string.save_sell_price), "280");
        EditText sellPriceText = findViewById(R.id.sellPrice);
        sellPriceText.setText(sellPrice);

        String period = sharedPref.getString(getString(R.string.save_period), "0.5");
        EditText periodText = findViewById(R.id.period);
        periodText.setText(period);
    }

    public void progress(View view) {
        EditText expText = findViewById(R.id.expRate);
        float expRate = Float.parseFloat(expText.getText().toString()) / 100;

        EditText buyText = findViewById(R.id.buyRate);
        float buyRate = Float.parseFloat(buyText.getText().toString()) / 100;

        EditText sellText = findViewById(R.id.sellRate);
        float sellRate = Float.parseFloat(sellText.getText().toString()) / 100;

        EditText sellPriceText = findViewById(R.id.sellPrice);
        float sellPrice = Float.parseFloat(sellPriceText.getText().toString());

        EditText periodText = findViewById(R.id.period);
        float period = Float.parseFloat(periodText.getText().toString());

        float price = (sellPrice*(1-buyRate)*(1-sellRate)) / (expRate*period+1);

        EditText priceText = findViewById(R.id.price);
        priceText.setText(String.format(Locale.getDefault(),"%f", price));

        saveStatus(expText.getText().toString(),
                buyText.getText().toString(),
                sellText.getText().toString(),
                sellPriceText.getText().toString(),
                periodText.getText().toString());
    }

    private void saveStatus(String er, String br, String sr, String sp, String period){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.save_except_rate), er);
        editor.putString(getString(R.string.save_buying_rate), br);
        editor.putString(getString(R.string.save_sell_rate), sr);
        editor.putString(getString(R.string.save_sell_price), sp);
        editor.putString(getString(R.string.save_period), period);
        editor.apply();
    }
}
