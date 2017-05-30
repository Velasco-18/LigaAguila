package com.example.rubenvel.ligaaguila;

import android.content.Intent;
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
import com.example.rubenvel.ligaaguila.fragments.NoticiasFragment;
import com.example.rubenvel.ligaaguila.fragments.PartidoFragment;
import com.example.rubenvel.ligaaguila.models.Noticia;
import com.example.rubenvel.ligaaguila.util.NoticiaData;

import java.util.ArrayList;

import static com.example.rubenvel.ligaaguila.util.NoticiaData.getDataNoticia;

public class NoticiasActivity extends AppCompatActivity implements  DrawerLayout.DrawerListener,
        NavigationView.OnNavigationItemSelectedListener {

    ActivityNoticiasBinding binding;
    NoticiasAdapter adapter;

    NoticiasFragment fragment;

    ActionBarDrawerToggle toggle;

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

        NoticiaData.dataN =  new ArrayList<>();
        fragment = new NoticiasFragment();
        cambiarFragment(NoticiasFragment.instace());
        cargarDatos();
    }

    private void cargarDatos(){

        getDataNoticia().clear();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n1 = new Noticia();
        n1.setNombre("DIM, por una victoria frente a Alianza para ratificarse como segundo");
        n1.setFecha("Actualizado Hace 2 Horas");
        n1.setDescripcion("");
        n1.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
        n1.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852751-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n2 = new Noticia();
        n2.setNombre("'Mi idea es poner a pensar al técnico en la Copa y en la Liga': Mena");
        n2.setFecha("Actualizado Hace 3 Horas");
        n2.setDescripcion("");
        n2.setDesc("El delantero del América celebró su regreso al gol y habló de los compromisos de los 'diablos rojos'");
        n2.setImagen("http://m.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852768-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n3 = new Noticia();
        n3.setNombre("Huila buscará cerrar en casa con una victoria: recibe al Cortuluá");
        n3.setFecha("Actualizado Hace 3 Horas");
        n3.setDescripcion("");
        n3.setDesc("El equipo 'opita' ha cedido 14 puntos en el Guillermo Plazas Alcid, que lo ubican en la parte baja.");
        n3.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852752-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n4 = new Noticia();
        n4.setNombre("Con la necesidad de un nuevo triunfo, Once Caldas recibirá al Pasto");
        n4.setFecha("Actualizado Hace 3 Horas");
        n4.setDescripcion("");
        n4.setDesc("Jugarán este sábado 20 de mayo a las 5:30 p.m., en el estadio Palogrande de Manizales.");
        n4.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852754-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n5 = new Noticia();
        n5.setNombre("'Patriotas es un equipo parejo y bien competitivo': Miguel A. Russo");
        n5.setFecha("Actualizado Hace 14 Horas");
        n5.setDescripcion("");
        n5.setDesc("El técnico de Millonarios habló de los errores que debe corregir para confirmar la clasificación.");
        n5.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852550-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n6 = new Noticia();
        n6.setNombre("'Queremos quitarle el invicto a Nacional en su casa': Máyer Candelo");
        n6.setFecha("Actualizado Hace 15 Horas");
        n6.setDescripcion("");
        n6.setDesc("El creativo 'azucarero' se mostró tranquilo por su futuro y positivo con su regreso al once titular.");
        n6.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852551-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n7 = new Noticia();
        n7.setNombre("'Tenemos dos partidos para revertir la situación': Leandro Castellanos");
        n7.setFecha("Actualizado Hace 15 Horas");
        n7.setDescripcion("");
        n7.setDesc("El arquero de Santa Fe se ilusiona con clasificar en la Copa Libertadores y la Liga I-2017.");
        n7.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852595-1.jpg");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Noticia n8 = new Noticia();
        n8.setNombre("'En el último tramo a veces nos aceleramos': David Mackalister Silva");
        n8.setFecha("Actualizado Hace 1 día");
        n8.setDescripcion("");
        n8.setDesc("De regreso a la titular de Millonarios, el volante habla de mejorar para asegurar la clasificación.");
        n8.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852462-1.jpg");

        getDataNoticia().add(n1);
        getDataNoticia().add(n2);
        getDataNoticia().add(n3);
        getDataNoticia().add(n4);
        getDataNoticia().add(n5);
        getDataNoticia().add(n6);
        getDataNoticia().add(n7);
        getDataNoticia().add(n8);

        fragment.notifyDataSet();

    }

    //@Override
    //public void onNoticia(int position) {
        //Toast.makeText(this, "Noticia" +position, Toast.LENGTH_SHORT).show();
    //    if(NoticiaData.dataN.equals(Item.TYPE)) {
    //        Intent intent = new Intent(this, NoticiaContentActivity.class);
    //        intent.putExtra("pos", position);
    //        startActivity(intent);
    //    }
    //}

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        switch (item.getItemId()){

            case R.id.nav_noticias:
                toolbar.setTitle(R.string.actualidad);

                Toast.makeText(this, "Noticias",Toast.LENGTH_SHORT).show();
                cambiarFragment(new NoticiasFragment());
                break;
            case R.id.nav_equipo:
                toolbar.setTitle(R.string.equipo);

                Toast.makeText(this, "Mí Equipo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_tabla:
                toolbar.setTitle(R.string.tabla);

                Toast.makeText(this, "Tabla de Posiciones",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_partidos:
                toolbar.setTitle(R.string.partidos);

                Toast.makeText(this, "Partidos",Toast.LENGTH_SHORT).show();
                cambiarFragment(new PartidoFragment());
                break;
            case R.id.nav_historia:
                toolbar.setTitle(R.string.historia);

                Toast.makeText(this, "Historia de la Liga Aguila",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_perfil:
                Toast.makeText(this, "Perfíl",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_logout:
                Intent intent = new Intent(NoticiasActivity.this, SesionActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return false;
    }
    //endregion

    void cambiarFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.containeer, fragment);
        ft.commit();
    }

}
