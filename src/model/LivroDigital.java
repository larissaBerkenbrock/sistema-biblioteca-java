package model;

public class LivroDigital extends Livro {
  private double tamanhoMB;
  private String formato;

  public LivroDigital(String titulo, String autor, int anoPublicacao, double tamanhoMB, String formato) {
    super(titulo, autor, anoPublicacao);
    setTamanhoMB(tamanhoMB);
    setFormato(formato);
  }

  public double getTamanhoMB() {
    return tamanhoMB;
  }

  public String getFormato() {
    return formato;
  }

  public void setTamanhoMB(double tamanhoMB) {
    if (tamanhoMB >= 0) {
      this.tamanhoMB = tamanhoMB;
      System.out.println("Tamanho definido com sucesso.");
    } else {
      this.tamanhoMB = 0.0;
      System.out.println("Valor incorreto.");
    }
  }

  public void setFormato(String formato) {
    if (formato != null && !formato.trim().isEmpty()) {
      this.formato = formato.trim().toUpperCase();
      System.out.println("Sucesso. Formato definido.");
    } else {
      this.formato = "DESCONHECIDO";
      System.out.println("Formato inválido. Definido como DESCONHECIDO.");
    }
  }

  @Override
  public void emprestarLivro() {
    setDisponivel(true);
    System.out.println("Livro digital emprestado concedido. Continua disponível.");
  }

  @Override
  public void devolverLivro() {
    setDisponivel(true);
    System.out.println("Livro digital continua disponível. Não necessita de devolução.");
  }

  @Override
  public String getTipo() {
    return "Livro Digital";
  }

  @Override
  public String toString() {
    return super.toString() +
        "\nTamanhoMB: " + tamanhoMB +
        "\nFormato: " + formato;
  }
}
