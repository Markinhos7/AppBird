package com.example.marcos.appbird.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.marcos.appbird.Ave;
import com.example.marcos.appbird.DataBase.Conexion;
import com.example.marcos.appbird.R;

import java.util.ArrayList;

/**
 * Created by Marcos on 05-05-2016.
 */
public class SecondActivity extends AppCompatActivity {

    private  ArrayList<Ave> avelist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();



        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapser);


        // Selected image id
        int position = i.getExtras().getInt("id");
        String a = Integer.toString(position);
        Log.d("asd ", a+1);

        TextView nombre = (TextView) findViewById(R.id.textView2);
        TextView content = (TextView) findViewById(R.id.textView);
        ImageView image = (ImageView) findViewById(R.id.imageView);


        Ave ave = new Ave();
        Conexion c = new Conexion(this);
        ave = c.getAve(position+1);

        nombre.setText(ave.getNom_ave());
        content.setText(ave.getDes_Ave());
        image.setImageBitmap(ave.getImg());

    }

}