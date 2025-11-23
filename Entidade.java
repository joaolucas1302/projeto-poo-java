import java.io.Serializable;


public abstract class Entidade implements Serializable {
    private int codigo;


    protected Entidade(int codigo) {
        setCodigo(codigo);
    }


    public int getCodigo() {
        return codigo;
    }

    protected void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código deve ser maior que zero.");
        }
        this.codigo = codigo;
    }

    @Override
    public abstract String toString();


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entidade entidade = (Entidade) obj;
        return codigo == entidade.codigo;
    }

    
    @Override
    public int hashCode() {
        return Integer.hashCode(codigo);
    }
}
