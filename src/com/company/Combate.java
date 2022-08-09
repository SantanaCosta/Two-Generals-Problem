package com.company;

import java.sql.Timestamp;

public class Combate {

    public void printTempoDecorrido(long segundos){
        long s = segundos % 60;
        long m = (segundos / 60) % 60;
        long h = (segundos / (60 * 60)) % 24;
        System.out.println("Tempo decorrido: " + String.format("%d:%02d:%02d", h,m,s));
    }

    public void printVitoria(Vermelho v, Azul a, Timestamp timestampInicial, Timestamp timestamp){
        System.out.println("Vitória do exército.");
        v.printMensRestantes();
        a.printMensRestantes();
        printTempoDecorrido((timestamp.getTime()-timestampInicial.getTime())/1000);
    }

    public void printDerrota(Vermelho v, Azul a, Timestamp timestampInicial, Timestamp timestamp){
        System.out.println("Derrota do exército.");
        v.printMensRestantes();
        a.printMensRestantes();
        printTempoDecorrido((timestamp.getTime()-timestampInicial.getTime())/1000);

        System.exit(0);
    }

}
