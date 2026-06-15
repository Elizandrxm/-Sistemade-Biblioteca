package estrutura;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arvore_livros biblioteca = new Arvore_livros();
        int opcao;

        System.out.println("=== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA ===");
        biblioteca.popularBiblioteca(biblioteca);
        do {

            exibirMenu();
            opcao = lerInteiro(scanner, "Digite sua opção: ");

            switch (opcao) {
                case 1:
                    cadastrarLivro(scanner, biblioteca);
                    break;
                case 2:
                    removerLivro(scanner, biblioteca);
                    break;
                case 3:
                    buscarLivroPorISBN(scanner, biblioteca);
                    break;
                case 4:
                    biblioteca.exibirEmOrdem();
                    break;
                case 5:
                    biblioteca.exibirPreOrdem();
                    break;
                case 6:
                    biblioteca.exibirPosOrdem();
                    break;
                case 7:
                    biblioteca.mostrarMenorISBN();
                    break;
                case 8:
                    biblioteca.mostrarMaiorISBN();
                    break;
                case 9:
                    biblioteca.mostrarQuantidade();
                    break;
                case 10:
                    biblioteca.mostrarAltura();
                    break;
                case 11:
                    System.out.println("\nEncerrando o sistema... Obrigado por usar a biblioteca!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Por favor, digite um número entre 1 e 11.");
            }

            if (opcao != 11) {
                System.out.println("\n" + "=".repeat(50));
            }

        } while (opcao != 11);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("MENU PRINCIPAL");
        System.out.println("=".repeat(50));
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Remover livro");
        System.out.println("3 - Buscar livro por ISBN");
        System.out.println("4 - Listar livros (Ordem Crescente - In-Order)");
        System.out.println("5 - Listar livros (Pré-Ordem - Pre-Order)");
        System.out.println("6 - Listar livros (Pós-Ordem - Post-Order)");
        System.out.println("7 - Mostrar livro com menor ISBN");
        System.out.println("8 - Mostrar livro com maior ISBN");
        System.out.println("9 - Mostrar quantidade total de livros");
        System.out.println("10 - Mostrar altura da árvore");
        System.out.println("11 - Encerrar sistema");
        System.out.println("=".repeat(50));
    }

    private static void cadastrarLivro(Scanner scanner, Arvore_livros biblioteca) {
        System.out.println("\n--- CADASTRO DE LIVRO ---");

        long isbn = lerLong(scanner, "Digite o ISBN do livro: ");

        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.print("Digite a área do livro: ");
        String area = scanner.nextLine();

        int quantidadeDisponivel = lerInteiro(scanner, "Digite a quantidade disponível: ");

        Livro novoLivro = new Livro(isbn, titulo, autor, area, quantidadeDisponivel);
        biblioteca.inserir(novoLivro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void removerLivro(Scanner scanner, Arvore_livros biblioteca) {
        System.out.println("\n--- REMOVER LIVRO ---");

        if (biblioteca.raiz == null) {
            System.out.println("A biblioteca está vazia. Nenhum livro para remover.");
            return;
        }

        long isbn = lerLong(scanner, "Digite o ISBN do livro que deseja remover: ");

        Livro livroEncontrado = biblioteca.buscarLivro(isbn);

        if (livroEncontrado == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        biblioteca.removerLivro(isbn);
        System.out.println("Livro removido com sucesso!");
    }

    private static void buscarLivroPorISBN(Scanner scanner, Arvore_livros biblioteca) {
        System.out.println("\n--- BUSCAR LIVRO ---");

        if (biblioteca.raiz == null) {
            System.out.println("A biblioteca está vazia.");
            return;
        }

        long isbn = lerLong(scanner, "Digite o ISBN do livro que deseja buscar: ");

        Livro livroEncontrado = biblioteca.buscarLivro(isbn);

        if (livroEncontrado != null) {
            System.out.println("\nLivro encontrado:");
            System.out.println(" " + livroEncontrado);
        } else {
            System.out.println("\nLivro com ISBN " + isbn + " não encontrado na biblioteca.");
        }
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scanner.nextLine();
        }
    }

    private static long lerLong(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextLong()) {
                long valor = scanner.nextLong();
                scanner.nextLine();
                return valor;
            }
            System.out.println("Entrada inválida. Digite um número válido.");
            scanner.nextLine();
        }
    }
}