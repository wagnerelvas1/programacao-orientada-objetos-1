public class Aluno extends Pessoa {
  public Curso curso;

  public Aluno(int id, String nome, int idade, Curso curso) {
    super(id, nome, idade);
    this.curso = curso;
  }
}
