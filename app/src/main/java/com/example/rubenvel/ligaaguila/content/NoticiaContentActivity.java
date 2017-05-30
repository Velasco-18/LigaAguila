package com.example.rubenvel.ligaaguila.content;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import com.example.rubenvel.ligaaguila.R;
import com.example.rubenvel.ligaaguila.databinding.ActivityNoticiaContentBinding;
import com.example.rubenvel.ligaaguila.models.Noticia;
import com.example.rubenvel.ligaaguila.util.Data;

public class NoticiaContentActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {

   public static final String POS_EXTRA = "pos"; //variable constante

    ActivityNoticiaContentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_noticia_content);

        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //recupera la posicion
        Bundle posicion = getIntent().getExtras();
        int pos = posicion.getInt(POS_EXTRA);

        Noticia noticia = Data.getDataNoticia().get(pos);

        binding.setNoticias(noticia);
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public void onGlobalLayout() {
        BitmapDrawable drawable = (BitmapDrawable) binding.imgNoticia.getDrawable(); //Bitmap imageView
        Palette p = Palette.from(drawable.getBitmap()).generate(); //palette del bitmap

        int colorDefault = ContextCompat.getColor(this, R.color.colorPrimary);
        binding.collapsingBar.setContentScrimColor(p.getVibrantColor(colorDefault));
    }
}
