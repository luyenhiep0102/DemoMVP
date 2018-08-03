package com.hoctienganh.demomvp0.second;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.hoctienganh.demomvp0.data.Database;
import com.hoctienganh.demomvp0.main.MainActivity;

public class SecondPresenter {

    SQLiteDatabase database;
    String DATABASE_NAME = "DanhSach.sqlite";
    AddView callback;
    public SecondPresenter(AddView callback){
        this.callback = callback;
    }
    public void EventClickToAdd(String noidung, Context context){

        database = Database.initDatabase((Activity) context, DATABASE_NAME);
        ContentValues contentValues = new ContentValues();
        contentValues.put("ten", noidung);
        database.insert("LoaiTin", null, contentValues);
        callback.afterAddData();
    }
}
