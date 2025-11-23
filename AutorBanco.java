public class AutorBanco extends BancoBase<Autor> {

    public AutorBanco() {
        super("autores.dat");
    }

    @Override
    protected boolean existe(Autor autor) {
        return pesquisar(autor.getAutid()) != null;
    }

    public boolean alterar(int autid, String novoNome, String novoPseudonimo, String novasObservacoes) {
        Autor autor = pesquisar(autid);
        if (autor == null) return false;
        try {
            autor.setAutnome(novoNome);
            autor.setAutpseudomo(novoPseudonimo);
            autor.setAutobservacoes(novasObservacoes);
            notificarAlteracao();
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public boolean remover(int autid) {
        return super.remover(a -> a.getAutid() == autid);
    }

    public Autor pesquisar(int autid) {
        return super.pesquisar(a -> a.getAutid() == autid);
    }
}
