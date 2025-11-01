import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("========================================");
        System.out.println("  SISTEMA DE GESTAO COMPLETO");
        System.out.println("  Editoras | Livros | Autores");
        System.out.println("========================================");

        do {
            System.out.println("\n========================================");
            System.out.println("          MENU PRINCIPAL");
            System.out.println("========================================");
            System.out.println("1 - Gerenciar Editoras");
            System.out.println("2 - Gerenciar Livros");
            System.out.println("3 - Gerenciar Autores");
            System.out.println("0 - Sair do Sistema");
            System.out.println("========================================");
            System.out.print("Escolha uma opcao: ");

            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    MenuEditoras menuEditoras = new MenuEditoras(scanner);
                    menuEditoras.exibirMenu();
                    break;
                case 2:
                    MenuLivros menuLivros = new MenuLivros(scanner);
                    menuLivros.exibirMenu();
                    break;
                case 3:
                    MenuAutores menuAutores = new MenuAutores(scanner);
                    menuAutores.exibirMenu();
                    break;
                case 0:
                    System.out.println("\n========================================");
                    System.out.println("  Obrigado por usar o sistema!");
                    System.out.println("  Encerrando...");
                    System.out.println("========================================");
                    break;
                default:
                    System.out.println("\n[ERRO] Opcao invalida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static int lerOpcao(Scanner scanner) {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
}
