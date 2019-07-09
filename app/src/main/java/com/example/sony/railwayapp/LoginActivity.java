package com.example.sony.railwayapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button b1;
    TextInputEditText e1, e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1 = findViewById(R.id.username);
        e2 = findViewById(R.id.password);
        b1 = findViewById(R.id.button8);
        t1 = findViewById(R.id.forgotPassword);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();


            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmit();
            }
        });
    }

    private void onSubmit() {
        Intent i = new Intent(this, forgetpass.class);
        startActivity(i);
    }

    private void register() {
        String username = e1.getText().toString().trim();
        String upassword = e2.getText().toString().trim();

        if (checkUsername(username) && checkPassword(upassword)) {
            Intent i = new Intent(this, splash3.class);
            startActivity(i);
            Toast.makeText(this, "you are registered!!", Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkUsername(String userName) {
        if (TextUtils.isEmpty(userName)) {
            e1.setError("Please enter a username");
            return false;
        }
        return true;
    }

    private boolean checkPassword(String uPassword) {
        if (TextUtils.isEmpty(uPassword)) {
            e2.setError("Please enter a pssword");
            return false;
        } else if (uPassword.length() < 6 || uPassword.length() > 10) {
            e2.setError("Password should be  between 6 to 10 Characters");
            return false;
        }
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.profile:
                Intent i= new Intent(this, splash3.class);
                startActivity(i);
                break;
            case  R.id.Aboutus :
                Intent i1= new Intent(this, AboutusActivity.class);
                startActivity(i1);
                break;
            case  R.id.logout:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}