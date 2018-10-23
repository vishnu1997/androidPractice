package com.example.vishnu.examtrials;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SetSms extends AppCompatActivity {
    TextView we;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_sms);
        we = (TextView)findViewById(R.id.smsid);
        Uri uroa = Uri.parse("content://sms/inbox");
        Cursor c = getContentResolver().query(uroa,null,null,null,null);
        String sm ="";
        while(c.moveToNext()){
            sm = sm + c.getString(2)+"  ==  "+c.getString(12)+"\n";
        }
        we.setMovementMethod(new ScrollingMovementMethod());
        we.setText(sm);

    }

}
