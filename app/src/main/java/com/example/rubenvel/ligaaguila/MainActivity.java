package com.example.rubenvel.ligaaguila;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    private int sumador = 0;
    private Timer progreso;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        //progressBar.getIndeterminateDrawable().setColorFilter(Color.BLACK, PorterDuff.SRC_IN);

        text = (TextView) findViewById(R.id.text);

        final long fin = 100;
        progreso= new Timer();

        progreso.schedule(new TimerTask() {
            @Override
            public void run() {
                if(sumador < 100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText("Cargando "+sumador+" %");
                        }
                    });
                    progressBar.setProgress(sumador);
                    sumador = sumador+5;
                }else{
                    progreso.cancel();
                    Intent intent = new Intent(MainActivity.this,SesionActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,fin);
    }

}
