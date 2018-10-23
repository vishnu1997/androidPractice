package com.example.vishnu.examtrials;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InternalDb extends AppCompatActivity {
    SQLiteDatabase db;
    EditText eid,eloc;
    ListView lv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_db);
        eid = (EditText)findViewById(R.id.editText2);
        eloc = (EditText)findViewById(R.id.editText3);
        tv = (TextView)findViewById(R.id.textView6);
        //lv = (ListView)findViewById(R.id.listview);

        db = openOrCreateDatabase("employ",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS employe(id VARCHAR,loc VARCHAR);");
    }

    public void add1(View view){
        if(eid.getText().toString().length()==0||eloc.getText().toString().length()==0){
            showError("please enter details");
        }else{
            db.execSQL("INSERT INTO employe VALUES(\""+eid.getText().toString()+"\",\""+eloc.getText().toString()+"\");");
            showError("successfully added");
        }

    }

    public void del(View view){
        if(eid.getText().toString().length()==0){
            showError("write id");
        }else{
            db.execSQL("DELETE FROM employe where id =\""+eid.getText().toString()+"\";");
            showError("deleted");
        }
    }

    public void mod(View view){
        if(eid.getText().toString().length()==0||eloc.getText().toString().length()==0){
            showError("please ent det for mod");
        }else{
            Cursor c = db.rawQuery("SELECT id FROM employe WHERE id=\""+eid.getText().toString()+"\";",null);
            if(c.getCount()==0){
                showError("Not present to mod");
            }else{
                db.execSQL("UPDATE employe SET loc = \""+eloc.getText().toString()+"\" WHERE id=\""+eid.getText().toString()+"\";");
                showError("updated");
            }
        }
    }

    public void viewD(View view){
        if(eid.getText().toString().length()!=0){
            Cursor c = db.rawQuery("SELECT id,loc FROM employe WHERE id=\""+eid.getText().toString()+"\";",null);
            if(c.getCount()==0){
                showError("Not present");
            }else{
                if(c.moveToFirst()){
                    showError("mes id"+c.getString(0)+" loc: "+c.getString(1));
                }
                showError("IN");
            }
        }else{
            showError("write id for viewing");
        }
    }

    public void viewAll(View view){
        Cursor c = db.rawQuery("SELECT * FROM employe;",null);
        if(c.getCount()==0){
            showError("Nothing present to show");
        }else{

            ArrayList<String> al = new ArrayList<String>();
            while(c.moveToNext()){
                String n = "id:"+c.getString(0)+" loc: "+c.getString(1);
                al.add(n);
            }
            String out[] = new String[al.size()];
            for(int i =0;i<al.size();i++){
                out[i]=al.get(i);
            }
            String oo = "";
            for(int i =0;i<al.size();i++){
                oo=oo+out[i]+"\n";
            }
            tv.setText(oo);
//            ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,out);
//            lv.setAdapter(ad);

        }
    }

    public void showError(String mes){
        Toast.makeText(InternalDb.this,mes,Toast.LENGTH_SHORT).show();
    }

}
