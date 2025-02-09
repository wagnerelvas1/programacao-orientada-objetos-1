import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
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

    Aluno.cadastrarAluno("Wagner", 10, Lista.cursos.get(0));
    Aluno.cadastrarAluno("Ana", 15, Lista.cursos.get(1));
    Aluno.cadastrarAluno("Joseph", 20, Lista.cursos.get(2));

    while(true) {
      System.out.print("\n\n"+menu);
      int entrada = input.nextInt();

      if(entrada == 0) {
        break;
      }

      if(menu == menus[0]) {
        switch(entrada) {
          case 1: menu = menus[1]; break;
          case 2: menu = menus[2]; break;
          case 3: menu = menus[3]; break;
          case 4: menu =  menus[4]; break;
        }
      } else {
        if(entrada == 9) {
          menu = menus[0];
        }

        if(menu == menus[1]) {
          switch(entrada) {
            case 1: Lista.listarAlunosDetalhado();
              break;

            case 2: Aluno.cadastrarAluno();
              break;
              
            case 3: Aluno.excluirAluno();
              break;
              
          }
        } else if(menu == menus[2]) {
          switch(entrada) {
            case 1: Lista.listarProfessoresDetalhado();
              break;

            case 2: Professor.cadastrarProfessor();
              break;
              
            case 3: Professor.excluirProfessor();
              break;
    
          }
        } else if(menu == menus[3]) {
          switch(entrada) {
            case 1:
              break;
            case 2:
              break;
              
            case 3:
              break;
              
            case 4:
              break;
              
          }
        } else if(menu == menus[4]) {
          switch(entrada) {
            case 1: Lista.listarCursosDetalhado();
              break;

            case 2: Curso.cadastrarCurso();
              break;
    
            case 3: Curso.excluirCurso();
              break;
              
          }
        }
      }
    }
  }
}
