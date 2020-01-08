package com.example.calculator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper  extends SQLiteOpenHelper{

    public static final int    DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "calculator_history";
    public static final String TABLE_NAME = "answers";

    public static final String KEY_ID   = "_id";
    public static final String KEY_NUMBER = "number";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID
                + " integer primary key," + KEY_NUMBER + " REAL" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);

        onCreate(db);

    }
}

