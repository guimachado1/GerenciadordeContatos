import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();
        Scanner scanner = new Scanner(System.in);

        boolean executar = true;

        while (executar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar contato pessoal");
            System.out.println("2. Adicionar contato profissional");
            System.out.println("3. Buscar contato");
            System.out.println("4. Listar contatos");
            System.out.println("5. Remover contato");
            System.out.println("6. Salvar contatos em arquivo");
            System.out.println("7. Carregar contatos do arquivo");
            System.out.println("8. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato pessoal:");
                    String nomePessoal = scanner.nextLine();
                    System.out.println("Digite o telefone do contato pessoal:");
                    String telefonePessoal = scanner.nextLine();
                    ContatoPessoal contatoPessoal = new ContatoPessoal(nomePessoal, telefonePessoal);
                    gerenciador.adicionarContato(contatoPessoal);
                    System.out.println("Contato pessoal adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome do contato profissional:");
                    String nomeProfissional = scanner.nextLine();
                    System.out.println("Digite o telefone do contato profissional:");
                    String telefoneProfissional = scanner.nextLine();
                    System.out.println("Digite o nome da empresa:");
                    String empresa = scanner.nextLine();
                    ContatoProfissional contatoProfissional = new ContatoProfissional(nomeProfissional, telefoneProfissional, empresa);
                    gerenciador.adicionarContato(contatoProfissional);
                    System.out.println("Contato profissional adicionado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o nome do contato a ser buscado:");
                    String nomeBuscar = scanner.nextLine();
                    Contato contatoEncontrado = gerenciador.procurarContato(nomeBuscar);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado:");
                        System.out.println(contatoEncontrado);
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Listagem de contatos:");
                    gerenciador.listarContatos();
                    break;
                case 5:
                    System.out.println("Digite o nome do contato a ser removido:");
                    String nomeRemover = scanner.nextLine();
                    gerenciador.removerContato(nomeRemover);
                    System.out.println("Contato removido com sucesso!");
                    break;
                case 6:
                    System.out.println("Digite o nome do arquivo para salvar os contatos:");
                    String nomeArquivoSalvar = scanner.nextLine();
                    gerenciador.salvarContatos(nomeArquivoSalvar);
                    break;
                case 7:
                    System.out.println("Digite o nome do arquivo para carregar os contatos:");
                    String nomeArquivoCarregar = scanner.nextLine();
                    gerenciador.carregarContatos(nomeArquivoCarregar);
                    break;
                case 8:
                    executar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, digite um número válido.");
                    break;
            }

            System.out.println();
        }

        System.out.println("Encerrando o programa...");
    }
}