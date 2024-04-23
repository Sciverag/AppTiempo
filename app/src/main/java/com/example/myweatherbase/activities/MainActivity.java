package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Ciudad;
import com.example.myweatherbase.activities.model.CiudadRepository;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.ImageDownloader;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerCiudades;
    private ImageView ivCiudad;
    private Button bttnPrevision;
    private CiudadRepository ciudadRepository;
    private Ciudad selectedCiudad;

    private Root root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCiudades = findViewById(R.id.spinnerCiudades);
        ivCiudad = findViewById(R.id.ivIconoCiudad);
        bttnPrevision = findViewById(R.id.bttnPrevison);

        ImageDownloader.downloadImage("https://cdn.pixabay.com/photo/2015/11/18/16/03/valencia-1049389_1280.jpg",ivCiudad);

        ciudadRepository = new CiudadRepository();
        selectedCiudad = ciudadRepository.get(0);
        ArrayAdapter<Ciudad> ciudadArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,ciudadRepository.getCiudades());
        spinnerCiudades.setAdapter(ciudadArrayAdapter);

        spinnerCiudades.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Ciudad ciudad = (Ciudad) adapterView.getItemAtPosition(i);
        selectedCiudad = ciudad;
        ImageDownloader.downloadImage(ciudad.getImageURL(),ivCiudad);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void lanzarPrevision(View view){
        Intent intent = new Intent(this, PrevisionActivity.class);
        intent.putExtra("lat",selectedCiudad.getLat());
        intent.putExtra("lon",selectedCiudad.getLon());
        intent.putExtra("nombreCiudad",selectedCiudad.getNombre());
        startActivity(intent);
    }




}