public class Materia {
  public String nome;
  public Curso curso;
  public Professor professor;
  public Aluno[] alunos;

  public Materia(String nome, Curso curso, Professor professor, Aluno[] alunos) {
    this.nome = nome;
    this.curso = curso;
    this.professor = professor;
    this.alunos = alunos;
  }
}
