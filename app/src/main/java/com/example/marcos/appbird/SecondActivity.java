package com.example.marcos.appbird;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcos.appbird.DataBase.Conexion;

import java.util.ArrayList;

/**
 * Created by Marcos on 05-05-2016.
 */
public class SecondActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        String a = Integer.toString(position);
        Log.d("asd ", a);

        //TextView nombre = (TextView) findViewById(R.id.title);
        TextView content = (TextView) findViewById(R.id.textView);
        ImageView image = (ImageView) findViewById(R.id.imageView);

        Ave ave = new Ave();
        Conexion c = new Conexion(this);
        ave = c.getAve(position+1);

        //nombre.setText(ave.getNom_ave());
        content.setText(ave.getDes_Ave());
        image.setImageBitmap(ave.getImg());

    }
}