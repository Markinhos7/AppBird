package com.example.marcos.appbird;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
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

        //TextView codeTextView = (TextView) convertView.findViewById(R.id.tv_emp_id);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.text);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageView);

        Ave e = new Ave();
        e = empList.get(position);
        //codeTextView.setText("Code: " + String.valueOf(e.getId()));

        nameTextView.setText("Name: " + e.getNom_ave());

        ImageView image = (ImageView) convertView.findViewById(R.id.imageView);
        //image.setImageResource(R.drawable.ave);

       // byte[] outImage=e.getImage();
       // ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
        //Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        //image.setImageBitmap(theImage);
        image.setImageBitmap(e.getImg());
        //img.setImageBitmap(e.getImg());
  //      emailTextView.setText("Email: " + e.getNom_cientifico());
    //    addressTextView.setText("Address: " + e.getNom_ingles());
        return convertView;
    }

    }




