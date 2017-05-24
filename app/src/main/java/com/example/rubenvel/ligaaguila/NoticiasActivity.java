package com.example.rubenvel.ligaaguila;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.example.rubenvel.ligaaguila.adapters.NoticiasAdapter;
import com.example.rubenvel.ligaaguila.databinding.ActivityNoticiasBinding;
import com.example.rubenvel.ligaaguila.util.Data;

public class NoticiasActivity extends AppCompatActivity implements NoticiasAdapter.OnNoticiaSelected {

    ActivityNoticiasBinding binding;
    NoticiasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_noticias);

        adapter = new NoticiasAdapter(getLayoutInflater(), Data.getData(), this);
        binding.list.setAdapter(adapter);
        binding.list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onNoticia(int position) {
        Toast.makeText(this, "Noticia" +position, Toast.LENGTH_SHORT).show();
    }
}
