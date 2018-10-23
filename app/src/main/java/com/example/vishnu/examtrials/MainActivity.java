package com.example.vishnu.examtrials;

import android.content.Intent;
import android.net.Uri;
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

    public void expliciIntent(View view){
        Intent i = new Intent(MainActivity.this,ExplicitIntent.class);
        i.putExtra("data",1232);
        i.putExtra("data2","value");
        startActivity(i);
    }
    public void implicitIntent(View view){

        Intent i = new Intent(MainActivity.this,ImplicitIntent.class);
        startActivity(i);
    }

    public void internalData(View view){
        Intent i = new Intent(MainActivity.this,InternalDb.class);
        startActivity(i);
    }

    public void allMenus(View view){
        Intent i =new Intent(MainActivity.this,AllMenus.class);
        startActivity(i);
    }

    public void contactsClick(View view){
        Intent i =new Intent(MainActivity.this,Contacts.class);
        startActivity(i);
    }

    public void smsClick(View view){
        Intent i =new Intent(MainActivity.this,SetSms.class);
        startActivity(i);
    }
}

