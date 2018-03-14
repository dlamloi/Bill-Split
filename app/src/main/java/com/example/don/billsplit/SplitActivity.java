package com.example.don.billsplit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplitActivity extends AppCompatActivity {

    RelativeLayout screenLayout = findViewById(R.id.screen_layout);
    EditText numberOfPeopleEt = findViewById(R.id.number_of_people_edittext);
    EditText totalEt = findViewById(R.id.total_edittext);
    TextView owingTv = findViewById(R.id.owing_textview);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split);



    }


}
