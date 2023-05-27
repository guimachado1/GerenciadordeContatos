import java.io.*;
import java.time.LocalDateTime;
abstract class Contato implements Serializable {
    private String nome;
    private String telefone;
    private LocalDateTime dataHoraCriacao;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataHoraCriacao = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "[" + getTipo() + "] Nome: " + nome + ", Telefone: " + telefone + ", Criado em: " + dataHoraCriacao;
    }
}