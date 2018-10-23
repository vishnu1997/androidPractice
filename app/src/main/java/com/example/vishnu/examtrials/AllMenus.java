package com.example.vishnu.examtrials;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AllMenus extends AppCompatActivity {
    TextView tv,tv2;
    ImageView iv;
    float i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_menus);
        tv = (TextView)findViewById(R.id.textView2);
        tv2 = (TextView)findViewById(R.id.textView3);
        iv = (ImageView)findViewById(R.id.imageView);
        registerForContextMenu(tv);
        registerForContextMenu(tv2);
        i = (float) 1.2;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Call");
        menu.add("sms");
        menu.setHeaderTitle("ContextMenu");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("ChangePic");
        menu.add("Change text");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="Call"){
            Toast.makeText(AllMenus.this,"First Context",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(AllMenus.this,"Second "+item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(AllMenus.this,"Fi "+item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        if(item.getTitle()=="Change text"){
            tv2.setTextSize(30);
            //iv.setMaxHeight(i);
            //iv.setMaxWidth(i);
            iv.setScaleX(i);
            iv.setScaleY(i);

            //iv.setImageResource(R.drawable.quote);
            i = i+(float)0.4;
        }else{
            if(item.getTitle().equals("ChangePic")){
                tv.setTextSize(30);

                iv.setImageResource(R.drawable.quote);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
