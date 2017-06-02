package com.example.rubenvel.ligaaguila;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.rubenvel.ligaaguila.databinding.ActivitySesionBinding;
import com.example.rubenvel.ligaaguila.models.Noticia;

public class SesionActivity extends AppCompatActivity {

    ActivitySesionBinding binding;
    Context contexto;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sesion);
        binding.setHandlerSesion(this);
        binding.setHandlerRegistro(this);
        binding.setHandlerOmitir(this);

        preferences = getSharedPreferences("Registro", contexto.MODE_PRIVATE);

        boolean login = preferences.getBoolean("login",false);

        if(login){
            Intent intent=new Intent(this, NoticiasActivity.class);
            startActivity(intent);
            finish();
        }

    }

    public void goToInicioSesion(){

        SharedPreferences.Editor editor = preferences.edit();

        String user=preferences.getString("Usuario", "" );
        String pass=preferences.getString("Contrasena", "" );

        String us = binding.user.getText().toString();
        String pa = binding.password.getText().toString();

        if(us.isEmpty() || pa.isEmpty()){

            Toast.makeText(getApplicationContext(), "Llene los campos completamente", Toast.LENGTH_SHORT).show();

        } else if(us.equals(user) && pa.equals(pass)){

            editor.putBoolean("login",true);
            editor.apply();
            finish();

            Intent intent = new Intent(this, NoticiasActivity.class);
            startActivity(intent);

        }else{

            Toast.makeText(this, "Usuario o Contraseña incorrectos",Toast.LENGTH_SHORT).show();

           //>>Enviar a activity principal con las sharedPreferences guardadas

        }

    }

    public void goToRegistro(){
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
    }

    public void goToOmitir(){
        Intent intent = new Intent(this, NoticiasActivity.class);
        startActivity(intent);
    }
}
