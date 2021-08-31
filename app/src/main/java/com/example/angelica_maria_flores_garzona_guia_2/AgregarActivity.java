package com.example.angelica_maria_flores_garzona_guia_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AgregarActivity extends AppCompatActivity {
    public static final String MSG="ASDF";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        Button btnaceptar=findViewById(R.id.btnAceptar);
        TextView txbNombres=findViewById(R.id.txbNombre);

        btnaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres=txbNombres.getText().toString();
                if(!nombres.equals("")){
                    EnviarData(nombres);
                }else
                    txbNombres.setError("Debe ingresar un nombre !");
            }
        });
    }
    private void EnviarData(String nombres){
        final ProgressBar progressBar=findViewById(R.id.pbCargando);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progreso = 0;
                while (progreso < 100){
                    //simular proceso
                    try{
                        Thread.sleep(50);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    progreso++;

                    //actualizar progresbar
                    final int finalProgreso = progreso;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(finalProgreso);
                        }
                    });

                }
                Finalizar(nombres);
            }
        }).start();
    }
    private void Finalizar(String nombres){
        Intent intn=new Intent(getApplicationContext(), MainActivity.class);
        intn.putExtra(MSG,nombres);
        setResult(MainActivity.ID_NUEVO,intn);
        finish();
    }

}