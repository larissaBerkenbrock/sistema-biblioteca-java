package model;

import java.time.LocalDate;

public class Livro {
  // Atributos
  protected String titulo;
  protected String autor;
  protected int anoPublicacao;
  protected boolean disponivel;

  // Construtor
  public Livro(String titulo, String autor, int anoPublicacao) {
    setTitulo(titulo);
    setAutor(autor);
    setAnoPublicacao(anoPublicacao);
    setDisponivel(true);
  }

  // Getters
  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public int getAnoPublicacao() {
    return anoPublicacao;
  }

  public boolean isDisponivel() {
    return disponivel;
  }

  // Setters
  public void setTitulo(String titulo) {
    if (titulo != null && titulo.trim().length() >= 3) {
      this.titulo = titulo;
    } else {
      System.out.println("O Título deve conter pelo menos 3 caracteres!");
      if (this.titulo == null) {
        this.titulo = "Sem Título";
      }
    }
  }

  public void setAutor(String autor) {
    if (autor != null && autor.trim().length() >= 2) {
      this.autor = autor;
    } else {
      System.out.println("O Autor deve conter pelo menos 2 caracteres!");
      if (this.autor == null) {
        this.autor = "Autor Desconhecido";
      }
    }
  }

  public void setAnoPublicacao(int anoPublicacao) {
    if (anoPublicacao < 0) {
      this.anoPublicacao = LocalDate.now().getYear();
      System.out.println("O ano de publicação não pode ser negativo!");
    } else if (anoPublicacao <= LocalDate.now().getYear()) {
      this.anoPublicacao = anoPublicacao;
    } else {
      this.anoPublicacao = LocalDate.now().getYear();
      System.out.println("O ano de publicação não pode ser no futuro!");
    }
  }

  public void setDisponivel(boolean disponivel) {
    this.disponivel = disponivel;
  }

  // Métodos
  public void emprestarLivro() {
    if (disponivel == false) {
      System.out.println("Erro: o livro já se encontra emprestado e não está disponível.");
    } else {
      // Caso contrário, o livro está disponível → marca como indisponível e empresta
      setDisponivel(false); // false = emprestado / não disponível
      System.out.println("Sucesso: o livro foi emprestado com sucesso.");
    }
  }

  public void devolverLivro() {
    if (disponivel == true) {
      System.out.println("O livro não estava emprestado, não há nada a devolver.");
    } else {
      // Caso contrário, o livro está indisponível (foi emprestado) marca como
      // disponível
      setDisponivel(true); // true = disponível novamente
      System.out.println("O livro foi devolvido e está novamente disponível.");
    }
  }

  @Override
  public String toString() {
    return "Titulo: " + titulo +
        "\nAutor: " + autor +
        "\nAno Publicação: " + anoPublicacao +
        "\nDisponivel: " + (disponivel ? "Sim" : "Não");
  }

  public String getTipo() {
    return "Livro";
  }
}
