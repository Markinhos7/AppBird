package com.example.marcos.appbird.DataBase;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;

import com.example.marcos.appbird.Ave;
import com.example.marcos.appbird.Usuario;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.ByteArrayInputStream;
import java.net.UnknownServiceException;
import java.util.ArrayList;

/**
 * Created by Marcos on 19-04-2016.
 */
public class Conexion extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "AppAve.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Ave";
    private static final String TABLE_USER = "Usuario";

    public Conexion(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // you can use an alternate constructor to specify a database location
        // (such as a folder on the sd card)
        // you must ensure that this folder is available and you have permission
        // to write to it
        //super(context, DATABASE_NAME, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION);
    }

    public ArrayList<Ave> getAllAve() {

        ArrayList<Ave> aves = new ArrayList<>();
        byte[] byteImage2 = null;


        SQLiteDatabase db = getReadableDatabase();
        // SQLiteDatabase db = getWritableDatabase();

        String[] columns = {"id", "nom_ave", "nom_cientifico", "nom_ingles", "des_ave", "size", "img"};

        Cursor cursor = db.query("Ave", columns, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                //create a new Games object and retrieve the data from the cursor to be stored in this Games object
                Ave ave = new Ave();
                //each step is a 2 part process, find the index of the column first, find the data of that column using
                //that index and finally set our blank Games object to contain our data
                ave.setId(cursor.getInt(cursor.getColumnIndex("id")));
                ave.setNom_ave(cursor.getString(cursor.getColumnIndex("nom_ave")));
                ave.setNom_cientifico(cursor.getString(cursor.getColumnIndex("nom_cientifico")));
                ave.setSize(cursor.getInt(cursor.getColumnIndex("size")));
                ave.setNom_ingles(cursor.getString(cursor.getColumnIndex("nom_ingles")));
                ave.setDes_Ave(cursor.getString(cursor.getColumnIndex("des_ave")));
                byte[] blob = cursor.getBlob(cursor.getColumnIndex("img"));
                ByteArrayInputStream imageStream = new ByteArrayInputStream(blob);
                Bitmap theImage = BitmapFactory.decodeStream(imageStream);
                ave.setImg(theImage);
                aves.add(ave);

            } while (cursor.moveToNext());
        }
        return aves;
    }

    public ArrayList<Ave> getAllContacts() {

        ArrayList<Ave> contactList = new ArrayList<Ave>();
        // Select All Query
        String selectQuery = "SELECT  * FROM Ave";
        //ByteArrayInputStream bis = new ByteArrayInputStream();
        SQLiteDatabase db = getReadableDatabase();
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Ave contact = new Ave();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNom_ave(cursor.getString(1));
                contact.setNom_cientifico(cursor.getString(2));
                contact.setImage(cursor.getBlob(7));
                //Bitmap bmp = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                // contact.setImg(bmp);
                // Adding contact to lists
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        db.close();
        // return contact list
        return contactList;
    }

    public Ave getAve(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{"id",
                        "nom_ave", "nom_ingles", "des_ave", "img"}, "id" + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor.getCount() >= 0)
            cursor.moveToFirst();

        Ave contact = new Ave();
        contact.setId(Integer.parseInt(cursor.getString(0)));
        contact.setNom_ave(cursor.getString(1));
        contact.setNom_cientifico(cursor.getString(2));
        contact.setDes_Ave(cursor.getString(3));
        byte[] blob = cursor.getBlob(cursor.getColumnIndex("img"));
        ByteArrayInputStream imageStream = new ByteArrayInputStream(blob);
        Bitmap theImage = BitmapFactory.decodeStream(imageStream);
        contact.setImg(theImage);

        return contact;
    }

    public String LoginUser(String mail, String passwords) {

        SQLiteDatabase db = this.getReadableDatabase();

        String password = "";
        String[] columns = {"nom_usuario,password", "mail"};
        String[] args = {mail};
        Log.d("args", mail);
        Cursor cursor = db.query(TABLE_USER, columns, "mail =?", args, null, null, null);
        Usuario c = new Usuario();

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();
            //Retrieving User FullName and Email after successfull login and passing to LoginSucessActivity
            cursor.moveToFirst();
            password = cursor.getString(cursor.getColumnIndex("password"));
            Log.d("ppp",   "-" + passwords);
        }
            return password;
        }
    }


