package com.example.sony.railwayapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity implements View.OnClickListener {

    Button b1,b2;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        b1 = findViewById(R.id.btn11);
        b2 = findViewById(R.id.btn12);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        t1 = findViewById(R.id.t5);
        t2 = findViewById(R.id.t1);
        t3 = findViewById(R.id.t2);
        t4 = findViewById(R.id.t3);
        t5 = findViewById(R.id.t4);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t8);
        t8 = findViewById(R.id.t7);
        t9 = findViewById(R.id.t9);
        t10 = findViewById(R.id.t10);
        e1=findViewById(R.id.e1);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn11:
                String nm=e1.getText().toString();
                DataBaseHelper dh=new DataBaseHelper(this);
                SQLiteDatabase db=dh.getReadableDatabase();
                String q="select * from student where nm=?";
                Cursor c=db.rawQuery(q,new String[]{nm});
                if(c.moveToFirst()){

                    t1.setText(c.getString(0));
                    t2.setText(c.getString(1));
                    t3.setText(c.getString(2));
                    t4.setText(c.getString(3));
                    t5.setText(c.getString(4));
                    t6.setText(c.getString(5));
                    t7.setText(c.getString(7));
                    t8.setText(c.getString(8));
                    t9.setText(c.getString(9));
                    t10.setText(c.getString(10));
                }
                else {
                    Toast.makeText(this, "not found", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn12:
                DataBaseHelper dh1=new DataBaseHelper(this);
                SQLiteDatabase db1=dh1.getWritableDatabase();
                int ans=db1.delete("student","nm=?",new String[]{e1.getText().toString()});
                if (ans==1){
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    t7.setText("");
                    t8.setText("");
                    t9.setText("");
                    t10.setText("");
                    Toast.makeText(this, "successfully deleted", Toast.LENGTH_LONG).show();

                }
                else {

                    Toast.makeText(this, "not deleted", Toast.LENGTH_LONG).show();

                }
                break;
            default:
                break;
        }
    }
}
