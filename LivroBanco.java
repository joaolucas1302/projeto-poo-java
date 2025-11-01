public class LivroBanco extends BancoBase<Livro> {

    @Override
    protected boolean existe(Livro l) {
        return pesquisar(l.getLivid()) != null;
    }
    
    public boolean alterar(int livid, String novoNome, int novoAnoPubli, int novoLivIsbn, String novasObservacoes, int novoEdid) {
        Livro l = pesquisar(livid);
        if (l == null) return false;
        try {
            l.setLivnome(novoNome);
            l.setLivanopubli(novoAnoPubli);
            l.setLivisbn(novoLivIsbn);
            l.setLivobservacoes(novasObservacoes);
            l.setEdid(novoEdid);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public boolean remover(int livid) {
        return super.remover(l -> l.getLivid() == livid);
    }

    public Livro pesquisar(int livid) {
        return super.pesquisar(l -> l.getLivid() == livid);
    }
}