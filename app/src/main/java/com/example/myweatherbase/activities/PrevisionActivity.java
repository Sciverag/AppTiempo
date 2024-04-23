package com.example.myweatherbase.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.MyRecyclerViewAdapter;

import okhttp3.Call;

public class PrevisionActivity extends BaseActivity implements CallInterface{
    private RecyclerView rvTiempo;
    private MyRecyclerViewAdapter mrva;
    private TextView tvNombreCiudad;
    private double lat;
    private double lon;
    private String nombreCiudad;
    private Root root;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prevision_activity);

        Bundle extras = getIntent().getExtras();
        assert extras != null;
        lat = extras.getDouble("lat");
        lon = extras.getDouble("lon");
        nombreCiudad = extras.getString("nombreCiudad");

        rvTiempo = findViewById(R.id.rvTiempo);
        tvNombreCiudad = findViewById(R.id.tvNombreCiudad);
        tvNombreCiudad.setText(nombreCiudad);

        showProgress();
        executeCall(this);
    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        root = Connector.getConector().get(Root.class,"&lat="+lat+"&lon="+lon);
        mrva = new MyRecyclerViewAdapter(root,this);
        mrva.setLayout(R.layout.recycler_list_item);
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();

        rvTiempo.setAdapter(mrva);
        rvTiempo.setLayoutManager(new LinearLayoutManager(this));
    }
}
