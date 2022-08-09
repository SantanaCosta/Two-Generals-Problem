package com.company;

import java.sql.Timestamp;
import java.util.Random;

public class Azul extends Exercito {
    private boolean horarioPossivel;

    public Azul() {
        qtdMensageiro = 10;
    }

    public void printMensRestantes(){
        System.out.println("Mensageiros restantes do exército azul: " + this.getQtdMensageiro() + "/10");
    }

    public boolean isHorarioPossivel() {
        return horarioPossivel;
    }

    public void setHorarioPossivel(boolean horarioPossivel) {
        this.horarioPossivel = horarioPossivel;
    }

    public boolean retornarHorarioPossivel(Timestamp timestamp){

        if (new Random(timestamp.getTime()).nextDouble() > 0.01)
            setHorarioPossivel(true);
        else
            setHorarioPossivel(false);

        return isHorarioPossivel();
    }

    public String definirConteudo(Timestamp timestamp){
        if(this.retornarHorarioPossivel(timestamp))
            return "confirmado";
        else
            return "horário impossível";
    }

    public void informarSituacao(Combate c, Timestamp timestampInicial,Mensagem[] m, int numMsg, Mensageiro[] ma,
                                 Timestamp timestamp, Vermelho v, Mensageiro[] mv){
        // Armazenando o momento em que o último mensageiro foi enviado
        Timestamp tempoEnvioVermelho = new Timestamp(timestamp.getTime());

        m[++numMsg-1] = new Mensagem(numMsg, this.definirConteudo(timestamp));

        // O exército azul envia a mesma mensagem até que ela seja entregue e enquanto tiver mensageiros disponíveis
        while(!m[numMsg-1].isEntregue() && this.getQtdMensageiro() >= 1){
            ma[this.getQtdMensageiro()-1] = new Mensageiro();

            this.enviarMensageiro(ma[this.getQtdMensageiro()-1],m[numMsg-1],"base vermelha", timestamp);

            this.setQtdMensageiro(this.getQtdMensageiro()-1);

            /* Se o exército azul envia a mensagem impossibilitando o horário ou já tenha passado o tempo limite de
            espera do exército vermelho, então será enviado um novo mensageiro vermelho */
            if ((m[numMsg-1].isEntregue() && m[numMsg-1].getConteudo() == "horário impossível") ||
                    (timestamp.getTime() - tempoEnvioVermelho.getTime() >= 12601000 && !m[numMsg-1].isEntregue())){
                Boolean azulEmCampo;

                if (m[numMsg-1].getConteudo() == "horário impossível"){
                    azulEmCampo = false;
                    System.out.println(timestamp + " Exército azul impossibilita o ataque.");
                }
                else
                    azulEmCampo = true;

                // É enviado um novo mensageiro vermelho
                v.informarAtaque(c,timestampInicial,m,numMsg+1,mv,timestamp,this,azulEmCampo);
                if (m[numMsg].isEntregue()){
                    /* Se a mensagem do mensageiro vermelho foi entregue, então deve-se armazenar o tempo do último
                    mensageiro vermelho e o exército azul enviará uma nova mensagem, voltando ao loop */
                    tempoEnvioVermelho.setTime(timestamp.getTime());
                    numMsg+=2;
                    m[numMsg-1] = new Mensagem(numMsg, definirConteudo(timestamp));
                }
            }
        }

        /* Se a última mensagem não foi entregue, então acabaram os mensageiros de algum dos exércitos, levando-os
        à derrota */
        if (!m[numMsg-1].isEntregue())
            c.printDerrota(v,this,timestampInicial,timestamp);
        else {
            // Caso contrário, os exércitos estão prontos para o ataque e vencerão
            v.dispararSinalizador(timestamp);
            v.setPreparadoAtaque(true);
            this.setPreparadoAtaque(true);
        }

    }
}
