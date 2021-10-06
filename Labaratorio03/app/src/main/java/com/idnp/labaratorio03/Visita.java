package com.idnp.labaratorio03;

import java.io.Serializable;

public class Visita implements Serializable {
    String peso;
    String temperatura;
    String presion;
    String saturacion;

    public Visita(){
        peso = "0";
        temperatura = "0";
        presion = "0";
        saturacion = "0";
    }

    public Visita(String ps, String t,String pr, String s){
        peso = ps;
        temperatura = t;
        presion = pr;
        saturacion = s;
    }
}
