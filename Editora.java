public class Editora {
    private int edid;
    private String ednome;
    private String edsigla;
    private String edcbservacoes;

    public Editora(int edid, String ednome, String edsigla, String edcbservacoes) {
        setEdid(edid);
        setEdnome(ednome);
        setEdsigla(edsigla);
        setEdcbservacoes(edcbservacoes);
    }

    public int getEdid() {
        return edid;
    }

    public void setEdid(int edid) {
        if (edid <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        this.edid = edid;
    }

    public String getEdnome() {
        return ednome;
    }

    public void setEdnome(String ednome) {
        if (ednome == null || ednome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome invalido: minimo 3 caracteres.");
        }
        this.ednome = ednome.trim();
    }

    public String getEdsigla() {
        return edsigla;
    }

    public void setEdsigla(String edsigla) {
        if (edsigla == null || edsigla.trim().length() < 2) {
            throw new IllegalArgumentException("Sigla invalida: minimo 2 caracteres.");
        }
        this.edsigla = edsigla.trim();
    }

    public String getEdcbservacoes() {
        return edcbservacoes;
    }

    public void setEdcbservacoes(String edcbservacoes) {
        if (edcbservacoes == null) {
            edcbservacoes = "";
        }
        this.edcbservacoes = edcbservacoes.trim();
    }

    @Override
    public String toString() {
        return "[" + edid + "] " + ednome + " (" + edsigla + ")" + 
               (edcbservacoes.isEmpty() ? "" : " - " + edcbservacoes);
    }
}
