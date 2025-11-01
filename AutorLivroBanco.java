import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AutorLivroBanco {
    private final List<AutorLivro> lista;

    public AutorLivroBanco() {
        this.lista = new ArrayList<>();
    }

    public boolean adicionar(AutorLivro autorLivro) {
        if (autorLivro == null) return false;
        // Verifica se o relacionamento já existe
        if (relacionamentoExiste(autorLivro.getLivid(), autorLivro.getAutid())) {
            return false;
        }
        lista.add(autorLivro);
        return true;
    }

    public boolean adicionar(int livid, int autid) {
        try {
            AutorLivro al = new AutorLivro(livid, autid);
            return adicionar(al);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public boolean remover(int livid, int autid) {
        Iterator<AutorLivro> it = lista.iterator();
        while (it.hasNext()) {
            AutorLivro al = it.next();
            if (al.getLivid() == livid && al.getAutid() == autid) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removerPorLivro(int livid) {
        boolean removido = false;
        Iterator<AutorLivro> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getLivid() == livid) {
                it.remove();
                removido = true;
            }
        }
        return removido;
    }

    public boolean removerPorAutor(int autid) {
        boolean removido = false;
        Iterator<AutorLivro> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getAutid() == autid) {
                it.remove();
                removido = true;
            }
        }
        return removido;
    }

    public List<Integer> obterAutoresPorLivro(int livid) {
        List<Integer> autores = new ArrayList<>();
        for (AutorLivro al : lista) {
            if (al.getLivid() == livid) {
                autores.add(al.getAutid());
            }
        }
        return autores;
    }

    public List<Integer> obterLivrosPorAutor(int autid) {
        List<Integer> livros = new ArrayList<>();
        for (AutorLivro al : lista) {
            if (al.getAutid() == autid) {
                livros.add(al.getLivid());
            }
        }
        return livros;
    }

    public boolean relacionamentoExiste(int livid, int autid) {
        for (AutorLivro al : lista) {
            if (al.getLivid() == livid && al.getAutid() == autid) {
                return true;
            }
        }
        return false;
    }

    public List<AutorLivro> listarTodos() {
        return new ArrayList<>(lista);
    }

    public int contar() {
        return lista.size();
    }
}
