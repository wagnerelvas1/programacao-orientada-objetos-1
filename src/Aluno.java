import java.util.Scanner;

public class Aluno extends Pessoa {
  public Curso curso;

  public Aluno(String nome, int idade, Curso curso) {
    super(nome, idade);
    this.curso = curso;
  }

  public static void cadastrarAluno() {
    Scanner ler = new Scanner(System.in);
    System.out.print("\n\n" + """
    +-----------------------------------+
    |         CADASTRO DE ALUNO         |
    +-----------------------------------+
    """);
    
    System.out.print("Nome: ");
    String nome = ler.nextLine();

    System.out.print("Idade: ");
    int idade = ler.nextInt();

    Lista.listarCursos();
    System.out.print("Insira o número do curso desejado: ");
    int option = ler.nextInt();

    Curso curso = Lista.cursos.get(option-1);
    
    Aluno aluno = new Aluno(nome, idade, curso);
    Lista.alunos.add(aluno);
  }

  public static void cadastrarAluno(String nome, int idade, Curso curso) {
    Aluno aluno = new Aluno(nome, idade, curso);
    Lista.alunos.add(aluno);
  }

  public static void excluirAluno() {
    Scanner ler = new Scanner(System.in);
    Lista.listarAlunosDetalhado();

    System.out.print("\nInsira o número do aluno a ser excluído: ");    
    int option = ler.nextInt();

    Aluno aluno = Lista.alunos.get(option-1);

    System.out.print("Para confirmar a exclusão de " + aluno.nome + ", insira 'EXCLUIR': ");
    ler.nextLine();
    String confirmar = ler.nextLine();

    if(confirmar.equals("EXCLUIR")) {
      Lista.alunos.remove(option-1);
    }
  }
}
