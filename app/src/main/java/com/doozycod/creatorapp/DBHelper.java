package com.doozycod.creatorapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "EDITOR.db";
    private final static String TABLE_NAME = "editor_table";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(column_id integer primary key,form_name text,ids text,numbers text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String form_name, String ids, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("form_name", form_name);
        cv.put("ids", ids);
        cv.put("numbers", number);

//        db.insert(TABLE_NAME,)
    }
}
