package Entidade;

public class Paciente {
    private String nome;
    private String estado;
    private int codigo;

    public Paciente(String nome, String estado, int codigo) {
        this.nome = nome;
        this.estado = estado;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public int getCodigo() {
        return codigo;
    }
}

