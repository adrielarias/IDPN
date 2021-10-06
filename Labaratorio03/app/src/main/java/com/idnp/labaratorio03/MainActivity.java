package com.lab02.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvnombre,  tvDNI, tvDir;
    Button btnpac,btnvis,btncorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    tvnombre=(TextView)findViewById(R.id.tvNombre);
    tvDNI=(TextView)findViewById(R.id.tvDNI);
    tvDir=(TextView)findViewById(R.id.tvDir);
    btnpac=(Button)findViewById(R.id.btnPaciente);
        btnpac.setEnabled(true);
        /**
    btnpac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                btnpac.setEnabled(true);
                Intent inten= new Intent(MainActivity.this,MainActivity.class);
                startActivity(inten);

            }
        });
**/
    btnvis=(Button)findViewById(R.id.btnVisita);
        /**btnvis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent inten= new Intent(MainActivity.this,VisitaActivity.class);
                startActivity(inten);

            }
        });
**/

    btncorreo=(Button)findViewById(R.id.btnCorreo);
    /**
        btnvis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent inten= new Intent(MainActivity.this,CorreoActivity.class);
                startActivity(inten);

            }
        });

        mostrarDato();
     **/
    }
    private void mostrarDato(){
        Bundle datos = this.getIntent().getExtras();
        String nombre= datos.getString("name");
        String dni= datos.getString("dni");
        String dir= datos.getString("dir");
        tvnombre.setText(nombre);
        tvDNI.setText(dni);
        tvDir.setText(dir);
    }
}
