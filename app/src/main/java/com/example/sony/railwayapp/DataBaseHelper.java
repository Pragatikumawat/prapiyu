package com.example.sony.railwayapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String db_name="cms.db";
    public static final int db_version=1;
    public static final String tb_name="student";

    public DataBaseHelper(Context context){
        super(context,db_name,null,db_version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String q="create table  " +tb_name +"(nm text primary key ,adr text ,phn integer," +
                "dob date,eml text,gen text,image text,twelth integer,btech integer,tenth integer,branch text)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select* FROM "+tb_name,null);
        return res;
    }
}
