package net.sgoliver.android.recyclerview;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

public class Titular
{
    private String nombre;
    private String apellido;
    private String curso;
    private int img;

    public Titular(String tit, String sub, String cur, int icono){
        nombre = tit;
        apellido = sub;
        curso = cur;
        img = icono;
    }

    public String getTitulo(){
        return nombre;
    }

    public String getSubtitulo(){
        return apellido;
    }

    public String getCurso() { return curso; }

    public int getImage() { return img; }
}
