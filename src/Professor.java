public class Professor extends Pessoa {
  public String formacao;
  public float salario;

  public Professor(int id, String nome, int idade, String formacao, float salario) {
    super(id, nome, idade);
    this.formacao = formacao;
    this.salario = salario;
  }
}
