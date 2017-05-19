package com.example.rubenvel.ligaaguila;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rubenvel.ligaaguila.databinding.ActivitySesionBinding;

public class SesionActivity extends AppCompatActivity {

    ActivitySesionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sesion);
        binding.setHandlerSesion(this);
        binding.setHandlerRegistro(this);
        binding.setHandlerOmitir(this);

    }

    public void goToInicioSesion(){

        Intent intent = new Intent(this, ActualidadActivity.class);
        startActivity(intent);
    }
    public void goToRegistro(){
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void goToOmitir(){
        Intent intent = new Intent(this, ActualidadActivity.class);
        startActivity(intent);
    }
}
