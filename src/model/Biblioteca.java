package model;

import java.util.ArrayList;

public class Biblioteca {

  // Atributos
  private ArrayList<Livro> livros;

  // Construtor
  public Biblioteca() {
    livros = new ArrayList<>();
  }

  // Métodos
  public void adicionarLivro(Livro livro) {
    if (livro == null) {
      System.out.println("Livro Inválido");
      return;
    }
    livros.add(livro);
    System.out.println("Livro adicionado com sucesso!");
  }

  public void removerLivro(String titulo) {
    for (int i = 0; i < livros.size(); i++) {
      if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
        livros.remove(i);
        System.out.println("Livro removido com sucesso!");
        return;
      }
    }
    System.out.println("Livro não encontrado!");
  }

  public Livro procurarLivro(String titulo) {
    for (int i = 0; i < livros.size(); i++) {
      if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
        return livros.get(i);
      }
    }
    return null;
  }

  public void listarLivros() {
    if (livros.isEmpty()) {
      System.out.println("Não existem livros registados");
      return;
    }

    for (int i = 0; i < livros.size(); i++) {
      System.out.println("--------");
      System.out.println(livros.get(i).toString());
      System.out.println("--------");
    }
  }

  public void listarPorTipo(String tipo) {
    for (int i = 0; i < livros.size(); i++) {
      if (livros.get(i).getTipo().equalsIgnoreCase(tipo)) {
        System.out.println("--------");
        System.out.println(livros.get(i).toString());
        System.out.println("--------");
      }
    }
  }

  public void listarDisponiveis() {
    for (int i = 0; i < livros.size(); i++) {
      if (livros.get(i).isDisponivel()) {
        System.out.println("--------");
        System.out.println(livros.get(i).toString());
        System.out.println("--------");
      }
    }
  }

  public void contarLivrosPorTipo() {
    int fisicos = 0;
    int digitais = 0;
    int audios = 0;
    int outros = 0;

    for (int i = 0; i < livros.size(); i++) {
      if (livros.get(i).getTipo().equalsIgnoreCase("Livro fisico")) {
        fisicos++;
      } else if (livros.get(i).getTipo().equalsIgnoreCase("Livro digital")) {
        digitais++;
      } else if (livros.get(i).getTipo().equalsIgnoreCase("Audio Livro")) {
        audios++;
      } else {
        outros++;
      }
    }
    System.out.println("Quantidade de livros por tipo: ");
    System.out.println("Livro fisico: " + fisicos);
    System.out.println("Livro digital: " + digitais);
    System.out.println("Audio Livros: " + audios);
    System.out.println("Outros livros: " + outros);
  }
}
