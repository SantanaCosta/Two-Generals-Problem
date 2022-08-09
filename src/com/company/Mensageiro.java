package com.company;

import java.sql.Timestamp;
import java.util.Random;

public class Mensageiro {
    private boolean capturado;

    public boolean isCapturado() {
        return capturado;
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public void viajar(String local, Mensagem mensagem, Timestamp timestamp){
        int min = 3600000, max = 4200000, limiteMsgV = 12601000, limiteMsgA = 4201000;

        Random gerador = new Random(timestamp.getTime());

        int tempoViagem = gerador.ints(min,max).findFirst().getAsInt();

        if (gerador.nextDouble() > 0.45){
            // Mensageiro não é capturado e a mensagem é entregue
            timestamp.setTime(timestamp.getTime() + tempoViagem);
            mensagem.setEntregue(true);
            System.out.println(timestamp +" Mensagem #"+ mensagem.getNumero() + "("+mensagem.getConteudo()+")" +
                    " entregue com sucesso para a "+ local + ".");
        }
        else {
            /* Mensageiro é capturado (para fins de impressão, o tempo da viagem é divido por 2 supondo que o
            foi capturado no meio do percurso) */
            timestamp.setTime(timestamp.getTime() + (tempoViagem/2));
            this.setCapturado(true);
            System.out.println(timestamp +" Mensageiro capturado.");

            // É adicionado ao timestamp o tempo limite do exército que enviou o mensageiro
            if(local == "base azul")
                timestamp.setTime(timestamp.getTime() + limiteMsgV - (tempoViagem/2));
            else
                timestamp.setTime(timestamp.getTime() + limiteMsgA - (tempoViagem/2));
        }
    }
}
