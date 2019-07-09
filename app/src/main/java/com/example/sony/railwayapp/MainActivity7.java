package com.example.sony.railwayapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//search code............................SEARCH CODE...................................
public class MainActivity7 extends AppCompatActivity implements View.OnClickListener {
    Button b2;
    TextView t2, t3, t4, t5, t6, t7,t8,t9,t10;
    EditText e11;
    ImageView i1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        b2 = findViewById(R.id.button5);
        b2.setOnClickListener(this);
        i1=findViewById(R.id.image1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t8);
        t8 = findViewById(R.id.t10);
        t9 = findViewById(R.id.t9);
        t10 = findViewById(R.id.t111);
        e11 = findViewById(R.id.e11);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button5:
                String nm = e11.getText().toString();
                DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
                SQLiteDatabase db = dh.getReadableDatabase();
                String q = "select * from student where nm like ?";
                Cursor c = db.rawQuery(q, new String[]{'%' + nm + "%"});
                if (c.moveToFirst()) {
                    String img = c.getString(0);
                    t2.setText(c.getString(1));
                    t3.setText(c.getString(2));
                    t4.setText(c.getString(3));
                    t5.setText(c.getString(4));
                    t6.setText(c.getString(5));
                    t7.setText(c.getString(7));
                    t8.setText(c.getString(8));
                    t9.setText(c.getString(9));
                    t10.setText(c.getString(10));
                    if (img.equals(0)) {
                        Toast.makeText(this, "unable to show", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "" + img, Toast.LENGTH_LONG).show();
                        Bitmap bitmap = BitmapFactory.decodeFile(c.getString(6));
                        i1.setImageBitmap(bitmap);
                    }
                } else {
                    Toast.makeText(this, "not found", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;


        }
    }
}
