package com.example.myweatherbase.activities.model;

import com.example.myweatherbase.R;

import java.util.ArrayList;
import java.util.List;

public class CiudadRepository {
    private List<Ciudad> ciudades;

    public CiudadRepository() {
        this.ciudades = new ArrayList<>();
        ciudadesPorDefecto();
    }

    private void ciudadesPorDefecto(){
        ciudades.add(new Ciudad("Valencia",39.46975,-0.37739,"https://cdn.pixabay.com/photo/2015/11/18/16/03/valencia-1049389_1280.jpg"));
        ciudades.add(new Ciudad("Madrid",40.4165,-3.70256,"https://imagenes.20minutos.es/files/image_1920_1080/uploads/imagenes/2023/01/24/istock-1297090032.jpeg"));
        ciudades.add(new Ciudad("Bilbao",43.26271,-2.92528,"https://a.cdn-hotels.com/gdcs/production145/d1594/c628f660-5863-11e8-9946-0242ac110009.jpg?impolicy=fcrop&w=800&h=533&q=medium"));
        ciudades.add(new Ciudad("Sevilla",37.38283,-5.97317,"https://cdn.pixabay.com/photo/2020/05/12/18/29/city-5164368_1280.jpg"));
    }

    public Ciudad get(int posicion){
        return ciudades.get(posicion);
    }

    public List<Ciudad> getCiudades(){
        return ciudades;
    }

    public int size(){
        return ciudades.size();
    }

    public void add(Ciudad ciudad){
        ciudades.add(ciudad);
    }
}
