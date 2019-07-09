package com.example.sony.railwayapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityUpdate extends AppCompatActivity implements View.OnClickListener {
    EditText e1, e2, e3, e4, e5,e6,e7,e8,e9,e10;
    Button b1, b2;
ImageView i1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);
        b1 = findViewById(R.id.button6);
        b2 = findViewById(R.id.button9);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
       // i1 = findViewById(R.id.image2);
        e1 = findViewById(R.id.e71);
        e2 = findViewById(R.id.editText10);
        e3 = findViewById(R.id.editText11);
        e4 = findViewById(R.id.editText16);
        e5 = findViewById(R.id.editText20);
        e6 = findViewById(R.id.editText222);
        e7 = findViewById(R.id.editText);
        e8 = findViewById(R.id.editText5);
        e9 = findViewById(R.id.editText23);
        e10 = findViewById(R.id.editText231);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button6:
                String nm = e1.getText().toString();
                DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
                SQLiteDatabase db = dh.getReadableDatabase();
                String q = "select * from student where nm=?";
                Cursor c = db.rawQuery(q, new String[]{nm});
                if (c.moveToFirst()) {
                    e1.setText(c.getString(0));
                    e2.setText(c.getString(1));
                    e3.setText(c.getString(2));
                    e4.setText(c.getString(3));
                    e5.setText(c.getString(4));
                    e6.setText(c.getString(5));
                    e7.setText(c.getString(7));
                    e8.setText(c.getString(8));
                    e9.setText(c.getString(9));
                    e10.setText(c.getString(10));
                    Toast.makeText(this, "successfully  showed", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, " not found", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button9:
                DataBaseHelper dh0 = new DataBaseHelper(this);
                SQLiteDatabase db0 = dh0.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("nm",  e1.getText().toString());
                cv.put("adr", e2.getText().toString());
                cv.put("phn", e3.getText().toString());
                cv.put("dob", e4.getText().toString());
                cv.put("eml", e5.getText().toString());
                cv.put("gen", e6.getText().toString());
                cv.put("tenth", e7.getText().toString());
                cv.put("twelth", e8.getText().toString());
                cv.put("btech", e9.getText().toString());
                cv.put("branch", e10.getText().toString());
                int ans = db0.update("student", cv, "nm=? ", new String[]{e1.getText().toString()});
                if (ans == 0) {
                    Toast.makeText(this, "not updated", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(this, "successfully updated", Toast.LENGTH_LONG).show();

                }
                break;
            default:
                break;
        }
    }
}
