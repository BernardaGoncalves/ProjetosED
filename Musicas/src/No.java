class No {
    Musica musica;
    No proximo;
    No anterior;

    public No(Musica musica) {
        this.musica = musica;
        this.proximo = null;
        this.anterior = null;
    }
}