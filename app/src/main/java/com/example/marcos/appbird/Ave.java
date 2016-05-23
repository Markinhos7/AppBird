package com.example.marcos.appbird;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Marcos on 01-05-2016.
 */
public class Ave {
    private int id;
    private String nom_ave;
    private String nom_ingles;
    private String nom_cientifico;
    private String des_Ave;
    private Bitmap img;
    byte[] image;

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    private int size;
    private int idDrawable;


    public Ave() {

    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Ave(int id, String nom_ave, String nom_ingles, String nom_cientifico, String des_Ave, int size) {
        this.id = id;
        this.nom_ave = nom_ave;
        this.nom_ingles = nom_ingles;
        this.nom_cientifico = nom_cientifico;
        this.des_Ave = des_Ave;
        this.size = size;
    }

    public Bitmap getImg() {

        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes_Ave() {
        return des_Ave;
    }

    public void setDes_Ave(String des_Ave) {
        this.des_Ave = des_Ave;
    }

    public String getNom_ave() {
        return nom_ave;
    }

    public void setNom_ave(String nom_ave) {
        this.nom_ave = nom_ave;
    }

    public String getNom_ingles() {
        return nom_ingles;
    }

    public void setNom_ingles(String nom_ingles) {
        this.nom_ingles = nom_ingles;
    }

    public String getNom_cientifico() {
        return nom_cientifico;
    }

    public void setNom_cientifico(String nom_cientifico) {
        this.nom_cientifico = nom_cientifico;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
