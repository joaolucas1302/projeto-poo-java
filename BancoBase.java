import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Classe base genérica para gerenciamento de entidades em memória.
 * Implementa operações CRUD básicas que podem ser herdadas por classes específicas.
 * @param <T> Tipo da entidade gerenciada
 */
public abstract class BancoBase<T> {
    protected final List<T> lista;

    public BancoBase() {
        this.lista = new ArrayList<>();
    }

    /**
     * Adiciona uma entidade ao banco
     * @param entidade Entidade a ser adicionada
     * @return true se adicionado com sucesso, false caso contrário
     */
    public boolean adicionar(T entidade) {
        if (entidade == null) return false;
        if (existe(entidade)) return false;
        lista.add(entidade);
        return true;
    }

    /**
     * Remove uma entidade do banco baseado em um critério
     * @param criterio Predicate que define o critério de remoção
     * @return true se removido com sucesso, false caso contrário
     */
    public boolean remover(Predicate<T> criterio) {
        Iterator<T> it = lista.iterator();
        while (it.hasNext()) {
            if (criterio.test(it.next())) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Pesquisa uma entidade baseado em um critério
     * @param criterio Predicate que define o critério de busca
     * @return Entidade encontrada ou null
     */
    public T pesquisar(Predicate<T> criterio) {
        for (T entidade : lista) {
            if (criterio.test(entidade)) {
                return entidade;
            }
        }
        return null;
    }

    /**
     * Retorna uma cópia da lista de todas as entidades
     * @return Lista com todas as entidades
     */
    public List<T> listarTodos() {
        return new ArrayList<>(lista);
    }

    /**
     * Retorna a quantidade de entidades cadastradas
     * @return Número de entidades
     */
    public int contar() {
        return lista.size();
    }

    /**
     * Verifica se a entidade já existe no banco
     * Deve ser implementado pelas classes filhas
     * @param entidade Entidade a ser verificada
     * @return true se existe, false caso contrário
     */
    protected abstract boolean existe(T entidade);
}
