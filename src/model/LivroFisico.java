package model;

public class LivroFisico extends Livro {

  // Atributos
  private int numeroPaginas;
  private String localizacao;

  // Construtores
  public LivroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas, String localizacao) {
    super(titulo, autor, anoPublicacao);
    setNumeroPaginas(numeroPaginas);
    setLocalizacao(localizacao);
  }

  // Getters || Setters
  public int getNumeroPaginas() {
    return numeroPaginas;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setNumeroPaginas(int numeroPaginas) {
    if (numeroPaginas > 0) {
      this.numeroPaginas = numeroPaginas;
    } else {
      this.numeroPaginas = 1;
      System.out.println("Numero de paginas invalido. Definido como: 1.");
    }
  }

  public void setLocalizacao(String localizacao) {
    if (localizacao.length() > 0) {
      this.localizacao = localizacao;
    } else {
      this.localizacao = "Por arrumar";
      System.out.println("Numero de livros invalido. Definido como: por arrumar.");
    }
  }

  // Metodos
  @Override
  public String getTipo() {
    return "Livro Fisico";
  }

  @Override
  public String toString() {
    return super.toString() +
        "\nNumero Paginas: " + numeroPaginas +
        "\nLocalizacao: " + localizacao;
  }
}
