import java.util.Scanner;

public class ReprodutorMusical {
    public static void main(String[] args) {
        DoublyCircularLinkedList listaMusicas = new DoublyCircularLinkedList();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Adicionar música");
            System.out.println("2. Exibir lista de músicas");
            System.out.println("3. Reproduzir música atual");
            System.out.println("4. Avançar para próxima música");
            System.out.println("5. Voltar para música anterior");
            System.out.println("6. Remover música");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o título da música: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o nome do artista: ");
                    String artista = scanner.nextLine();
                    Musica novaMusica = new Musica(titulo, artista);
                    listaMusicas.add(novaMusica);
                    System.out.println("Música adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("Lista de músicas:");
                    listaMusicas.exibirLista();
                    break;
                case 3:
                    Musica musicaAtual = listaMusicas.reproduzirAtual();
                    if (musicaAtual != null) {
                        System.out.println("Reproduzindo: " + musicaAtual.titulo + " - " + musicaAtual.artista);
                    } else {
                        System.out.println("Não há músicas na lista.");
                    }
                    break;
                case 4:
                    listaMusicas.avancar();
                    System.out.println("Avançou para a próxima música.");
                    break;
                case 5:
                    listaMusicas.voltar();
                    System.out.println("Voltou para a música anterior.");
                    break;
                case 6:
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o título da música a remover: ");
                    String tituloRemover = scanner.nextLine();
                    System.out.print("Digite o nome do artista da música a remover: ");
                    String artistaRemover = scanner.nextLine();
                    Musica musicaRemover = new Musica(tituloRemover, artistaRemover);
                    listaMusicas.remove(musicaRemover);
                    System.out.println("Música removida com sucesso!");
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
