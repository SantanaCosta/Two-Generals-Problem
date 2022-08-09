package com.company;

import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestampInicial = new Timestamp(System.currentTimeMillis());

        Combate c = new Combate();
        Vermelho v = new Vermelho();
        Azul a = new Azul();

        Mensageiro[] mv = new Mensageiro[v.getQtdMensageiro()];
        Mensageiro[] ma = new Mensageiro[a.getQtdMensageiro()];
        Mensagem[] m = new Mensagem[15];

        int numMsg = 1;

        // Os exércitos trocam mensagens até que ambos estejam preparados
        while(!v.isPreparadoAtaque() && !a.isPreparadoAtaque()){
            // O exército vermelho envia a 1ª mensagem marcando o ataque. Nesse momento não há nenhum azul em campo
            m[numMsg-1] = new Mensagem(numMsg,"ataque");
            v.informarAtaque(c,timestampInicial,m,numMsg,mv,timestamp, a,false);

            // O exército azul responde ao vermelho se confirma ou impossibilita o horário
            a.informarSituacao(c,timestampInicial,m,numMsg,ma,timestamp,v,mv);
        }

        c.printVitoria(v,a,timestampInicial,timestamp);
    }
}
