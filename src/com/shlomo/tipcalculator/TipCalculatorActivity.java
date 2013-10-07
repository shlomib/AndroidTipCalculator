package com.shlomo.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {

    private static final String TAG = "TipCalculatorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }

    public void calculateTip(View v) {
        EditText etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
        TextView tvTipValue = (TextView) findViewById(R.id.tvTipValue);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        DecimalFormat sf = new DecimalFormat("#");
        String totalStr = etTotalAmount.getText().toString();
        Double total = 0.0;
        Double tip = 0.0;
        String tipPercentStr;
        String tipValueStr;
        Double tipValue;
        
        if(!totalStr.equals("")) {
            total = Double.valueOf(totalStr);
        }
        
        switch (v.getId()) {
        case (R.id.btnTenPercentTip):
            tip = 0.1;
            break;
        case (R.id.btnFifteenPercentTip):
            tip = 0.15;
            break;
        case (R.id.btnTwentyPercentTip):
            tip = 0.20;
            break;
        }
        
        tipPercentStr = "Tip selected: " + String.valueOf(sf.format(tip*100)) + "%";
        tipValue = total * tip;
        tipValueStr = "$" + String.valueOf(df.format(tipValue));
        Log.v(TAG, tipPercentStr);
        
        Toast toast = Toast.makeText(getApplicationContext(), tipPercentStr, Toast.LENGTH_SHORT);
        toast.show();
        
        tvTipValue.setText(tipValueStr);
    }
}
