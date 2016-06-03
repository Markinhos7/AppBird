package com.example.marcos.appbird.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcos.appbird.Ave;
import com.example.marcos.appbird.R;

import java.util.ArrayList;

/**
 * Created by Marcos on 02-05-2016.
 */

public class AveAdapter extends BaseAdapter {
    Context context;
    ArrayList<Ave> empList;
    private static LayoutInflater inflater = null;

      public AveAdapter(Context context, ArrayList<Ave> empList) {
          this.context = context;
          this.empList = empList;
          inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      }

    @Override
    public int getCount() {
        return empList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

   @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if (convertView == null)
            convertView = inflater.inflate(R.layout.layout_grid_item, null);


        TextView nameTextView = (TextView) convertView.findViewById(R.id.text);


        Ave e = new Ave();
        e = empList.get(position);

        nameTextView.setText(e.getNom_ave());
        Log.d("asd",e.getNom_ave());
        ImageView image = (ImageView) convertView.findViewById(R.id.image);
        image.setImageBitmap(e.getImg());
        return convertView;
    }

    }




