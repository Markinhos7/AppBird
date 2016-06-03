package com.example.marcos.appbird.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcos.appbird.Ave;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/**
 * Created by Marcos on 05-05-2016.
 */
public class ImageAdapter extends ArrayAdapter<Ave> {

        Context context;
        int layoutResourceId;
        // BcardImage data[] = null;
        ArrayList<Ave> data=new ArrayList<Ave>();
        public ImageAdapter(Context context, int layoutResourceId, ArrayList<Ave> data) {
            super(context, layoutResourceId, data);
            this.layoutResourceId = layoutResourceId;
            this.context = context;
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ImageHolder holder = null;

            if(row == null)
            {
                LayoutInflater inflater = ((Activity)context).getLayoutInflater();
                row = inflater.inflate(layoutResourceId, parent, false);

                holder = new ImageHolder();
               // holder.txtTitle = (TextView)row.findViewById(R.id.grid_text);
               // holder.imgIcon = (ImageView)row.findViewById(R.id.grid_image);
                row.setTag(holder);
            }
            else
            {
                holder = (ImageHolder)row.getTag();
            }

            Ave picture = data.get(position);
            holder.txtTitle.setText(picture.getNom_ave());
            //convert byte to bitmap take from contact class

            byte[] outImage=picture.getImage();
            ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
            Bitmap theImage = BitmapFactory.decodeStream(imageStream);
            holder.imgIcon.setImageBitmap(theImage);
            return row;

        }

        static class ImageHolder
        {
            ImageView imgIcon;
            TextView txtTitle;
        }
    }


