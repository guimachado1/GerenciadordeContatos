import java.io.*;
import java.util.HashMap;
import java.util.Map;
class GerenciadorDeContatos implements Serializable {
    private Map<String, Contato> contatos;

    public GerenciadorDeContatos() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.put(contato.getNome(), contato);
    }

    public void removerContato(String nome) {
        contatos.remove(nome);
    }

    public Contato procurarContato(String nome) {
        return contatos.get(nome);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
        } else {
            for (Contato contato : contatos.values()) {
                System.out.println(contato);
            }
        }
    }

    public void salvarContatos(String nomeArquivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(contatos);
            System.out.println("Contatos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os contatos: " + e.getMessage());
        }
    }

    public void carregarContatos(String nomeArquivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            contatos = (Map<String, Contato>) inputStream.readObject();
            System.out.println("Contatos carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os contatos: " + e.getMessage());
        }
    }
}