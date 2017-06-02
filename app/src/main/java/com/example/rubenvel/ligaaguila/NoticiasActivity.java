package com.example.rubenvel.ligaaguila;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rubenvel.ligaaguila.adapters.NoticiasAdapter;
import com.example.rubenvel.ligaaguila.databinding.ActivityNoticiasBinding;
import com.example.rubenvel.ligaaguila.fragments.EquipoFragment;
import com.example.rubenvel.ligaaguila.fragments.HistoriaFragment;
import com.example.rubenvel.ligaaguila.fragments.NoticiasFragment;
import com.example.rubenvel.ligaaguila.fragments.PartidoFragment;
import com.example.rubenvel.ligaaguila.fragments.PosicionesFragment;
import com.example.rubenvel.ligaaguila.models.Noticia;
import com.example.rubenvel.ligaaguila.util.NoticiaData;

import java.util.ArrayList;

import static com.example.rubenvel.ligaaguila.util.NoticiaData.getDataNoticia;

public class NoticiasActivity extends AppCompatActivity implements  DrawerLayout.DrawerListener,
        NavigationView.OnNavigationItemSelectedListener {

    ActivityNoticiasBinding binding;
    NoticiasAdapter adapter;

    ActionBarDrawerToggle toggle;

    Context contexto;
    SharedPreferences preferences;

    int content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_noticias);

        preferences = getSharedPreferences("Registro", contexto.MODE_PRIVATE);

        //region Drawer Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Botón hamburguesa
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawer, toolbar, R.string.open, R.string.close);

        binding.drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Botón hamburguesa
        binding.drawer.addDrawerListener(this);
        binding.nav.setNavigationItemSelectedListener(this);
        //endregion  Too

        content = R.id.nav_noticias;
        if(savedInstanceState!= null)
            content = savedInstanceState.getInt("content");

        setContent(content);

    }

    //region Toggle
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);
    }
    //endregion

        //region Drawer-Items
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawer.closeDrawers();
        setContent(item.getItemId());
        return false;
    }

    public void setContent(int navID){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        content = navID;
        switch (navID){

            case R.id.nav_noticias:
                toolbar.setTitle(R.string.actualidad);

                cambiarFragment(new NoticiasFragment());
                break;
            case R.id.nav_equipo:
                toolbar.setTitle(R.string.equipo);

                cambiarFragment(new EquipoFragment());
                break;
            case R.id.nav_tabla:
                toolbar.setTitle(R.string.tabla);

                cambiarFragment(new PosicionesFragment());
                break;
            case R.id.nav_partidos:
                toolbar.setTitle(R.string.partidos);

                cambiarFragment(new PartidoFragment());
                break;
            case R.id.nav_historia:
                toolbar.setTitle(R.string.historia);

                cambiarFragment(new HistoriaFragment());
                break;
            case R.id.nav_perfil:
                Intent intentPerfil = new Intent(NoticiasActivity.this, UserActivity.class);
                startActivity(intentPerfil);
                break;
            case R.id.nav_logout:
                Toast.makeText(this, "Cerrando Sesión",Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putBoolean("login",false);
                editor.apply();
                finish();


                Intent intentSalir = new Intent(NoticiasActivity.this, SesionActivity.class);
                startActivity(intentSalir);
                finish();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("content", content);
        super.onSaveInstanceState(outState);
    }

    //endregion

    void cambiarFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.containeer, fragment);
        ft.commit();
    }

}
