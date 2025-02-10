import java.util.ArrayList;
import java.util.InputMismatchException;
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

  public static void cadastrarMateria() {
    Scanner ler = new Scanner(System.in);
    String nome = "";
    System.out.print("\n\n" + """
    +-----------------------------------+
    |        CADASTRO DE MATERIA        |
    +-----------------------------------+
    """);

    System.out.print("Nome: ");
    nome = ler.nextLine();

    Professor professor = null;
    boolean professorValido = false;
    while(!professorValido) {
      Lista.listarProfessores();
      System.out.print("Insira o número do professor da matéria: ");
      try {
        int option = ler.nextInt();
        professor = Lista.professores.get(option-1);
        professorValido = true;
      } catch (InputMismatchException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um número!\n");
      } catch (IndexOutOfBoundsException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um valor válido!\n");
      }
    }

    Curso curso = null;
    boolean cursoValido = false;
    while(!cursoValido) {
      Lista.listarCursos();
      System.out.print("Insira o número do curso da matéria: ");
      try {
        int option = ler.nextInt();
        curso = Lista.cursos.get(option-1);
        cursoValido = true;
      } catch (InputMismatchException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um número!\n");
      } catch (IndexOutOfBoundsException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um valor válido!\n");
      }
    }

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
    System.out.println("\nA matéria '" + materia.nome + "' do curso de " + materia.curso.nome + " foi cadastrada!");
  }

  public static void cadastrarMateria(String nome, Curso curso, Professor professor, ArrayList<Aluno> alunos) {
    Materia materia = new Materia(nome, curso, professor, alunos);
    Lista.materias.add(materia);
  }

  public static void excluirMateria() {
    Scanner ler = new Scanner(System.in);
    int option = 0;
    Materia materia = null;
    boolean optionValida = false;
    
    while(!optionValida) {
      Lista.listarMaterias();
      System.out.print("\nInsira o número da matéria a ser excluída: ");
      try {
        option = ler.nextInt();
        materia = Lista.materias.get(option-1);
        optionValida = true;
      } catch (InputMismatchException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um número!\n");
      } catch (IndexOutOfBoundsException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um valor válido!\n");
      }
    }

    System.out.print("Para confirmar a exclusão de '" + materia.nome + "', insira 'EXCLUIR': ");
    ler.nextLine();
    String confirmar = ler.nextLine();

    if(confirmar.equals("EXCLUIR")) {
      System.out.println("\nA matéria '" + materia.nome + "' foi excluída!");
      Lista.materias.remove(option-1);
    } else {
      System.out.println("\nA matéria '" + materia.nome + "' não foi excluída!");
    }
  }
}
