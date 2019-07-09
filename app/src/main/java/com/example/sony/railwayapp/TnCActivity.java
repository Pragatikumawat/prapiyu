package com.example.sony.railwayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TnCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tn_c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.draweritem2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent i = new Intent(this, splash3.class);
                startActivity(i);
                break;
            case R.id.Aboutus:
                Intent i1 = new Intent(this, AboutusActivity.class);
                startActivity(i1);
                break;
            case R.id.logout:
                Intent i2 = new Intent(this, Splash2.class);
                startActivity(i2);

                break;

        }
        return super.onOptionsItemSelected(item);


    }
}