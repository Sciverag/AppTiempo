package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Ciudad;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.ImageDownloader;

public class AnyadirCiudad extends BaseActivity implements View.OnClickListener {
    private String ciudades;
    private String nombre;
    private double lat;
    private double lon;
    private String imagenURL;
    private EditText etNombreCiudad;
    private EditText etLatCiudad;
    private EditText etLonCiudad;
    private EditText etURLImagen;
    private ImageView ivImagenCiudad;
    private Button bttnAnyadir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anyadir_ciudad_activity);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        ciudades = extras.getString("Ciudades");

        etNombreCiudad = findViewById(R.id.etNombreCiudad);
        etLatCiudad = findViewById(R.id.etLatitud);
        etLonCiudad = findViewById(R.id.etLongitud);
        etURLImagen = findViewById(R.id.etImagenURL);
        bttnAnyadir = findViewById(R.id.bttnAnyadir);
        ivImagenCiudad = findViewById(R.id.ivImagenPreveer);

        bttnAnyadir.setOnClickListener(this);
        ivImagenCiudad.setOnClickListener(v -> {
            if(!etURLImagen.getText().toString().isEmpty()){
                ImageDownloader.downloadImage(etURLImagen.getText().toString(),ivImagenCiudad);
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(etNombreCiudad.getText().toString().isEmpty()){
            Toast.makeText(this,"No has puesto el Nombre de la Ciudad", Toast.LENGTH_LONG).show();
        } else if(etLatCiudad.getText().toString().isEmpty()){
            Toast.makeText(this,"No has puesto la Latitud de la Ciudad", Toast.LENGTH_LONG).show();
        } else if(etLonCiudad.getText().toString().isEmpty()){
            Toast.makeText(this,"No has puesto la Longitud de la Ciudad", Toast.LENGTH_LONG).show();
        }else if(ciudades.contains(etNombreCiudad.getText().toString())){
            Toast.makeText(this,"Ya tienes una Ubicación con ese nombre!", Toast.LENGTH_LONG).show();
        }else{

            if(etURLImagen.getText().toString().isEmpty()){
                imagenURL = "Default";
            }else{
                imagenURL = etURLImagen.getText().toString();
            }


            nombre = etNombreCiudad.getText().toString();
            lat = Double.parseDouble(etLatCiudad.getText().toString());
            lon = Double.parseDouble(etLonCiudad.getText().toString());

            nuevaCiudad();
        }
    }

    public void nuevaCiudad(){
        Intent intent = new Intent();
        intent.putExtra("nombre", nombre);
        intent.putExtra("lat", lat);
        intent.putExtra("lon", lon);
        intent.putExtra("urlImagen", imagenURL);
        setResult(RESULT_OK, intent);
        finish();
    }

}
