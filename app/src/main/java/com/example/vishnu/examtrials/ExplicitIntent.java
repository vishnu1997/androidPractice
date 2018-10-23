package com.example.vishnu.examtrials;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ExplicitIntent extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
        Bundle extra = getIntent().getExtras();
        int d1 = extra.getInt("data");
        String d2 = extra.getString("data2");

        tv = (TextView)findViewById(R.id.textView);
        tv.setText("+"+d1+"-"+d2+" = ");

    }
    public void increaseSize(View view) {
        tv.setTextSize(30);
        tv.setTextColor(Color.parseColor("#00FF00"));
    }
}
