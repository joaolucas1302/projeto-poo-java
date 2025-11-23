import java.util.List;
import java.util.Scanner;

public class MenuAutores {
    private final AutorBanco banco;
    private final Scanner scanner;

    public MenuAutores(Scanner scanner) {
        this.banco = new AutorBanco();
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n========== MENU DE AUTORES ==========");
            System.out.println("1 - Inserir Autor");
            System.out.println("2 - Alterar Autor");
            System.out.println("3 - Excluir Autor");
            System.out.println("4 - Pesquisar por ID");
            System.out.println("5 - Imprimir Todos");
            System.out.println("6 - Obter Numero de Itens");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.println("=====================================");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInt();

            switch (opcao) {
                case 1: inserir(); break;
                case 2: alterar(); break;
                case 3: excluir(); break;
                case 4: pesquisar(); break;
                case 5: imprimirTodos(); break;
                case 6: obterNumeroItens(); break;
                case 0: System.out.println("Voltando..."); break;
                default: System.out.println("[ERRO] Opcao invalida!");
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
            System.out.println("\n--- INSERIR AUTOR ---");
            System.out.println("[INFO] O codigo sera gerado automaticamente.");
            System.out.print("Nome (min 3 chars): ");
            String nome = scanner.nextLine();
            System.out.print("Pseudonimo (opcional): ");
            String pseudonimo = scanner.nextLine();
            System.out.print("Observacoes (opcional): ");
            String obs = scanner.nextLine();

            Autor autor = new Autor(nome, pseudonimo);
            autor.setAutobservacoes(obs);
            
            if (banco.adicionarComCodigoAutomatico(autor)) {
                System.out.println("[OK] Autor inserido: " + autor);
            } else {
                System.out.println("[ERRO] Nao foi possivel inserir!");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERRO] " + ex.getMessage());
        }
    }

    private void alterar() {
        System.out.println("\n--- ALTERAR AUTOR ---");
        System.out.print("ID do autor: ");
        int autid = lerInt();
        
        Autor autorAtual = banco.pesquisar(autid);
        if (autorAtual == null) {
            System.out.println("[ERRO] Autor nao encontrado!");
            return;
        }

        System.out.println("Autor atual: " + autorAtual);
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo pseudonimo: ");
        String pseudonimo = scanner.nextLine();
        System.out.print("Novas observacoes: ");
        String obs = scanner.nextLine();

        if (banco.alterar(autid, nome, pseudonimo, obs)) {
            System.out.println("[OK] Autor alterado com sucesso!");
        } else {
            System.out.println("[ERRO] Dados invalidos!");
        }
    }

    private void excluir() {
        System.out.println("\n--- EXCLUIR AUTOR ---");
        System.out.print("ID do autor: ");
        int autid = lerInt();

        if (banco.remover(autid)) {
            System.out.println("[OK] Autor excluido!");
        } else {
            System.out.println("[ERRO] Autor nao encontrado!");
        }
    }

    private void pesquisar() {
        System.out.println("\n--- PESQUISAR AUTOR ---");
        System.out.print("ID: ");
        int autid = lerInt();
        Autor autor = banco.pesquisar(autid);
        if (autor != null) {
            System.out.println("[ENCONTRADO] " + autor);
        } else {
            System.out.println("[NAO ENCONTRADO]");
        }
    }

    private void imprimirTodos() {
        System.out.println("\n--- TODOS OS AUTORES ---");
        List<Autor> lista = banco.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
            return;
        }
        System.out.println("Total: " + lista.size() + " autor(es)");
        System.out.println("----------------------------");
        for (Autor autor : lista) {
            System.out.println(autor);
        }
        System.out.println("----------------------------");
    }

    private void obterNumeroItens() {
        int totalAtual = banco.contar();
        int totalAdicionados = banco.contadorRegistrosAdicionados();
        System.out.println("\n========== CONTADOR DE REGISTROS ==========");
        System.out.println("[INFO] Total de autores cadastrados: " + totalAtual);
        System.out.println("[INFO] Total de registros adicionados: " + totalAdicionados);
        System.out.println("==========================================");
    }
}
