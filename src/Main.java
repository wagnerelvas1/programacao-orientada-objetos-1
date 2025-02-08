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

    while(true) {
      System.out.print(menu);
      int entrada = ler.nextInt();

      if(entrada == 0) {
        break;
      }

      if(menu == menus[0]) {
        menu = menus[entrada];
      } else {
        if(entrada == 9) {
            menu = menus[0];
        }
      }
    }
  }
}
