package model;

public class AudioLivro extends Livro {

  private double duracaoMinutos;
  private String narrador;

  public AudioLivro(String titulo, String autor, int anoPublicacao, double duracaoMinutos, String narrador) {
    super(titulo, autor, anoPublicacao);
    setDuracaoMinutos(duracaoMinutos);
    setNarrador(narrador);
  }

  public double getDuracaoMinutos() {
    return duracaoMinutos;
  }

  public String getNarrador() {
    return narrador;
  }

  public void setDuracaoMinutos(double duracaoMinutos) {
    if (duracaoMinutos >= 0) {
      this.duracaoMinutos = duracaoMinutos;
      System.out.println("Duracao de registada com sucesso!");
    } else {
      this.duracaoMinutos = 0;
      System.out.println("Duração inválida, valor definido como 0.");
    }
  }

  public void setNarrador(String narrador) {
    if (narrador.trim().length() >= 2) {
      this.narrador = narrador;
      System.out.println("Nome definido com sucesso.");
    } else {
      this.narrador = "Sem narrador.";
      System.out.println("Narrador inválido. Narrador não definido");
    }
  }

  @Override
  public void emprestarLivro() {
    if (disponivel == false) {
      System.out.println("Erro: o Audio Livro não está disponível.");
    } else {
      setDisponivel(false);
      System.out.println("Sucesso: o Audio Livro foi emprestado.");
    }
  }

  @Override
  public String getTipo() {
    return "Audio Livro";
  }

  @Override
  public String toString() {
    return super.toString() +
        "\nDuracao Minutos: " + duracaoMinutos +
        "\n Narrador: " + narrador;
  }
}
