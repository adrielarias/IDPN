package com.idnp.labaratorio03;

import static com.idnp.labaratorio03.MainActivity.MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class VisitaActivity extends AppCompatActivity {

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

        //Mensaje de guardado Toask
        Toast.makeText(this, visitaTemp.getString(), Toast.LENGTH_SHORT).show();

        //Enviar a main
        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MESSAGE, visitaTemp);
        intent.putExtras(bundle);
        setResult(RESULT_OK,intent);
        finish();

    }
}