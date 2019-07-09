package com.example.sony.railwayapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Splash2 extends AppCompatActivity  implements View.OnClickListener{
Button b1;
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
       b1=findViewById(R.id.button11);
        b1.setOnClickListener(this);
        t1=findViewById(R.id.textView5);
        t1.setOnClickListener(this);

    }
// alert dialog box.
    @Override
    public void onClick(View view) {

       switch(view.getId()) {
           case R.id.button11:
               Intent i31 = new Intent(this, LoginActivity.class);
               startActivity(i31);
               break;
           case R.id.textView5:
               Intent i310 = new Intent(this, splash3.class);
               startActivity(i310);
               break;

           default:
               break;
       }
    }
    // alert box to leave app.
    @Override
    public void onBackPressed() {
        showAlertDialog();
    }

    private void showAlertDialog() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("EXIT");
        builder.setMessage("Are you sure you want to leave");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int i) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface d, int i) {
                d.dismiss();
            }
        });
        builder.create().show();
    }
}
