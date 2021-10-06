package com.idnp.labaratorio03;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int MAIN_ACTIVITY_REQUEST_CODE = 222;
    private static final int MAIN_ACTIVITY_REQUEST_CODE2 = 223;

    public static final String MESSAGE= "mensaje";
    public List<Visita> visitas= new ArrayList<>();
    public Paciente paciente;
    TextView tvnombre,  tvDNI, tvDir,mesaje;
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

        btnpac.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent inten= new Intent(MainActivity.this,PacienteActivity.class);
                startActivityForResult(inten, MAIN_ACTIVITY_REQUEST_CODE2);

            }
        });

        btnvis=findViewById(R.id.btnVisita);
        btnvis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent inten= new Intent(MainActivity.this,VisitaActivity.class);
                startActivityForResult(inten, MAIN_ACTIVITY_REQUEST_CODE);

            }
        });


        btncorreo=findViewById(R.id.btnCorreo);

        btncorreo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enviar(v);

            }
        });


        //mostrarDato();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == MAIN_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                Bundle bund= getIntent().getExtras();

                visitas.add((Visita) data.getSerializableExtra(MESSAGE));
            } else if(resultCode==RESULT_CANCELED){
                mesaje.setText("se cancelo");
            }
        }
        if (requestCode == MAIN_ACTIVITY_REQUEST_CODE2) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK
                Bundle bund= getIntent().getExtras();
                paciente = (Paciente) data.getSerializableExtra(MESSAGE);
                mostrarDato(paciente);
            } else if(resultCode==RESULT_CANCELED){
                mesaje.setText("se cancelo");
            }
        }
    }
    private void mostrarDato(Paciente p){
        String nombre= p.getNombre();
        String dni= p.getDni();
        String dir= p.getDireccion();
        tvnombre.setText("Paciente: " + nombre);
        tvDNI.setText("D.N.I. " + dni);
        tvDir.setText("Direccion: " + dir);
        btnpac.setEnabled(false);
    }
    public void enviar(View button){
        Intent intent=new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ptorresmar@unsa.edu.pe"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Reporte");
        String general="";
        for(int i=0;i<visitas.size();i++){
            general+=visitas.get(i).getString()+"\n\n";
        }
        intent.putExtra(Intent.EXTRA_TEXT,general);
        startActivity(intent);
    }
}