

class DoublyCircularLinkedList {
    private No primeiro;
    private No atual;

    public DoublyCircularLinkedList() {
        this.primeiro = null;
        this.atual = null;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void add(Musica musica) {
        No novoNo = new No(musica);

        if (estaVazia()) {
            novoNo.proximo = novoNo;
            novoNo.anterior = novoNo;
            primeiro = novoNo;
            atual = novoNo;
        } else {
            No ultimo = primeiro.anterior;
            novoNo.proximo = primeiro;
            novoNo.anterior = ultimo;
            primeiro.anterior = novoNo;
            ultimo.proximo = novoNo;
        }
    }

    public void addFirst(Musica musica) {
        No novoNo = new No(musica);

        if (estaVazia()) {
            novoNo.proximo = novoNo;
            novoNo.anterior = novoNo;
            primeiro = novoNo;
            atual = novoNo;
        } else {
            No ultimo = primeiro.anterior;
            novoNo.proximo = primeiro;
            novoNo.anterior = ultimo;
            primeiro.anterior = novoNo;
            ultimo.proximo = novoNo;
            primeiro = novoNo;
        }
    }

    public Musica get(int indice) {
        if (estaVazia() || indice < 0) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        No atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
            if (atual == primeiro) {
                throw new IndexOutOfBoundsException("Índice inválido");
            }
        }

        return atual.musica;
    }

    public No nodeIndex(int indice) {
        if (estaVazia() || indice < 0) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        No atual = primeiro;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
            if (atual == primeiro) {
                throw new IndexOutOfBoundsException("Índice inválido");
            }
        }

        return atual;
    }

    public int indexOf(Musica musica) {
        if (estaVazia()) {
            return -1;
        }

        No atual = primeiro;
        int indice = 0;
        do {
            if (atual.musica.equals(musica)) {
                return indice;
            }
            atual = atual.proximo;
            indice++;
        } while (atual != primeiro);

        return -1;
    }

    public void remove(Musica musica) {
        if (estaVazia()) {
            return;
        }

        No atual = primeiro;
        while (atual != null) {
            if (atual.musica.equals(musica)) {
                if (atual == primeiro) {
                    primeiro = atual.proximo;
                }
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
                if (atual == atual.proximo) {
                    primeiro = null;
                }
                return;
            }
            atual = atual.proximo;
            if (atual == primeiro) {
                break;
            }
        }
    }

    public boolean contains(Musica musica) {
        return indexOf(musica) != -1;
    }

    public void clear() {
        primeiro = null;
        atual = null;
    }

    public void avancar() {
        if (!estaVazia()) {
            atual = atual.proximo;
        }
    }

    public void voltar() {
        if (!estaVazia()) {
            atual = atual.anterior;
        }
    }

    public Musica reproduzirAtual() {
        if (!estaVazia()) {
            return atual.musica;
        }
        return null;
    }

    public void exibirLista() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        No temp = primeiro;
        do {
            System.out.println(temp.musica.titulo + " - " + temp.musica.artista);
            temp = temp.proximo;
        } while (temp != primeiro);
    }
}