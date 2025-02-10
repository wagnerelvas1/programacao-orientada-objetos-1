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

    System.out.print("Duração (em períodos): ");
    int duracao = ler.nextInt();
    
    System.out.print("\nTurnos:\n1- Matutino\n2- Vespertino\n3- Noturno\n4- Integral\nInsira o número do turno: ");
    int option = ler.nextInt();

    switch (option) {
      case 1: turno = "Matutino";
        break;

      case 2: turno = "Vespertino";
        break;

      case 3: turno = "Noturno";
        break;

      case 4: turno = "Integral";
        break;

    }

    Curso curso = new Curso(nome, duracao, turno);
    Lista.cursos.add(curso);
  }

  public static void cadastrarCurso(String nome, int duracao, String turno) {
    Curso curso = new Curso(nome, duracao, turno);
    Lista.cursos.add(curso);
  }

  public static void excluirCurso() {
    Scanner ler = new Scanner(System.in);
    Lista.listarCursos();

    System.out.print("\nInsira o número do curso a ser excluído: ");    
    int option = ler.nextInt();

    Curso curso = Lista.cursos.get(option-1);

    System.out.print("Para confirmar a exclusão de " + curso.nome + ", insira 'EXCLUIR': ");
    ler.nextLine();
    String confirmar = ler.nextLine();
    
    if(confirmar.equals("EXCLUIR")) {
      Lista.cursos.remove(option-1);
    }
  }
}
