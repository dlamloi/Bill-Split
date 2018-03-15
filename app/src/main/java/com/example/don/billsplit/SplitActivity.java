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

public class SplitActivity extends AppCompatActivity {

    private EditText numberOfPeopleEt;
    private EditText totalEt;
    private TextView owingTv;
    public static final String EVERYONE_OWES = "Everyone Owes: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);

        numberOfPeopleEt = findViewById(R.id.number_of_people_edittext);
        totalEt = findViewById(R.id.total_edittext);
        owingTv = findViewById(R.id.owing_textview);

        numberOfPeopleEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!areRequiredEmpty()) {
                    setOwingEt();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        totalEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!areRequiredEmpty()) {
                    setOwingEt();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private double getOwing() throws NumberFormatException {
        int numberOfPeople = Integer.parseInt(numberOfPeopleEt.getText() + "");
        double total = Double.parseDouble(totalEt.getText() + "");
        return total / numberOfPeople;
    }

    private boolean areRequiredEmpty() {
        return (TextUtils.isEmpty(totalEt.getText().toString()) ||
                TextUtils.isEmpty(numberOfPeopleEt.getText().toString()));
    }

    private void setOwingEt() {
        owingTv.setText(EVERYONE_OWES + getOwing());
    }




}
