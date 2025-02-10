import java.util.ArrayList;
import java.util.Scanner;

public class Materia {
  public String nome;
  public Curso curso;
  public Professor professor;
  public ArrayList<Aluno> alunosMateria = new ArrayList<>();

  public Materia(String nome, Curso curso, Professor professor, ArrayList<Aluno> alunos) {
    this.nome = nome;
    this.curso = curso;
    this.professor = professor;
    for(Aluno aluno : alunos) {
      this.alunosMateria.add(aluno);
    }
  }

  public static void cadastrarMateria() {                 // Juro que foi o único lugar que usamos chat (e foi só um pouco)
    Scanner ler = new Scanner(System.in);
    System.out.print("\n\n" + """
    +-----------------------------------+
    |        CADASTRO DE MATERIA        |
    +-----------------------------------+
    """);

    System.out.print("Nome: ");
    String nome = ler.nextLine();

    Lista.listarProfessores();
    System.out.print("Insira o número do professor da matéria: ");
    int option = ler.nextInt();
    Professor professor = Lista.professores.get(option-1);

    Lista.listarCursos();
    System.out.print("Insira o número do curso da matéria: ");
    option = ler.nextInt();
    Curso curso = Lista.cursos.get(option-1);

    ArrayList<Aluno> alunosSelecionados = new ArrayList<>();
    ArrayList<Aluno> listaAlunos = Lista.listarAlunosPorCurso(curso);
    System.out.print("Insira os números dos alunos da matéria\n(Ex: 1 2 3): ");
    ler.nextLine();
    String options = ler.nextLine();
    String[] numeros = options.split(" ");

    for(String indice : numeros) {
      int index = Integer.parseInt(indice) - 1;
      Aluno x = listaAlunos.get(index);
      alunosSelecionados.add(x);
    }

    Materia materia = new Materia(nome, curso, professor, alunosSelecionados);
    Lista.materias.add(materia);
  }

  public static void cadastrarMateria(String nome, Curso curso, Professor professor, ArrayList<Aluno> alunos) {
    Materia materia = new Materia(nome, curso, professor, alunos);
    Lista.materias.add(materia);
  }

  public static void excluirMateria() {
    Scanner ler = new Scanner(System.in);
    Lista.listarMaterias();

    System.out.print("\nInsira o número da matéria a ser excluída: ");    
    int option = ler.nextInt();

    Materia materia = Lista.materias.get(option-1);

    System.out.print("Para confirmar a exclusão de " + materia.nome + ", insira 'EXCLUIR': ");
    ler.nextLine();
    String confirmar = ler.nextLine();

    if(confirmar.equals("EXCLUIR")) {
      Lista.materias.remove(option-1);
    }
  }
}
