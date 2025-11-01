public class AutorLivro {
    private int livid;  // FK para Livro
    private int autid;  // FK para Autor

    public AutorLivro(int livid, int autid) {
        setLivid(livid);
        setAutid(autid);
    }

    public int getLivid() {
        return livid;
    }

    public void setLivid(int livid) {
        if (livid <= 0) {
            throw new IllegalArgumentException("ID do livro deve ser maior que zero.");
        }
        this.livid = livid;
    }

    public int getAutid() {
        return autid;
    }

    public void setAutid(int autid) {
        if (autid <= 0) {
            throw new IllegalArgumentException("ID do autor deve ser maior que zero.");
        }
        this.autid = autid;
    }

    @Override
    public String toString() {
        return "Livro[" + livid + "] <-> Autor[" + autid + "]";
    }
}
