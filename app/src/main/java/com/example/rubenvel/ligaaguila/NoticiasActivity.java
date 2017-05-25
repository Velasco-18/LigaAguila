package com.example.rubenvel.ligaaguila;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.rubenvel.ligaaguila.adapters.NoticiasAdapter;
import com.example.rubenvel.ligaaguila.databinding.ActivityNoticiasBinding;
import com.example.rubenvel.ligaaguila.util.Data;

public class NoticiasActivity extends AppCompatActivity
        implements NoticiasAdapter.OnNoticiaSelected, DrawerLayout.DrawerListener,
        NavigationView.OnNavigationItemSelectedListener {

    ActivityNoticiasBinding binding;
    NoticiasAdapter adapter;
/////////////////////////Drawer///////////////////////////////////////
    ActionBarDrawerToggle toggle;
//////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_noticias);

        //region Drawer Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, binding.drawer, toolbar, R.string.open, R.string.close);

        binding.drawer.setDrawerListener(toggle);
        toggle.syncState();

        binding.drawer.addDrawerListener(this);
        binding.nav.setNavigationItemSelectedListener(this);
        //endregion  Too

        adapter = new NoticiasAdapter(getLayoutInflater(), Data.getData(), this);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onNoticia(int position) {
        Toast.makeText(this, "Noticia" +position, Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        binding.drawer.closeDrawers();

        switch (item.getItemId()){
            case R.id.nav_noticias:
                Toast.makeText(this, "Noticias",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_equipo:
                Toast.makeText(this, "Mí Equipo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_tabla:
                Toast.makeText(this, "Tabla de Posiciones",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_partidos:
                Toast.makeText(this, "Partidos",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_historia:
                Toast.makeText(this, "Historia de la Liga Aguila",Toast.LENGTH_SHORT).show();
                break;

        }
        return false;
    }
}
