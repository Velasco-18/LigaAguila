package com.example.rubenvel.ligaaguila;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rubenvel.ligaaguila.databinding.ActivityInicioBinding;

public class InicioActivity extends AppCompatActivity  {

    private Context contexto;
    ActivityInicioBinding binding;
    SharedPreferences preferences;
    Button registrar;
    String equiposData[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_inicio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.setHandler(this);

        preferences = getSharedPreferences("Registro", contexto.MODE_PRIVATE);

        String Nombre=preferences.getString("Nombre", "" );
        binding.editNombre.setText(Nombre);

        String Apellido=preferences.getString("Apellido", "" );
        binding.editApellido.setText(Apellido);

        String Usuario=preferences.getString("Usuario", "" );
        binding.editUsuario.setText(Usuario);

        String Contrasena=preferences.getString("Contrasena", "" );
        binding.editContrasena.setText(Contrasena);

        String ContrasenaRec=preferences.getString("ContrasenaRec", "" );
        binding.editContrasenaRec.setText(ContrasenaRec);

        String Correo=preferences.getString("Correo", "" );
        binding.editCorreo.setText(Correo);

        String Equipo=preferences.getString("Equipo", "" );

        equiposData = getResources().getStringArray(R.array.equipos);

        /*if ((binding.editNombre == null)&&(binding.editApellido == null)&&(binding.editUsuario == null)
                &&(binding.editContrasena == null)&&(binding.editContrasenaRec == null)&&(binding.editCorreo == null)){



        }*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }



    public void goToGuardarRegistro(){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre", binding.editNombre.getText().toString());
        editor.putString("Apellido", binding.editApellido.getText().toString());
        editor.putString("Usuario", binding.editUsuario.getText().toString());
        editor.putString("Contrasena", binding.editContrasena.getText().toString());
        editor.putString("ContrasenaRec", binding.editContrasenaRec.getText().toString());
        editor.putString("Correo", binding.editCorreo.getText().toString());
        editor.putString("Equipo",binding.spinner.getSelectedItem()+"");

        int pos=binding.spinner.getSelectedItemPosition();

        editor.apply();

        Toast.makeText(getApplicationContext(), "Registrado Correctamente", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SesionActivity.class);
        startActivity(intent);
    }
}
