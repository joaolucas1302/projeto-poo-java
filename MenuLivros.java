import java.util.Scanner;
import java.util.List;

public class MenuLivros {
    private Scanner scanner;
    private LivroBanco livroBanco;

    public MenuLivros(Scanner scanner) {
        this.scanner = scanner;
        this.livroBanco = new LivroBanco();
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n========== MENU DE LIVROS ==========");
            System.out.println("1 - Inserir Livro");
            System.out.println("2 - Alterar Livro");
            System.out.println("3 - Excluir Livro");
            System.out.println("4 - Pesquisar Livro");
            System.out.println("5 - Imprimir Todos");
            System.out.println("6 - Obter Numero de Itens");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.println("====================================");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInt();

            switch (opcao) {
                case 1:
                    inserir();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    pesquisar();
                    break;
                case 5:
                    imprimirTodos();
                    break;
                case 6:
                    obterNumeroItens();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("[ERRO] Opcao invalida!");
            }
        } while (opcao != 0);
    }

    private int lerInt() {
        try {
            int v = scanner.nextInt();
            scanner.nextLine();
            return v;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private void inserir() {
        try {
            System.out.println("\n--- INSERIR LIVRO ---");
            System.out.print("ID (>0): ");
            int livid = lerInt();
            System.out.print("Nome (min 3 chars): ");
            String nome = scanner.nextLine();
            System.out.print("Ano de Publicacao (>0): ");
            int ano = lerInt();
            System.out.print("ISBN (>0): ");
            int isbn = lerInt();
            System.out.print("ID da Editora (>0): ");
            int edid = lerInt();
            System.out.print("Observacoes (opcional): ");
            String obs = scanner.nextLine();

            Livro livro = new Livro(livid, nome, ano, isbn, obs, edid);
            if (livroBanco.adicionar(livro)) {
                System.out.println("[OK] Livro inserido: " + livro);
            } else {
                System.out.println("[ERRO] ID ja existe!");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERRO] " + ex.getMessage());
        }
    }

    private void alterar() {
        System.out.println("\n--- ALTERAR LIVRO ---");
        System.out.print("ID do livro: ");
        int livid = lerInt();
        
        Livro livroAtual = livroBanco.pesquisar(livid);
        if (livroAtual == null) {
            System.out.println("[ERRO] Livro nao encontrado!");
            return;
        }

        System.out.println("Livro atual: " + livroAtual);
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo ano de publicacao: ");
        int ano = lerInt();
        System.out.print("Novo ISBN: ");
        int isbn = lerInt();
        System.out.print("Novas observacoes: ");
        String obs = scanner.nextLine();
        System.out.print("Novo ID da Editora: ");
        int edid = lerInt();

        if (livroBanco.alterar(livid, nome, ano, isbn, obs, edid)) {
            System.out.println("[OK] Livro alterado com sucesso!");
        } else {
            System.out.println("[ERRO] Dados invalidos!");
        }
    }

    private void excluir() {
        System.out.println("\n--- EXCLUIR LIVRO ---");
        System.out.print("ID do livro: ");
        int livid = lerInt();

        if (livroBanco.remover(livid)) {
            System.out.println("[OK] Livro excluido!");
        } else {
            System.out.println("[ERRO] Livro nao encontrado!");
        }
    }

    private void pesquisar() {
        System.out.println("\n--- PESQUISAR LIVRO ---");
        System.out.print("ID: ");
        int livid = lerInt();
        Livro livro = livroBanco.pesquisar(livid);
        if (livro != null) {
            System.out.println("[ENCONTRADO] " + livro);
        } else {
            System.out.println("[NAO ENCONTRADO]");
        }
    }

    private void imprimirTodos() {
        System.out.println("\n--- TODOS OS LIVROS ---");
        List<Livro> lista = livroBanco.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("Total: " + lista.size() + " livro(s)");
        System.out.println("----------------------------");
        for (Livro livro : lista) {
            System.out.println(livro);
        }
        System.out.println("----------------------------");
    }

    private void obterNumeroItens() {
        System.out.println("\n[INFO] Total de livros cadastrados: " + livroBanco.contar());
    }
}
