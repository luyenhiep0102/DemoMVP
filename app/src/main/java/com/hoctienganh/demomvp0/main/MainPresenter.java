package com.hoctienganh.demomvp0.main;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hoctienganh.demomvp0.data.DanhSach;
import com.hoctienganh.demomvp0.data.Database;

import java.util.ArrayList;

public class MainPresenter{
    AddView callback;

    ArrayList<DanhSach> arDanhSach;
    SQLiteDatabase database;
    String DATABASE_NAME = "DanhSach.sqlite";
    public MainPresenter(AddView callback){
        this.callback = callback;
    }

    public ArrayList<DanhSach> getDanhSachFormModel(Activity context){
        int id = 0;
        String ten = null;
        arDanhSach = new ArrayList<>();
        database = Database.initDatabase((Activity) context, DATABASE_NAME);
        Cursor cursor = database.rawQuery("select * from LoaiTin", null);
        cursor.moveToFirst();
        for(int i = 0; i< cursor.getCount(); i++){
            cursor.moveToPosition(i);
            id = cursor.getInt(0);
            ten = cursor.getString(1);
            arDanhSach.add(new DanhSach(id, ten));
        }
        return arDanhSach;
    }

    public void EventAddItem(){
        callback.AddToList();
    }



}
