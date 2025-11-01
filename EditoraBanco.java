/**
 * Classe "banco" que armazena e gerencia as editoras
 */
public class EditoraBanco extends BancoBase<Editora> {

    @Override
    protected boolean existe(Editora e) {
        return pesquisar(e.getEdid()) != null;
    }

    public boolean alterar(int edid, String novoNome, String novaSigla, String novasObservacoes) {
        Editora e = pesquisar(edid);
        if (e == null) return false;
        try {
            e.setEdnome(novoNome);
            e.setEdsigla(novaSigla);
            e.setEdcbservacoes(novasObservacoes);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    public boolean remover(int edid) {
        return super.remover(e -> e.getEdid() == edid);
    }

    public Editora pesquisar(int edid) {
        return super.pesquisar(e -> e.getEdid() == edid);
    }
}
