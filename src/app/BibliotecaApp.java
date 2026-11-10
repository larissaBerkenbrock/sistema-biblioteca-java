package app;

import java.util.Scanner;

import model.Biblioteca;
import model.Livro;
import model.LivroDigital;
import model.AudioLivro;
import model.LivroFisico;

public class BibliotecaApp {
    // Criação das variáveis consideradas necessárias
    // Responsável por gerir toda a biblioteca
    static Biblioteca biblioteca;

    public static void main(String[] args) {
        biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nBiblioteca - Escolha uma opção:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Procurar Livro");
            System.out.println("4. Listar Livros");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolver Livro");
            System.out.println("7. Listar Por Tipo");
            System.out.println("8. Listar disponiveis");
            System.out.println("9. Contar livros por tipo");
            System.out.println("10. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Escreva o tipo de livro: ");
                    String tipoLivro = scanner.nextLine();

                    System.out.println("Escreva o Titulo: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Escreva o nome do autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Escreva o ano de publicação do livro: ");
                    int anoPublicacao = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoLivro.equalsIgnoreCase("digital") || tipoLivro.equalsIgnoreCase("livro digital")) {
                        System.out.print("Escreva o tamanho de MB: ");
                        double tamanhoMB = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Escreva o formato: ");
                        String formato = scanner.nextLine();
                        Livro livroDigital = new LivroDigital(titulo, autor, anoPublicacao, tamanhoMB, formato);
                        biblioteca.adicionarLivro(livroDigital);
                    } else if (tipoLivro.equalsIgnoreCase("fisico") || tipoLivro.equalsIgnoreCase("livro fisico")) {
                        System.out.print("Escreva o numero de páginas: ");
                        int numeroPaginas = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Escreva a localização: ");
                        String localizacao = scanner.nextLine();
                        Livro livroFisico = new LivroFisico(titulo, autor, anoPublicacao, numeroPaginas, localizacao);
                        biblioteca.adicionarLivro(livroFisico);
                    } else if (tipoLivro.equalsIgnoreCase("audio") || tipoLivro.equalsIgnoreCase("audio livro")
                            || tipoLivro.equalsIgnoreCase("audiolivro")) {
                        System.out.print("Escreva a duração em minutos: ");
                        double duracaoMinutos = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Escreva o narrador: ");
                        String narrador = scanner.nextLine();
                        Livro audioLivro = new AudioLivro(titulo, autor, anoPublicacao, duracaoMinutos, narrador);
                        biblioteca.adicionarLivro(audioLivro);
                    } else {
                        System.out.println("Tipo de livro inválido.");
                    }
                    break;
                case 2:
                    System.out.println("Escreva o título do livro que quer apagar: ");
                    String apagarTitulo = scanner.nextLine();
                    biblioteca.removerLivro(apagarTitulo);
                    break;
                case 3:
                    System.out.println("Escreva o nome do livro: ");
                    String procurarLivro = scanner.nextLine();
                    verificarLivroEncontrado(biblioteca.procurarLivro(procurarLivro));
                    break;
                case 4:
                    biblioteca.listarLivros();
                    break;
                case 5:
                    System.out.println("Escreva o titulo do livro que quer emprestar: ");
                    String emprestarTitulo = scanner.nextLine();
                    Livro livroEmprestar = biblioteca.procurarLivro(emprestarTitulo);
                    if (livroEmprestar != null) {
                        livroEmprestar.emprestarLivro();
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;
                case 6:
                    // Devolver Livro
                    System.out.println("Escreva o titulo do livro que quer devolver: ");
                    String devolverTitulo = scanner.nextLine();
                    Livro livroDevolever = biblioteca.procurarLivro(devolverTitulo);
                    if (livroDevolever != null) {
                        livroDevolever.devolverLivro();
                    } else {
                        System.out.println("Livro não encontrado!");
                    }
                    break;
                case 7:
                    System.out.println("Escreva o tipo do livro: ");
                    String tipoListarPorTipo = scanner.nextLine();
                    biblioteca.listarPorTipo(tipoListarPorTipo);
                    break;
                case 8:
                    biblioteca.listarDisponiveis();
                    break;
                case 9:
                    biblioteca.contarLivrosPorTipo();
                    break;
                case 10:
                    System.out.println("Programa Terminado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 10);
    }

    // Métodos auxiliares (opcional)
    public static void verificarLivroEncontrado(Livro livro) {
        if (livro != null) {
            System.out.println("Livro encontrado.");

            System.out.println(livro.toString());
        } else {
            System.out.println("Livro não encontrado");
        }
    }

}
