/**
 * Classe Autor - Representa um autor no sistema
 * Conceitos POO: Herança (extends Entidade), Encapsulamento, Sobrecarga de Métodos
 */
public class Autor extends Entidade {
    private String autnome;
    private String autpseudomo;
    private String autobservacoes;

    /**
     * Construtor completo - Sobrecarga de Métodos
     */
    public Autor(int autid, String autnome, String autpseudomo, String autobservacoes) {
        super(autid);
        setAutnome(autnome);
        setAutpseudomo(autpseudomo);
        setAutobservacoes(autobservacoes);
    }

    /**
     * Construtor simplificado - Sobrecarga de Métodos
     */
    public Autor(int autid, String autnome) {
        this(autid, autnome, "", "");
    }

    /**
     * Construtor apenas com nome (ID será gerado automaticamente)
     * Sobrecarga de Métodos
     */
    public Autor(String autnome) {
        this(0, autnome, "", "");
    }

    /**
     * Construtor com nome e pseudônimo - Sobrecarga de Métodos
     */
    public Autor(String autnome, String autpseudomo) {
        this(0, autnome, autpseudomo, "");
    }

    public int getAutid() {
        return getCodigo();
    }

    public void setAutid(int autid) {
        setCodigo(autid);
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

    /**
     * Sobrescrição do método toString (Override)
     */
    @Override
    public String toString() {
        String pseudonimo = autpseudomo.isEmpty() ? "" : " (Pseudonimo: " + autpseudomo + ")";
        String obs = autobservacoes.isEmpty() ? "" : " - " + autobservacoes;
        return "[" + getCodigo() + "] " + autnome + pseudonimo + obs;
    }
}
