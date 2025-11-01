public class Autor {
    private int autid;
    private String autnome;
    private String autpseudomo;
    private String autobservacoes;

    public Autor(int autid, String autnome, String autpseudomo, String autobservacoes) {
        setAutid(autid);
        setAutnome(autnome);
        setAutpseudomo(autpseudomo);
        setAutobservacoes(autobservacoes);
    }

    public int getAutid() {
        return autid;
    }

    public void setAutid(int autid) {
        if (autid <= 0) {
            throw new IllegalArgumentException("ID deve ser maior que zero.");
        }
        this.autid = autid;
    }

    public String getAutnome() {
        return autnome;
    }

    public void setAutnome(String autnome) {
        if (autnome == null || autnome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome invalido: minimo 3 caracteres.");
        }
        this.autnome = autnome.trim();
    }

    public String getAutpseudomo() {
        return autpseudomo;
    }

    public void setAutpseudomo(String autpseudomo) {
        if (autpseudomo == null) {
            autpseudomo = "";
        }
        this.autpseudomo = autpseudomo.trim();
    }

    public String getAutobservacoes() {
        return autobservacoes;
    }

    public void setAutobservacoes(String autobservacoes) {
        if (autobservacoes == null) {
            autobservacoes = "";
        }
        this.autobservacoes = autobservacoes.trim();
    }

    @Override
    public String toString() {
        String pseudonimo = autpseudomo.isEmpty() ? "" : " (Pseudonimo: " + autpseudomo + ")";
        String obs = autobservacoes.isEmpty() ? "" : " - " + autobservacoes;
        return "[" + autid + "] " + autnome + pseudonimo + obs;
    }
}
