package com.example.rubenvel.ligaaguila;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rubenvel.ligaaguila.databinding.ActivityInicioBinding;

public class InicioActivity extends AppCompatActivity  {

    Context contexto;
    ActivityInicioBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_inicio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.setHandler(this);


        preferences = getSharedPreferences("Registro", contexto.MODE_PRIVATE);

        /*String Nombre=preferences.getString("Nombre", "" );
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
        binding.editCorreo.setText(Correo);*/

        int spinnerEquipo = preferences.getInt("Equipo",-1);
        if(spinnerEquipo != -1){
            binding.spinner.setSelection(spinnerEquipo);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }

    public void goToGuardarRegistro(){

        String nombre = binding.editNombre.getText().toString();
        String apellido=binding.editApellido.getText().toString();
        String usuario =binding.editUsuario.getText().toString();
        String contrasena= binding.editContrasena.getText().toString();
        String contrasenaRec = binding.editContrasenaRec.getText().toString();
        String correo = binding.editCorreo.getText().toString();

         if(nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || contrasenaRec.isEmpty() || correo.isEmpty()){

             Toast.makeText(getApplicationContext(), "Llene los campos de registro completamente", Toast.LENGTH_SHORT).show();

         }else if(contrasena.equals(contrasenaRec)){

             int pos=binding.spinner.getSelectedItemPosition();

             SharedPreferences.Editor editor = preferences.edit();
             editor.putString("Nombre", nombre);
             editor.putString("Apellido", apellido);
             editor.putString("Usuario", usuario);
             editor.putString("Contrasena", contrasena);
             editor.putString("ContrasenaRec", contrasenaRec);
             editor.putString("Correo", correo);

             editor.putInt("Equipo", pos);

             editor.apply();

             Toast.makeText(getApplicationContext(), "Registrado Correctamente", Toast.LENGTH_SHORT).show();
             Intent intent = new Intent(this, SesionActivity.class);
             startActivity(intent);

         }else{

                Toast.makeText(getApplicationContext(), "Rectifica tu contraseña", Toast.LENGTH_SHORT).show();

         }
    }
}
