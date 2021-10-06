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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getSaturacion() {
        return saturacion;
    }

    public void setSaturacion(String saturacion) {
        this.saturacion = saturacion;
    }

    public String getString(){
        return "Peso: " + peso + "\tTemperatura: " + temperatura + "\nPresion: " + presion + "\tSaturacion: " + saturacion;
    }
}
