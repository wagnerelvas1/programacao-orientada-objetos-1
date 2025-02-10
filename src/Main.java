import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner ler = new Scanner(System.in);
    String menuInicial = """
    +-----------------------------------+
    |           MENU INICIAL            |
    +-----------------------------------+
    | 1- Gerenciar Alunos               |
    | 2- Gerenciar Professores          |
    | 3- Gerenciar Matérias             |
    | 4- Gerenciar Cursos               |
    |                                   |
    | 0- Sair                           |
    +-----------------------------------+
    Insira o número da opção desejada""" + "\n-> ";

    String menuAlunos = """
    +-----------------------------------+
    |      GERENCIAMENTO DE ALUNOS      |
    +-----------------------------------+
    | 1- Listar Alunos                  |
    | 2- Cadastrar Aluno                |
    | 3- Excluir Aluno                  |
    |                                   |
    | 9- Voltar                         |
    | 0- Sair                           |
    +-----------------------------------+
    Insira o número da opção desejada""" + "\n-> ";

    String menuProfessores = """
    +-----------------------------------+
    |   GERENCIAMENTO DE PROFESSORES    |
    +-----------------------------------+
    | 1- Listar Professores             |
    | 2- Cadastrar Professor            |
    | 3- Excluir Professor              |
    |                                   |
    | 9- Voltar                         |
    | 0- Sair                           |
    +-----------------------------------+
    Insira o número da opção desejada""" + "\n-> ";

    String menuMaterias = """
    +-----------------------------------+
    |     GERENCIAMENTO DE MATÉRIAS     |
    +-----------------------------------+
    | 1- Listar Matérias                |
    | 2- Cadastrar Matéria              |
    | 3- Excluir Matéria                |
    |                                   |
    | 9- Voltar                         |
    | 0- Sair                           |
    +-----------------------------------+
    Insira o número da opção desejada""" + "\n-> ";
    
    String menuCursos = """
    +-----------------------------------+
    |      GERENCIAMENTO DE CURSOS      |
    +-----------------------------------+
    | 1- Listar Cursos                  |
    | 2- Cadastrar Curso                |
    | 3- Excluir Curso                  |
    |                                   |
    | 9- Voltar                         |
    | 0- Sair                           |
    +-----------------------------------+
    Insira o número da opção desejada""" + "\n-> ";

    String[] menus = {menuInicial, menuAlunos, menuProfessores, menuMaterias, menuCursos};
    String menu = menus[0];

    Curso.cadastrarCurso("Análise e Desenvolvimento de Sistemas", 6, "Noturno");
    Curso.cadastrarCurso("Engenharia Civil", 10, "Integral");
    Curso.cadastrarCurso("Engenharia de Controle e Automação", 10, "Integral");

    Aluno.cadastrarAluno("Wagner", 18, Lista.cursos.get(0));
    Aluno.cadastrarAluno("Robert", 15, Lista.cursos.get(0));
    Aluno.cadastrarAluno("João", 20, Lista.cursos.get(0));
    Aluno.cadastrarAluno("Pedro", 18, Lista.cursos.get(1));
    Aluno.cadastrarAluno("Matheus", 15, Lista.cursos.get(1));
    Aluno.cadastrarAluno("José", 20, Lista.cursos.get(2));

    Professor.cadastrarProfessor("Leandro", 90, "Engenheiro de Alguma Coisa", 900000);
    Professor.cadastrarProfessor("Willians", 88, "Engenheiro de Outra Coisa", 1000000);

    String[] alunos = {"1", "2", "3"};
    Materia.cadastrarMateria("Programação Orientada a Objetos", Lista.cursos.get(0), Lista.professores.get(0), alunos);

    while(true) {
      System.out.print("\n\n"+menu);
      int entrada = ler.nextInt();

      if(entrada == 0) {
        break;
      }

      if(menu == menus[0]) {
        switch(entrada) {
          case 1: menu = menus[1]; break;
          case 2: menu = menus[2]; break;
          case 3: menu = menus[3]; break;
          case 4: menu =  menus[4]; break;
          default: System.out.println("\n\nPor favor, insira uma opção válida!"); break;
        }
      } else {
        if(entrada == 9) {
          menu = menus[0];
        }

        if(menu == menus[1]) {
          switch(entrada) {
            case 1: Lista.listarAlunosDetalhado(); break;
            case 2: Aluno.cadastrarAluno(); break;
            case 3: Aluno.excluirAluno(); break;
            default: System.out.println("\n\nPor favor, insira uma opção válida!"); break;
          }
        } else if(menu == menus[2]) {
          switch(entrada) {
            case 1: Lista.listarProfessoresDetalhado(); break;
            case 2: Professor.cadastrarProfessor(); break;
            case 3: Professor.excluirProfessor(); break;
            default: System.out.println("\n\nPor favor, insira uma opção válida!"); break;
          }
        } else if(menu == menus[3]) {
          switch(entrada) {
            case 1: Lista.listarMateriasDetalhado(); break;
            case 2: Materia.cadastrarMateria(); break;
            case 3: Materia.excluirMateria(); break;
            default: System.out.println("\n\nPor favor, insira uma opção válida!"); break;
              
          }
        } else if(menu == menus[4]) {
          switch(entrada) {
            case 1: Lista.listarCursosDetalhado(); break;
            case 2: Curso.cadastrarCurso(); break;
            case 3: Curso.excluirCurso(); break;
            default: System.out.println("\n\nPor favor, insira uma opção válida!"); break;
          }
        }
      }
    }
  }
}
