package com.idnp.labaratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import static com.idnp.labaratorio03.MainActivity.MESSAGE;

public class PacienteActivity extends AppCompatActivity {
    EditText nombre, ape, dni, dir;
    Button guard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        nombre = (EditText) findViewById(R.id.inputNombres);
        ape = (EditText) findViewById(R.id.inputApellidos);
        dni = (EditText) findViewById(R.id.inputdni);
        dir = (EditText) findViewById(R.id.inputDireccion);

        guard = (Button) findViewById(R.id.btnGuardarPaciente);

        guard.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View v) {
                                         String name = nombre.getText().toString() + " " + ape.getText().toString();
                                         String dn = dni.getText().toString();
                                         String direccion = dir.getText().toString();
                                         Paciente pacienteTemp = new Paciente(name,dn,direccion);
                                         Intent inten = new Intent(PacienteActivity.this, MainActivity.class);

                                         Bundle bundle = new Bundle();
                                         bundle.putSerializable(MESSAGE, pacienteTemp);
                                         inten.putExtras(bundle);
                                         setResult(RESULT_OK,inten);
                                         finish();
                                     }
                                 }
        );

    }
}