import java.util.List;
import java.util.Scanner;

public class MenuEditoras {
    private final EditoraBanco banco;
    private final Scanner scanner;

    public MenuEditoras(Scanner scanner) {
        this.banco = new EditoraBanco();
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n========== MENU DE EDITORAS ==========");
            System.out.println("1 - Inserir Editora");
            System.out.println("2 - Alterar Descricao");
            System.out.println("3 - Excluir Editora");
            System.out.println("4 - Pesquisar por Codigo");
            System.out.println("5 - Imprimir Todas");
            System.out.println("6 - Obter Numero de Itens");
            System.out.println("0 - Voltar ao Menu Principal");
            System.out.println("======================================");
            System.out.print("Escolha uma opcao: ");

            opcao = lerInt();

            switch (opcao) {
                case 1: inserir(); break;
                case 2: alterar(); break;
                case 3: excluir(); break;
                case 4: pesquisar(); break;
                case 5: imprimirTodas(); break;
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
            System.out.println("\n--- INSERIR EDITORA ---");
            System.out.println("[INFO] O codigo sera gerado automaticamente.");
            System.out.print("Nome (min 3 chars): ");
            String nome = scanner.nextLine();
            System.out.print("Sigla (min 2 chars): ");
            String sigla = scanner.nextLine();
            System.out.print("Observacoes (opcional): ");
            String obs = scanner.nextLine();
            
            Editora e = new Editora(nome, sigla, obs);
            if (banco.adicionarComCodigoAutomatico(e)) {
                System.out.println("[OK] " + e);
            } else {
                System.out.println("[ERRO] Nao foi possivel inserir!");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("[ERRO] " + ex.getMessage());
        }
    }

    private void alterar() {
        System.out.println("\n--- ALTERAR EDITORA ---");
        System.out.print("ID: ");
        int edid = lerInt();
        
        Editora atual = banco.pesquisar(edid);
        if (atual == null) {
            System.out.println("[ERRO] Editora nao encontrada!");
            return;
        }
        
        System.out.println("Editora atual: " + atual);
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova sigla: ");
        String sigla = scanner.nextLine();
        System.out.print("Novas observacoes: ");
        String obs = scanner.nextLine();
        
        if (banco.alterar(edid, nome, sigla, obs)) System.out.println("[OK] Alterado!");
        else System.out.println("[ERRO] Dados invalidos!");
    }

    private void excluir() {
        System.out.println("\n--- EXCLUIR EDITORA ---");
        System.out.print("ID: ");
        int edid = lerInt();
        if (banco.remover(edid)) System.out.println("[OK] Removido!");
        else System.out.println("[ERRO] Nao encontrado!");
    }

    private void pesquisar() {
        System.out.println("\n--- PESQUISAR EDITORA ---");
        System.out.print("ID: ");
        int edid = lerInt();
        Editora e = banco.pesquisar(edid);
        if (e != null) System.out.println("[ENCONTRADO] " + e);
        else System.out.println("[NAO ENCONTRADO]");
    }

    private void imprimirTodas() {
        System.out.println("\n--- TODAS ---");
        List<Editora> lista = banco.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma editora cadastrada.");
            return;
        }
        for (Editora e : lista) System.out.println(e);
    }

    private void obterNumeroItens() {
        int totalAtual = banco.contar();
        int totalAdicionados = banco.contadorRegistrosAdicionados();
        System.out.println("\n========== CONTADOR DE REGISTROS ==========");
        System.out.println("[INFO] Total de editoras cadastradas: " + totalAtual);
        System.out.println("[INFO] Total de registros adicionados: " + totalAdicionados);
        System.out.println("==========================================");
    }
}
