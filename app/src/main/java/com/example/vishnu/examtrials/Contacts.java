package com.example.vishnu.examtrials;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Contacts extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        tv = (TextView)findViewById(R.id.textView4);
        tv.setMovementMethod(new ScrollingMovementMethod());
        Cursor cur = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
//        for(int i=0;i<cur.getColumnCount();i++){
//            Toast.makeText(Contacts.this,"- "+i+" ********** "+cur.getColumnName(i),Toast.LENGTH_SHORT).show();
//        }
//        9,15,25
        String wqw= "";
        while(cur.moveToNext()){
            String id = cur.getString(15);
            String name = cur.getString(9);
            int hasnum = cur.getInt(25);
            String ph = "";
            if(hasnum>0){
                Cursor pcur = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"=?",new String[]{id},null);

                while(pcur.moveToNext()){
                    String phone = pcur.getString(pcur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    ph=ph+ "number "+phone ;
                }
            }
            wqw = wqw +"name : "+name+ ph+"\n \n";
        }
        tv.setText(wqw);
    }

}
