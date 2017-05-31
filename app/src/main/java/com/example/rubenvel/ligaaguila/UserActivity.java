package com.example.rubenvel.ligaaguila;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.rubenvel.ligaaguila.attrs.Attrs;
import com.example.rubenvel.ligaaguila.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;
    Context contexto;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Recuperación de datos
        preferences = getSharedPreferences("Registro", contexto.MODE_PRIVATE);

        //region Asignación de datos en cada campo
        String Nombre=preferences.getString("Nombre", "" );
        binding.textNombre.setText(Nombre);

        String Apellido=preferences.getString("Apellido", "" );
        binding.textApellido.setText(Apellido);

        String Usuario=preferences.getString("Usuario", "" );
        binding.textUser.setText(Usuario);

        String Correo=preferences.getString("Correo", "" );
        binding.textCorreo.setText(Correo);

        int spinnerEquipo = preferences.getInt("Equipo",-1);
        if(spinnerEquipo != -1){
            //region Casos para mostrar equipo
            switch(spinnerEquipo){
                case 0:
                    Attrs.setImage(binding.imageEquipo,"http://1.bp.blogspot.com/-wNoVmzHIxh4/UUO_WuU_YAI/AAAAAAAAAnA/evnh28VXIBk/s1600/AmericadeCali_Escudo.png");
                    binding.textEquipo.setText("América de Cali");
                    break;
                case 1:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3855.png");
                    binding.textEquipo.setText("Atl. Nacional");
                    break;
                case 2:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4200.png");
                    binding.textEquipo.setText("Ind. Medellín");
                    break;
                case 3:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4201.png");
                    binding.textEquipo.setText("Deportivo Cali");
                    break;
                case 4:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4196.png");
                    binding.textEquipo.setText("Millonarios");
                    break;
                case 5:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4206.png");
                    binding.textEquipo.setText("Jaguares de Córdoba");
                    break;
                case 6:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4194.png");
                    binding.textEquipo.setText("Ind. Santa Fe");
                    break;
                case 7:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4199.png");
                    binding.textEquipo.setText("Alianza Petrolera");
                    break;
                case 8:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3839.png");
                    binding.textEquipo.setText("Patriotas");
                    break;
                case 9:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3849.png");
                    binding.textEquipo.setText("La Equidad");
                    break;
                case 10:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4227.png");
                    binding.textEquipo.setText("Atl. Bucaramanga");
                    break;
                case 11:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3840.png");
                    binding.textEquipo.setText("Tolima");
                    break;
                case 12:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4228.png");
                    binding.textEquipo.setText("Tigres");
                    break;
                case 13:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3850.png");
                    binding.textEquipo.setText("Rionegro Águilas");
                    break;
                case 14:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3847.png");
                    binding.textEquipo.setText("Atl. Huila");
                    break;
                case 15:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3851.png");
                    binding.textEquipo.setText("Junior");
                    break;
                case 16:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4208.png");
                    binding.textEquipo.setText("Cortuluá");
                    break;
                case 17:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4202.png");
                    binding.textEquipo.setText("Once Caldas");
                    break;
                case 18:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/3841.png");
                    binding.textEquipo.setText("Envigado");
                    break;
                case 19:
                    Attrs.setImage(binding.imageEquipo,"http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/4195.png");
                    binding.textEquipo.setText("Dep. Pasto");
                    break;
                default:
                    binding.textEquipo.setText("-1");
                    break;
            }
            //endregion
        }
        //endregion
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.opc_perfil:
                Intent intentSalir = new Intent(UserActivity.this, SesionActivity.class);
                startActivity(intentSalir);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
