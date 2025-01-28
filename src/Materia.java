public class Materia {
  public int id;
  public String nome;
  public Curso curso;
  public Professor professor;
  public Aluno[] alunos;

  public Materia(int id, String nome, Curso curso, Professor professor, Aluno[] alunos) {
    this.id = id;
    this.nome = nome;
    this.curso = curso;
    this.professor = professor;
    this.alunos = alunos;
  }
}
