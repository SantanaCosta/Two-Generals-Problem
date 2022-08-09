package com.company;

import java.sql.Timestamp;

public class Exercito {
    protected int qtdMensageiro;
    protected boolean preparadoAtaque;

    // Um exército faz um mensageiro viajar para alguma base com alguma mensagem
    public void enviarMensageiro(Mensageiro mensageiro, Mensagem mensagem, String local, Timestamp timestamp){
        System.out.println(timestamp +" Mensageiro enviado para " + local + " com mensagem #" + mensagem.getNumero()
        + ".");

        mensageiro.viajar(local, mensagem, timestamp);
    }

    public int getQtdMensageiro() {
        return qtdMensageiro;
    }

    public void setQtdMensageiro(int qtdMensageiro) {
        this.qtdMensageiro = qtdMensageiro;
    }

    public boolean isPreparadoAtaque() {
        return preparadoAtaque;
    }

    public void setPreparadoAtaque(boolean preparadoAtaque) {
        this.preparadoAtaque = preparadoAtaque;
    }
}
