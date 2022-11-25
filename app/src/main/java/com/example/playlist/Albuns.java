package com.example.playlist;

public class Albuns {

    private String nome;
    private int imagem;
    private String  musica;
    private String tour;

    public Albuns(String nome, int imagem, String musica, String tour) {
        this.nome = nome;
        this.imagem = imagem;
        this.musica = musica;
        this.tour = tour;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }
}
