package com.hoctienganh.demomvp0.second;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hoctienganh.demomvp0.R;
import com.hoctienganh.demomvp0.data.Database;
import com.hoctienganh.demomvp0.main.MainActivity;
import com.hoctienganh.demomvp0.main.MainPresenter;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener, AddView{
    EditText edtNoiDung;
    Button btnThem;
    SecondPresenter secondPresenter;
    SQLiteDatabase database;
    String DATABASE_NAME = "DanhSach.sqlite";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        secondPresenter = new SecondPresenter(this);
        initView();
        btnThem.setOnClickListener(this);

    }

    private void initView() {
        edtNoiDung = findViewById(R.id.edtNoiDung);
        btnThem = findViewById(R.id.btnThem);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:
                //themdulieu
                String noidung = edtNoiDung.getText().toString();
                secondPresenter.EventClickToAdd(noidung, SecondActivity.this);

                break;
        }

    }


    @Override
    public void afterAddData() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
