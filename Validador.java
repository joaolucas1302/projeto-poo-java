
public final class Validador {
    

    private Validador() {
        throw new UnsupportedOperationException("Classe utilitária não deve ser instanciada");
    }
    

    public static boolean validarId(int id) {
        return id > 0;
    }
    

    public static boolean validarId(int id, int min, int max) {
        return id >= min && id <= max;
    }
    

    public static boolean validarNome(String nome) {
        return validarNome(nome, 3);
    }
    

    public static boolean validarNome(String nome, int tamanhoMinimo) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }
        return nome.trim().length() >= tamanhoMinimo;
    }
    

    public static String formatarTexto(String texto) {
        if (texto == null) return "";
        return texto.trim();
    }
    

    public static String formatarTexto(String texto, boolean uppercase) {
        String resultado = formatarTexto(texto);
        return uppercase ? resultado.toUpperCase() : resultado;
    }
    

    public static boolean validarAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        return ano > 1000 && ano <= anoAtual;
    }
    

    public static boolean validarAno(int ano, int anoMinimo, int anoMaximo) {
        return ano >= anoMinimo && ano <= anoMaximo;
    }
    

    public static boolean validarISBN(int isbn) {
        return isbn > 0;
    }
    

    public static boolean validarISBN(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) return false;
        String limpo = isbn.replaceAll("[^0-9]", "");
        return limpo.length() == 10 || limpo.length() == 13;
    }
}
