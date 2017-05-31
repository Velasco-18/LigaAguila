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

public class SesionActivity extends AppCompatActivity {

    ActivitySesionBinding binding;
    Context contexto;
    SharedPreferences preferences, preferences1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sesion);
        binding.setHandlerSesion(this);
        binding.setHandlerRegistro(this);
        binding.setHandlerOmitir(this);

        preferences = getSharedPreferences("Registro", contexto.MODE_PRIVATE);

        preferences1 = getSharedPreferences("Reg", contexto.MODE_PRIVATE);
    }

    public void goToInicioSesion(){

        String user=preferences.getString("Usuario", "" );
        String pass=preferences.getString("Contrasena", "" );

        String us=preferences1.getString("User", "" );
        String pa=preferences1.getString("Password", "" );

        SharedPreferences.Editor editor = preferences1.edit();
        editor.putString("User", binding.user.getText().toString());
        editor.putString("Password", binding.password.getText().toString());
        editor.apply();

        //String us = binding.user.getText().toString();
        //String pa = binding.password.getText().toString();

        if(us == user && pa == pass){
            Toast.makeText(this, "Llene los campos requeridos",Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, NoticiasActivity.class);
            startActivity(intent);
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
