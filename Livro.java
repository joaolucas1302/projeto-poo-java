public class Livro {
    private int livid;
    private String livnome;
    private int livanopubli;
    private int livisbn;
    private String livobservacoes;
    private int edid; // Foreign Key para Editora

    public Livro(int livid, String livnome, int livanopubli, int livisbn, String livobservacoes, int edid) {
        setLivid(livid);
        setLivnome(livnome);
        setLivanopubli(livanopubli);
        setLivisbn(livisbn);
        setLivobservacoes(livobservacoes);
        setEdid(edid);
    }

    public int getLivid() {
        return livid;
    }

    public void setLivid(int livid) {
        if (livid <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        this.livid = livid;
    }

    public String getLivnome() {
        return livnome;
    }

    public void setLivnome(String livnome) {
        if (livnome == null || livnome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome invalido: minimo 3 caracteres.");
        }
        this.livnome = livnome.trim();
    }

    public int getLivanopubli() {
        return livanopubli;
    }

    public void setLivanopubli(int livanopubli) {
        if (livanopubli <= 0) {
            throw new IllegalArgumentException("Ano de publicacao deve ser maior que zero.");
        }
        this.livanopubli = livanopubli;
    }

    public int getLivisbn() {
        return livisbn;
    }

    public void setLivisbn(int livisbn) {
        if (livisbn <= 0) {
            throw new IllegalArgumentException("ISBN deve ser maior que zero.");
        }
        this.livisbn = livisbn;
    }

    public String getLivobservacoes() {
        return livobservacoes;
    }

    public void setLivobservacoes(String livobservacoes) {
        if (livobservacoes == null) {
            livobservacoes = "";
        }
        this.livobservacoes = livobservacoes.trim();
    }

    public int getEdid() {
        return edid;
    }

    public void setEdid(int edid) {
        if (edid <= 0) {
            throw new IllegalArgumentException("ID da editora deve ser maior que zero.");
        }
        this.edid = edid;
    }

    @Override
    public String toString() {
        return "[ID:" + livid + "] " + livnome + " (Ano: " + livanopubli + ", ISBN: " + livisbn + 
               ", Ed:" + edid + (livobservacoes.isEmpty() ? "" : ", Obs: " + livobservacoes) + ")";
    }
}
