package com.company;

import java.sql.Timestamp;

public class Vermelho extends Exercito {
    public Vermelho() {
        qtdMensageiro = 5;
    }

    public void printMensRestantes(){
        System.out.println("Mensageiros restantes do exército vermelho: " + this.getQtdMensageiro() + "/5");
    }

    public void dispararSinalizador(Timestamp timestamp){
        System.out.println(timestamp + " Sinalizador disparado.\n");
    }

    public void informarAtaque(Combate c, Timestamp timestampInicial, Mensagem[] m, int numMsg, Mensageiro[] mv, Timestamp
            timestamp, Azul a, boolean azulEmCampo){
        Timestamp tempoInicial = new Timestamp(timestamp.getTime());

        m[numMsg-1] = new Mensagem(numMsg,"ataque");

        // O exército vermelho envia a mesma mensagem até que ela seja entregue e enquanto tiver mensageiros disponíveis
        while(!m[numMsg-1].isEntregue() && this.getQtdMensageiro() >= 1){

            /* Se o exército azul ainda deve enviar outro mensageiro, então ele o fará a cada 4201 segundos, obrigando
            o retorno ao método 'informarSituacao'*/
            if (azulEmCampo && timestamp.getTime() - tempoInicial.getTime() > 4201000)
                break;

            mv[this.getQtdMensageiro()-1] = new Mensageiro();

            this.enviarMensageiro(mv[this.getQtdMensageiro()-1],m[numMsg-1],"base azul", timestamp);

            this.setQtdMensageiro(this.getQtdMensageiro()-1);
        }

        /* Se a mensagem não foi entregue (o que significa que não há mais mensageiros vermelhos por ter saído do
        'while') e não há soldado azul em campo, então o exército perdeu */
        if (!azulEmCampo && !m[numMsg-1].isEntregue())
            c.printDerrota(this,a,timestampInicial,timestamp);
    }
}
