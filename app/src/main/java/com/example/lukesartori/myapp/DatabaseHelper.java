package com.example.lukesartori.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luke on 17/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "customer.db";
    public static final String TABLE_NAME = "customer_table";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRSTNAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "USERNAME";
    public static final String COL_6 = "PASSWORD";
    public static final String COL_7 = "PHONE";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, SURNAME TEXT, EMAIL TEXT, USERNAME TEXT, PASSWORD, TEXT, PHONE TEXT)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }
}