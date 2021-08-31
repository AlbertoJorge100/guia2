package com.example.angelica_maria_flores_garzona_guia_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    public static final int ID_NUEVO=1;
    public static final String MSG="ASDF";
    public static List<String>lista=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btndatos=findViewById(R.id.btnDatos);
        Button btnAgregar=findViewById(R.id.btnAgregar);
        Button btnMostrar=findViewById(R.id.btnLista);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lista.size()!=0){
                    Intent intn = new Intent(getApplicationContext(), MostrarActivity.class);
                    startActivity(intn);
                }else
                    Toast.makeText(getApplicationContext(), "No hay nombres en la lista !", Toast.LENGTH_SHORT).show();

            }
        });


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intn=new Intent(MainActivity.this, AgregarActivity.class);
                startActivityForResult(intn, ID_NUEVO);
            }
        });

        btndatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Evento de boton
                Intent intn =new Intent(getApplicationContext(), DatosActivity.class);
                startActivity(intn);
            }
        });


    }
    public void onActivityResult(int requestcode, int resultcode, Intent data){
        super.onActivityResult(requestcode,resultcode, data);
        String nombres=data.getStringExtra(AgregarActivity.MSG);
        lista.add(nombres);
    }
}