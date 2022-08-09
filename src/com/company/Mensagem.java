package com.company;

public class Mensagem {
    private int numero;
    private String conteudo;
    private boolean entregue;

    public Mensagem(int numero, String conteudo) {
        setNumero(numero);
        setConteudo(conteudo);
        setEntregue(false);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    @Override
    public String toString() {
        return "Mensagem #" + numero + ":\n" + "'" + conteudo;
    }
}
