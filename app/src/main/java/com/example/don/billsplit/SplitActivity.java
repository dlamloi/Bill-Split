package com.example.don.billsplit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class SplitActivity extends AppCompatActivity {

    private EditText numberOfPeopleEt;
    private EditText totalEt;
    private TextView owingTv;
    public static final String EVERYONE_OWES = "Everyone Owes: $";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);

        numberOfPeopleEt = findViewById(R.id.number_of_people_edittext);
        totalEt = findViewById(R.id.total_edittext);
        owingTv = findViewById(R.id.owing_textview);
        int numberOfPeople = 0;
        double total = 0;

        numberOfPeopleEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setOwingEt();

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (areRequiredEmpty()) setOwingEt(EVERYONE_OWES + "0");
            }
        });

        totalEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setOwingEt();

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (areRequiredEmpty()) setOwingEt(EVERYONE_OWES + "0");
            }
        });

    }

    private double getOwing() throws NumberFormatException {
        int numberOfPeople = areNumberOfPeopleEmpty() ? 0 : Integer.parseInt(numberOfPeopleEt.getText() + "");
        double total = areTotalEmpty() ? 0 : Double.parseDouble(totalEt.getText() + "");
        return total / numberOfPeople;
    }

    private boolean areNumberOfPeopleEmpty() {
        return TextUtils.isEmpty(numberOfPeopleEt.getText().toString());
    }

    private boolean areTotalEmpty() {
        return TextUtils.isEmpty(totalEt.getText().toString());
    }

    private boolean areRequiredEmpty() {
        return (areNumberOfPeopleEmpty() || areTotalEmpty());
    }

    private void setOwingEt() {
        if (!areRequiredEmpty()) {
            setOwingEt(EVERYONE_OWES + formatted(getOwing()));
        }


    }

    private String formatted(double value) {
        return new DecimalFormat("###,##0.00").format(value);
    }

    private void setOwingEt(String s) {
        owingTv.setText(s);
    }




}
