package com.example.sony.railwayapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    private ImageView iv;
    private TextView tv,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tv=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        iv=findViewById(R.id.i1);
        Animation myanima= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        tv.startAnimation(myanima);
        tv2.startAnimation(myanima);
        iv.startAnimation(myanima);
        final Intent i=new  Intent(this,Splash2.class);
        Thread timer=new Thread(){

            public void run(){
                try{
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}

