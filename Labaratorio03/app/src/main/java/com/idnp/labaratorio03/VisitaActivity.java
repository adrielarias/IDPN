package com.idnp.labaratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VisitaActivity extends AppCompatActivity {

    private static final int MAIN_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);

    }

    public void guardarVisita(View vista){
        //Captura y guardado de datos
        TextView peso = (TextView) findViewById(R.id.inputPeso);
        TextView temperatura = (TextView) findViewById(R.id.inputTemperatura);
        TextView presion = (TextView) findViewById(R.id.inputPresion);
        TextView saturacion = (TextView) findViewById(R.id.inputSaturacion);
        Visita visitaTemp = new Visita(peso.getText().toString(),temperatura.getText().toString(),presion.getText().toString(),saturacion.getText().toString());

        //Enviar a main
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("visita", visitaTemp);
        intent.putExtras(bundle);
        startActivityForResult(intent, MAIN_ACTIVITY_REQUEST_CODE);

        //Mensaje de guardado Toask


    }
}