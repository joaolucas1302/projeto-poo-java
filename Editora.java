
public class Editora extends Entidade {
    private String ednome;
    private String edsigla;
    private String edcbservacoes;

    
    public Editora(int edid, String ednome, String edsigla, String edcbservacoes) {
        super(edid);
        setEdnome(ednome);
        setEdsigla(edsigla);
        setEdcbservacoes(edcbservacoes);
    }

   
    public Editora(int edid, String ednome, String edsigla) {
        this(edid, ednome, edsigla, "");
    }

    public Editora(String ednome, String edsigla) {
        this(0, ednome, edsigla, "");
    }

    
    public Editora(String ednome, String edsigla, String edcbservacoes) {
        this(0, ednome, edsigla, edcbservacoes);
    }

    public int getEdid() {
        return getCodigo();
    }

    public void setEdid(int edid) {
        setCodigo(edid);
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
        return "[" + getCodigo() + "] " + ednome + " (" + edsigla + ")" + 
               (edcbservacoes.isEmpty() ? "" : " - " + edcbservacoes);
    }
}
