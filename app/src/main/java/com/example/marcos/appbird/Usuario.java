package com.example.marcos.appbird;

import android.graphics.Bitmap;

/**
 * Created by Marcos on 09-05-2016.
 */
public class Usuario {

    private String nombre;
    private String pais;
    private Bitmap img;
    private String mail;
    private String password;


    public Usuario(String nombre, String pais, Bitmap img, String mail, String password) {
        this.nombre = nombre;
        this.pais = pais;
        this.img = img;
        this.mail = mail;
        this.password = password;
    }

    public Usuario() {

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
