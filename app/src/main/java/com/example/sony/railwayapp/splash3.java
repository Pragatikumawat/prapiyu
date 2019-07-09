package com.example.sony.railwayapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;

public class splash3 extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4, b5;
    DataBaseHelper mydb;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigation;
    RelativeLayout relativeLayout;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);
        relativeLayout = findViewById(R.id.ll);
        b1 = findViewById(R.id.button);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.button5);
        mydb = new DataBaseHelper(this);
        viewall();
        t1 = findViewById(R.id.textView7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = findViewById(R.id.drawer);
        navigation = findViewById(R.id.navigation);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.close, R.string.open);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //HOME
                if (item.getItemId() == R.id.i1) {
                    Intent i = new Intent(splash3.this, splash3.class);
                    startActivity(i);
                }
                //RATE US
                if (item.getItemId() == R.id.i2) {
                    Intent i1 = new Intent(splash3.this, RateUs.class);
                    startActivity(i1);
                }
                //SHARE IT
                if (item.getItemId() == R.id.i3) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    String shareBody = "please share this app to your friends";
                    String shareSub = "get rs50 after sharing  this app";
                    i.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                    i.putExtra(Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(i, "share using"));
                }
                //EXIT PAGE
                if (item.getItemId() == R.id.i4) {
                    // Intent i2 = new Intent(splash3.this, Splash2.class);
                    // startActivity(i2);
                    finish();
                }
                //TERMS AND CONDITIONS
                if (item.getItemId() == R.id.i5) {
                    Intent i3 = new Intent(splash3.this, TnCActivity.class);
                    startActivity(i3);
                }
                return true;
            }
        });
    }

    private void viewall() {
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splash3.this, ViewAllEnternsActivity.class));
            }
        });
    }


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //insert
            case R.id.button:
                Intent i = new Intent(this, MainActivity5.class);
                startActivity(i);
                Snackbar.make(view, "processing", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            //search
            case R.id.button2:
                Intent i1 = new Intent(this, MainActivity7.class);
                startActivity(i1);
                Snackbar.make(view, "processing", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            //delete
            case R.id.button3:
                Intent i2 = new Intent(this, MainActivity8.class);
                startActivity(i2);
                Snackbar.make(view, "processing", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            //update
            case R.id.button4:
                Intent i3 = new Intent(this, MainActivityUpdate.class);
                startActivity(i3);
                Snackbar.make(view, "processing", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.forgotPassword:
                Intent i4 = new Intent(this, MainActivity8.class);
                startActivity(i4);
            default:
                break;
        }
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.draweritem2, menu);
        return true;

    }

    //overflow menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
        }
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
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



