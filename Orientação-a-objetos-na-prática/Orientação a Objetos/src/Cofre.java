import java.util.Scanner;

abstract class Cofre {
  protected String tipo;
  protected String metodoAbertura;

  public Cofre(String tipo, String metodoAbertura) {
    this.tipo = tipo;
    this.metodoAbertura = metodoAbertura;
  }

  public void imprimirInformacoes() {
    System.out.println("Tipo: " + this.tipo);
    System.out.println("Metodo de abertura: " + this.metodoAbertura);
  }
}

class CofreDigital extends Cofre {
  private int senha;

  public CofreDigital(int senha) {
    super("Cofre Digital", "Senha");
    this.senha = senha;
  }

  public boolean validarSenha(int confirmacaoSenha) {
    return confirmacaoSenha == this.senha;
  }
}

class CofreFisico extends Cofre {
  public CofreFisico() {
    super("Cofre Fisico", "Chave");
  }
}
//A parte faltante está abaixo
public class Desafio {
  public static void main(String[] args) {
    // Lê o tipo de cofre (primeira linha da entrada)
    Scanner scanner = new Scanner(System.in);
    String tipoCofre = scanner.nextLine();
    
    if (tipoCofre.equalsIgnoreCase("digital")) {
      // Lê a senha do cofre digital
      int senha = scanner.nextInt();
      CofreDigital cofreDigital = new CofreDigital(senha);

      // Exibe as informações do cofre digital
      cofreDigital.imprimirInformacoes();

      // Lê a senha de confirmação
      int confirmacaoSenha = scanner.nextInt();

      // Verifica a senha
      if (cofreDigital.validarSenha(confirmacaoSenha)) {
        System.out.println("Cofre aberto!");
      } else {
        System.out.println("Senha incorreta!");
      }
    } else if (tipoCofre.equalsIgnoreCase("fisico")) {
      CofreFisico cofreFisico = new CofreFisico();

      // Exibe as informações do cofre físico
      cofreFisico.imprimirInformacoes();
    } else {
      System.out.println("Tipo de cofre desconhecido.");
    }

    // Fechar o scanner para evitar vazamentos de recursos
    scanner.close();
  }
}