package controller;
// package view.Palavra;

public class Jogo extends view.Jogo {
    public Jogo() {
        this.bts.get(0).addActionListener(evt -> {
            System.out.println("aaaaaaaaaaaaaaaaaa");
        });
        this.miPalavras.addActionListener(evt -> {
            new view.Palavra();
        });
    }
}