package com.example.sony.railwayapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button b1;
    Button b2;
    Spinner spin;
    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;
    ImageView i1;
    String notess;
    String note[] = {" ", "CSE/IT", "EC", "ME", "EE"};
    private String img = "";
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        b2 = findViewById(R.id.button12);
        b1 = findViewById(R.id.button7);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6 = findViewById(R.id.e6);
        e7 = findViewById(R.id.e7);
        e8 = findViewById(R.id.e8);
        e9 = findViewById(R.id.e9);
        e10 = findViewById(R.id.branch1);
        i1 = findViewById(R.id.i66);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, note);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        awesomeValidation.addValidation(this, R.id.e1,
                "^[A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u v w x y z \\s]" +
                        "{1,}[\\.]{0,1}[A B C D E F G H I J K L M N O P Q R S T U V W X Y Z a b c d e f g h i j k l m n o p q r s t u " +
                        "v w x y z \\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.e5, Patterns.EMAIL_ADDRESS, R.string.email_is_not_valid);
        //awesomeValidation.addValidation(this,R.id.editText7mobile,"^(?:(?:1[6789]|[23456789]))");
        awesomeValidation.addValidation(this, R.id.e3, "^[23456789]{2}[0123456789]{8}$", R.string.incorrect_mobileno);
        b1.setOnClickListener(this);
    }



    private void submitform() {
        if(awesomeValidation.validate()){
            Toast.makeText(this,"validation done",Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onClick(View v) {
        if (v==b1){
            submitform();
        }
        switch (v.getId()) {

            case R.id.button7:
                DataBaseHelper dh = new DataBaseHelper(getApplicationContext());
                SQLiteDatabase db = dh.getWritableDatabase();
                String nm = e1.getText().toString();
                String adr = e2.getText().toString();
                String phn = e3.getText().toString();
                String dob = e4.getText().toString();
                String eml = e5.getText().toString();
                String gen = e6.getText().toString();
                String tenth = e7.getText().toString();
                String twelth = e8.getText().toString();
                String btech = e9.getText().toString();
                String branch = e10.getText().toString();

                ContentValues cv = new ContentValues();
                cv.put("nm", nm);
                cv.put("adr", adr);
                cv.put("phn", phn);
                cv.put("dob", dob);
                cv.put("eml", eml);
                cv.put("gen", gen);
                cv.put("tenth", tenth);
                cv.put("twelth", twelth);
                cv.put("btech", btech);
                cv.put("branch", branch);
                cv.put("image", img);
                long f = db.insert("student", null, cv);
                if (f > 0) {
                    Toast.makeText(this, "sucessfully  saved", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "cannot be saved", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button12:
                Intent i1 = new Intent();
                i1.setType("image/*");
                i1.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(i1, 101);
                break;
            default:
                break;
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    protected void onActivityResult(int requestCode, int resultCode, Intent Data) {
        super.onActivityResult(requestCode, resultCode, Data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Uri uri = Data.getData();
            i1.setImageURI(uri);
            img = FileUtils.getPath(this, uri);
            Toast.makeText(this, img, Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "image not set", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        if (position > 0) {
            Spinner spinner = (Spinner) arg0;
            if (spinner.getId() == R.id.spinner) {
                notess = note[position];
                Toast.makeText(getApplicationContext(), notess, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), note[position], Toast.LENGTH_LONG).show();
            }
            if (notess.equals("CSE/IT")) {
                e10.setText("CSE/IT");
            } else if (notess.equals("EC")) {
                e10.setText("EC");
            } else if (notess.equals("ME")) {
                e10.setText("ME");
            } else
                e10.setText("EE");
        }
    }
        @Override
        public void onNothingSelected (AdapterView < ? > arg0){

        }
    }