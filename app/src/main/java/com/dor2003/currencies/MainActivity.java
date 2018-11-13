package com.dor2003.currencies;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Currency> currencies;
    private TextInputEditText enterValue;
    private TextView value;
    private Spinner spinnerCurrencies;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterValue = findViewById(R.id.edittext_enter_value);
        currencies = createCurrencies();
        value = findViewById(R.id.currency_value);
        spinnerCurrencies = findViewById(R.id.spinner_currencies);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double price = Double.parseDouble(Objects.requireNonNull(enterValue.getText()).toString());
                double course = 0;
                String currency = "";
                String selected = spinnerCurrencies.getSelectedItem().toString();

                switch (selected){
                    case "Dollar" : course = currencies.get(0).getValue();
                                    currency = "USD";
                        break;
                    case "Euro" : course = currencies.get(1).getValue();
                                    currency = "EUR";
                        break;
                    case "Pound" : course = currencies.get(2).getValue();
                                    currency = "GBP";
                        break;
                }

                double result = price/course;
                DecimalFormat df2 = new DecimalFormat(".##");
                String textResult = df2.format(result);
                textResult = textResult + " " + currency;
                value.setText(textResult);
            }
        });


    }

    public ArrayList <Currency> createCurrencies(){

        Currency dollar = new Currency(28.07, "Dollar");
        Currency euro = new Currency(31.7, "Euro");
        Currency pound = new Currency(35.6, "Pound");

        ArrayList<Currency> currencies = new ArrayList<Currency>();
        currencies.add(dollar);
        currencies.add(euro);
        currencies.add(pound);

        return currencies;
    }
}
