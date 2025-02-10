import java.util.Scanner;

public class Professor extends Pessoa {
  public String formacao;
  public float salario;

  public Professor(String nome, int idade, String formacao, float salario) {
    super(nome, idade);
    this.formacao = formacao;
    this.salario = salario;
  }

  public static void cadastrarProfessor() {
    Scanner ler = new Scanner(System.in);
    System.out.print("\n\n" + """
    +-----------------------------------+
    |       CADASTRO DE PROFESSOR       |
    +-----------------------------------+
    """);
    
    System.out.print("Nome: ");
    String nome = ler.nextLine();

    System.out.print("Idade: ");
    int idade = ler.nextInt();

    System.out.print("Formação: ");
    ler.nextLine();
    String formacao = ler.nextLine();

    System.out.print("Salário: ");
    float salario = ler.nextFloat();

    Professor professor = new Professor(nome, idade, formacao, salario);
    Lista.professores.add(professor);
  }

  public static void cadastrarProfessor(String nome, int idade, String formacao, float salario) {
    Professor professor = new Professor(nome, idade, formacao, salario);
    Lista.professores.add(professor);
  }

  public static void excluirProfessor() {
    Scanner ler = new Scanner(System.in);
    Lista.listarProfessores();

    System.out.print("\nInsira o número do professor a ser excluído: ");    
    int option = ler.nextInt();

    Professor professor = Lista.professores.get(option-1);

    System.out.print("Para confirmar a exclusão de " + professor.nome + ", insira 'EXCLUIR': ");
    ler.nextLine();
    String confirmar = ler.nextLine();

    if(confirmar.equals("EXCLUIR")) {
      Lista.professores.remove(option-1);
    }
  }
}
