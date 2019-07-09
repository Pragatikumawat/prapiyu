package com.example.sony.railwayapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAllEnternsActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private DataBaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_enterns);
        tableLayout = findViewById(R.id.table);
        mydb = new DataBaseHelper(this);


        //Get the data from DB
        Cursor res = mydb.getAllData();
        if (res.getCount() == 0) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
            return;
        }
        while (res.moveToNext()) {
            View view = getItemView(res);
            tableLayout.addView(view,tableLayout.getChildCount());
        }
    }

    private View getItemView(Cursor cursor) {
        TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.entry_single_item_view, null);
        TextView name = tableRow.findViewById(R.id.name);
        name.setText(cursor.getString(0));
        TextView address = tableRow.findViewById(R.id.address);
        address.setText(cursor.getString(1));
        TextView dob = tableRow.findViewById(R.id.dob);
        dob.setText(cursor.getString(3));
        TextView phone = tableRow.findViewById(R.id.phone);
        phone.setText(cursor.getString(2));
        TextView email = tableRow.findViewById(R.id.email);
        email.setText(cursor.getString(4));
        TextView gender = tableRow.findViewById(R.id.gender);
        gender.setText(cursor.getString(5));
        TextView tenth = tableRow.findViewById(R.id.tenth);
        tenth.setText(cursor.getString(7));
        TextView twelth = tableRow.findViewById(R.id.twelth);
        twelth.setText(cursor.getString(8));
        TextView btech = tableRow.findViewById(R.id.btech);
        btech.setText(cursor.getString(9));
        TextView branch = tableRow.findViewById(R.id.branch1);
        branch.setText(cursor.getString(10));
        return tableRow;
    }
}
