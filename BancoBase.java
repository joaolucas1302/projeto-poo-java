import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;


public abstract class BancoBase<T extends Entidade> {
    protected final List<T> lista;
    private final String arquivoDados;
    private int contadorRegistros; 

    
    public BancoBase() {
        this.lista = new ArrayList<>();
        this.arquivoDados = null;
        this.contadorRegistros = 0;
    }

    
    public BancoBase(String arquivoDados) {
        this.lista = new ArrayList<>();
        this.arquivoDados = arquivoDados;
        this.contadorRegistros = 0;
        carregarSilencioso();
    }

    
    public boolean adicionar(T entidade) {
        if (entidade == null) return false;
        if (existe(entidade)) return false;
        lista.add(entidade);
        contadorRegistros++;
        salvarSilencioso();
        return true;
    }

    
    public boolean adicionarComCodigoAutomatico(T entidade) {
        if (entidade == null) return false;
        
        int novoCodigo = gerarProximoCodigo();
        entidade.setCodigo(novoCodigo);
        
        if (existe(entidade)) return false;
        lista.add(entidade);
        contadorRegistros++;
        salvarSilencioso();
        return true;
    }

    
    protected int gerarProximoCodigo() {
        if (lista.isEmpty()) {
            return 1;
        }
        
        int maxCodigo = 0;
        for (T entidade : lista) {
            if (entidade.getCodigo() > maxCodigo) {
                maxCodigo = entidade.getCodigo();
            }
        }
        return maxCodigo + 1;
    }

    
    public boolean remover(Predicate<T> criterio) {
        Iterator<T> it = lista.iterator();
        while (it.hasNext()) {
            if (criterio.test(it.next())) {
                it.remove();
                contadorRegistros--;
                salvarSilencioso();
                return true;
            }
        }
        return false;
    }

   
    public T pesquisar(Predicate<T> criterio) {
        for (T entidade : lista) {
            if (criterio.test(entidade)) {
                return entidade;
            }
        }
        return null;
    }


    public List<T> listarTodos() {
        return new ArrayList<>(lista);
    }


    public int contar() {
        return lista.size();
    }

    
    public int contadorRegistrosAdicionados() {
        return contadorRegistros;
    }

  
    protected abstract boolean existe(T entidade);


    protected void notificarAlteracao() {
        salvarSilencioso();
    }

    private void salvarSilencioso() {
        if (arquivoDados == null) return;
        try {
            File dir = new File("data");
            if (!dir.exists()) dir.mkdirs();
            try (FileOutputStream fos = new FileOutputStream(new File(dir, arquivoDados));
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(new ArrayList<>(lista));
            }
        } catch (Exception ignored) {
        }
    }

    @SuppressWarnings("unchecked")
    private void carregarSilencioso() {
        if (arquivoDados == null) return;
        File arq = new File("data", arquivoDados);
        if (!arq.exists()) return;
        try (FileInputStream fis = new FileInputStream(arq);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                lista.clear();
                for (Object o : (List<?>) obj) {
                    lista.add((T) o);
                }
            }
        } catch (Exception ignored) {
        }
    }
}
