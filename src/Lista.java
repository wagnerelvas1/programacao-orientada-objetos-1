import java.util.ArrayList;

public class Lista {
  public static ArrayList<Professor> professores = new ArrayList<>();
  public static ArrayList<Aluno> alunos = new ArrayList<>();
  public static ArrayList<Curso> cursos = new ArrayList<>();
  public static ArrayList<Materia> materias = new ArrayList<>();
  
  public static void listarAlunos() {
    int contador = 1;
    System.out.print("LISTA DE ALUNOS: \n");
    for (Aluno aluno : alunos) {
      System.out.print(contador + "- " + aluno.nome + ".\n");
      contador++;
    }
  }

  public static void listarAlunosDetalhado() {
    int contador = 1;
    System.out.print("\n\n" + """
    +-----------------------------------+
    |          LISTA DE ALUNOS          |
    +-----------------------------------+
    """);
    for (Aluno aluno : alunos) {
      System.out.print(contador + "- " + aluno.nome + " - Idade: " + aluno.idade + " anos - Curso: " + aluno.curso.nome + ".\n");
      contador++;
    }
  }

  public static ArrayList<Aluno> listarAlunosPorCurso(Curso curso) {
    int contador = 1;
    ArrayList<Aluno> alunosCurso = new ArrayList<>();
    System.out.print("LISTA DE ALUNOS: \n");
    for (Aluno aluno : alunos) {
      if(aluno.curso == curso) {
        System.out.print(contador + "- " + aluno.nome + " - Idade: " + aluno.idade + " anos - Curso: " + aluno.curso.nome + ".\n");
        alunosCurso.add(aluno);
        contador++;
      }
    }
    return alunosCurso;
  }


  public static void listarProfessores() {
    int contador = 1;
    System.out.print("LISTA DE PROFESSORES: \n");
    for (Professor professor : professores) {
      System.out.print(contador + "- " + professor.nome + "\n");
      contador++;
    }
  }

  public static void listarProfessoresDetalhado() {
    int contador = 1;
    System.out.print("\n\n" + """
    +-----------------------------------+
    |       LISTA DE PROFESSORES        |
    +-----------------------------------+
    """);
    for (Professor professor : professores) {
      System.out.print(contador + "- " + professor.nome + " - Idade: " + professor.idade + " anos - Formação: " + professor.formacao + ".\n");
      contador++;
    }
  }


  public static void listarCursos() {
    int contador = 1;
    System.out.print("LISTA DE CURSOS: \n");
    for (Curso curso : cursos) {
      System.out.print(contador + "- " + curso.nome + "\n");
      contador++;
    }
  }

  public static void listarCursosDetalhado() {
    int contador = 1;
    System.out.print("\n\n" + """
    +-----------------------------------+
    |          LISTA DE CURSOS          |
    +-----------------------------------+
    """);
    for (Curso curso : cursos) {
      System.out.print(contador + "- " + curso.nome + " - Duração: " + curso.duracao + " períodos - Turno: " + curso.turno + ".\n");
      contador++;
    }
  }


  public static void listarMaterias() {
    int contador = 1;
    System.out.print("LISTA DE MATÉRIAS: \n");
    for (Materia materia : materias) {
      System.out.print(contador + "- " + materia.nome + "\n");
      contador++;
    }
  }

  public static void listarMateriasDetalhado() {
    int contador = 1;
    System.out.print("\n\n" + """
    +-----------------------------------+
    |         LISTA DE MATÉRIAS         |
    +-----------------------------------+
    """);
    for (Materia materia : materias) {
      int contador1 = 1;
      System.out.print(contador + "- " + materia.nome + " - Curso: " + materia.curso.nome + " - Professor: " + materia.professor.nome + ".\n");
      System.out.print("LISTA DE ALUNOS: \n");
      for (Aluno aluno : materia.alunosMateria) {
        System.out.print("  " + contador1 + "- " + aluno.nome + "\n");
        contador1++;
      }
      System.out.println();
      contador++;
    }
  }
}
