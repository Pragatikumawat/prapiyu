package com.example.sony.railwayapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forgetpass extends AppCompatActivity implements View.OnClickListener {
EditText e1,e2;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpass);
        e1=findViewById(R.id.editText3);
        e2=findViewById(R.id.editText4);
        b1=findViewById(R.id.button14);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    if  (e1.getText().length() != 0 && e2.getText().length() != 0) {
        switch (view.getId()) {
            case R.id.button14:
                Intent i = new Intent(this, splash3.class);
                startActivity(i);
                break;

        }
    }else {
        Toast.makeText(this, "error!!", Toast.LENGTH_LONG).show();

    }
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
            e1.setError("Please enter a new password");
            return false;
        }
        return true;
    }

    private boolean checkPassword(String uPassword) {
        if (TextUtils.isEmpty(uPassword)) {
            e2.setError("Please enter a confirm pssword");
            return false;
        } else if (uPassword.length() < 6 || uPassword.length() > 10) {
            e2.setError("Password should be  between 6 to 10 Characters");
            return false;
        }
        return true;
    }


}
