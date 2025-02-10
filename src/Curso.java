import java.util.InputMismatchException;
import java.util.Scanner;

public class Curso {
  public String nome;
  public int duracao;
  public String turno;

  public Curso(String nome, int duracao, String turno) {
    this.nome = nome;
    this.duracao = duracao;
    this.turno = turno;
  }

  public static void cadastrarCurso() {
    Scanner ler = new Scanner(System.in);
    String turno = "";
    System.out.print("\n\n" + """
    +-----------------------------------+
    |         CADASTRO DE CURSO         |
    +-----------------------------------+
    """);

    System.out.print("Nome: ");
    String nome = ler.nextLine();

    int duracao = 0;
    boolean duracaoValida = false;
    while(!duracaoValida) {
      System.out.print("Duração (em períodos): ");
      try {
        duracao = ler.nextInt();
        duracaoValida = true;
      } catch (InputMismatchException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um número!\n");
      }
    }

    int option = 0;
    boolean turnoValido = false;
    while(!turnoValido) {
      System.out.print("Turnos:\n1- Matutino\n2- Vespertino\n3- Noturno\n4- Integral\nInsira o número do turno: ");
      try {
        option = ler.nextInt();
        switch (option) {
          case 1: turno = "Matutino"; turnoValido = true;  break;
          case 2: turno = "Vespertino"; turnoValido = true; break;
          case 3: turno = "Noturno"; turnoValido = true; break;
          case 4: turno = "Integral"; turnoValido = true; break;
          default: 
            ler.nextLine();
            System.out.print("\nPor favor, insira um valor válido!\n"); 
            break;
        }
      } catch (InputMismatchException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um número!\n");
      }
    }


    Curso curso = new Curso(nome, duracao, turno);
    Lista.cursos.add(curso);
    System.out.println("\nO curso '" + curso.nome + "' foi cadastrado!");
  }

  public static void cadastrarCurso(String nome, int duracao, String turno) {
    Curso curso = new Curso(nome, duracao, turno);
    Lista.cursos.add(curso);
  }

  public static void excluirCurso() {
    Scanner ler = new Scanner(System.in);
    int option = 0;
    Curso curso = null;
    boolean optionValida = false;
    
    while(!optionValida) {
      Lista.listarCursos();
      System.out.print("Insira o número do curso a ser excluído: ");
      try {
        option = ler.nextInt();
        curso = Lista.cursos.get(option-1);
        optionValida = true;
      } catch (InputMismatchException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um número!\n");
      } catch (IndexOutOfBoundsException e) {
        ler.nextLine();
        System.out.print("\nPor favor, insira um valor válido!\n");
      }
    }

    System.out.print("Para confirmar a exclusão de '" + curso.nome + "', insira 'EXCLUIR': ");
    ler.nextLine();
    String confirmar = ler.nextLine();
    
    if(confirmar.equals("EXCLUIR")) {
      System.out.println("\nO curso '" + curso.nome + "' foi excluído!");
      Lista.cursos.remove(option-1);
    } else {
      System.out.println("\nO curso '" + curso.nome + "' não foi excluído!");
    }
  }
}
