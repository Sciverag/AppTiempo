package com.example.myweatherbase.activities.model;

import androidx.annotation.NonNull;

import com.example.myweatherbase.R;
import com.example.myweatherbase.base.ImageDownloader;

public class Ciudad {
    private double lat;
    private double lon;
    private String nombre;
    private String imageURL;

    public Ciudad(String nombre, double lat, double lon){
        this.nombre = nombre;
        this.lat = lat;
        this.lon = lon;
        this.imageURL = "https://cdn.pixabay.com/photo/2015/11/18/16/03/valencia-1049389_1280.jpg";
    }

    public Ciudad(String nombre, double lat, double lon, String imageURL){
        this.nombre = nombre;
        this.lat = lat;
        this.lon = lon;
        this.imageURL = imageURL;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getNombre() {
        return nombre;
    }

    @NonNull
    @Override
    public String toString() {
        return getNombre();
    }
}
