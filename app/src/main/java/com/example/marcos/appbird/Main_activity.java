package com.example.marcos.appbird;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.marcos.appbird.DataBase.Conexion;
import java.util.ArrayList;

public class Main_activity extends AppCompatActivity {

    private  ArrayList<Ave> avelist;
    private  AveAdapter adapter;
    private GridView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mView = (GridView) findViewById(R.id.recycler_view);

        Conexion databaseHelper = new Conexion(this);

        avelist = new ArrayList<Ave>();
        avelist = databaseHelper.getAllAve();

        adapter = new AveAdapter(Main_activity.this,avelist);


        mView.setAdapter(adapter);

    }


}
