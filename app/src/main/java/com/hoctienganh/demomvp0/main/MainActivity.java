package com.hoctienganh.demomvp0.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.hoctienganh.demomvp0.Adapter.MainListAdapter;
import com.hoctienganh.demomvp0.R;
import com.hoctienganh.demomvp0.data.DanhSach;
import com.hoctienganh.demomvp0.second.SecondActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AddView{
    MainListAdapter adapter;
    ListView lvDanhSach;
    Button btnThem;
    MainPresenter mainPresenter;
    ArrayList<DanhSach> arDanhSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initView();
        mainPresenter = new MainPresenter(this);
        arDanhSach = new ArrayList<>();
        arDanhSach = mainPresenter.getDanhSachFormModel(MainActivity.this);
        adapter = new MainListAdapter(R.layout.lineline_main, arDanhSach, MainActivity.this);
        lvDanhSach.setAdapter(adapter);
        btnThem.setOnClickListener(this);

    }


    private void initView() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
        btnThem = findViewById(R.id.btnThem);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThem:
                mainPresenter.EventAddItem();
                break;
        }
    }

    @Override
    public void AddToList() {
        startActivity(new Intent(this, SecondActivity.class));
    }
}
