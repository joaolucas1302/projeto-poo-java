# Documentação dos Conceitos de POO Implementados

## ✅ Checklist de Requisitos Atendidos

### Estrutura e Organização
- ✅ **Separação clara das entidades/classes de acordo com as responsabilidades**
  - `Entidade`: Classe base abstrata para todas as entidades
  - `Autor`, `Editora`, `Livro`: Entidades do domínio
  - `AutorBanco`, `EditoraBanco`, `LivroBanco`: Bancos de dados específicos
  - `BancoBase`: Classe base para operações CRUD
  - `MenuAutores`, `MenuEditoras`, `MenuLivros`: Interfaces de usuário
  - `Validador`: Classe utilitária para validações
  - `Main`: Ponto de entrada do sistema

### CRUDs Completos
- ✅ **3 CRUDs completos implementados:**
  1. **CRUD de Autores** (`AutorBanco` + `MenuAutores`)
     - Create (adicionar)
     - Read (pesquisar, listarTodos)
     - Update (alterar)
     - Delete (remover)
  
  2. **CRUD de Editoras** (`EditoraBanco` + `MenuEditoras`)
     - Create (adicionar)
     - Read (pesquisar, listarTodos)
     - Update (alterar)
     - Delete (remover)
  
  3. **CRUD de Livros** (`LivroBanco` + `MenuLivros`)
     - Create (adicionar)
     - Read (pesquisar, listarTodos)
     - Update (alterar)
     - Delete (remover)

---

## 📚 Conceitos POO Implementados

### 1. ✅ Classe Base
**Arquivo:** `Entidade.java`

A classe `Entidade` serve como base para todas as entidades do sistema:

```java
public abstract class Entidade implements Serializable {
    private int codigo;
    
    protected Entidade(int codigo) {
        setCodigo(codigo);
    }
    
    public int getCodigo() { return codigo; }
    protected void setCodigo(int codigo) { ... }
}
```

**Responsabilidades:**
- Gerenciar o código único de cada entidade
- Fornecer estrutura comum (código, equals, hashCode)
- Servir como base para herança

---

### 2. ✅ Herança
**Arquivos:** `Autor.java`, `Editora.java`, `Livro.java`

Todas as entidades herdam de `Entidade`:

```java
public class Autor extends Entidade { ... }
public class Editora extends Entidade { ... }
public class Livro extends Entidade { ... }
```

**Benefícios:**
- Reutilização de código (código único)
- Polimorfismo (todas as entidades podem ser tratadas como `Entidade`)
- Hierarquia clara de classes

**Hierarquia de Bancos:**
```java
public class AutorBanco extends BancoBase<Autor> { ... }
public class EditoraBanco extends BancoBase<Editora> { ... }
public class LivroBanco extends BancoBase<Livro> { ... }
```

---

### 3. ✅ Encapsulamento
**Presente em todas as classes de entidade**

Todos os atributos são privados com getters e setters:

```java
public class Autor extends Entidade {
    private String autnome;           // Privado
    private String autpseudomo;       // Privado
    private String autobservacoes;    // Privado
    
    // Getters e setters públicos com validação
    public String getAutnome() { return autnome; }
    public void setAutnome(String autnome) {
        if (autnome == null || autnome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome inválido: mínimo 3 caracteres.");
        }
        this.autnome = autnome.trim();
    }
}
```

**Benefícios:**
- Proteção de dados
- Validação centralizada
- Controle de acesso

---

### 4. ✅ Sobrecarga de Métodos
**Arquivos:** `Autor.java`, `Editora.java`, `Livro.java`, `Validador.java`

#### Exemplo em Autor:
```java
// Construtor completo
public Autor(int autid, String autnome, String autpseudomo, String autobservacoes) { ... }

// Construtor simplificado
public Autor(int autid, String autnome) {
    this(autid, autnome, "", "");
}

// Construtor apenas com nome (ID automático)
public Autor(String autnome) {
    this(0, autnome, "", "");
}

// Construtor com nome e pseudônimo
public Autor(String autnome, String autpseudomo) {
    this(0, autnome, autpseudomo, "");
}
```

#### Exemplo em Validador:
```java
// Validação simples de nome
public static boolean validarNome(String nome) {
    return validarNome(nome, 3);
}

// Validação com tamanho mínimo customizado
public static boolean validarNome(String nome, int tamanhoMinimo) { ... }

// Formatação simples
public static String formatarTexto(String texto) { ... }

// Formatação com uppercase
public static String formatarTexto(String texto, boolean uppercase) { ... }

// Validação simples de ID
public static boolean validarId(int id) { ... }

// Validação de ID com range
public static boolean validarId(int id, int min, int max) { ... }
```

---

### 5. ✅ Classes Estáticas
**Arquivo:** `Validador.java`

Classe utilitária com métodos estáticos e construtor privado:

```java
public final class Validador {
    
    // Construtor privado - não pode ser instanciada
    private Validador() {
        throw new UnsupportedOperationException("Classe utilitária não deve ser instanciada");
    }
    
    // Todos os métodos são estáticos
    public static boolean validarId(int id) { ... }
    public static boolean validarNome(String nome) { ... }
    public static String formatarTexto(String texto) { ... }
    public static boolean validarAno(int ano) { ... }
    public static boolean validarISBN(int isbn) { ... }
}
```

**Características:**
- Classe `final` (não pode ser herdada)
- Construtor privado (não pode ser instanciada)
- Apenas métodos estáticos
- Uso: `Validador.validarNome("João")`

---

### 6. ✅ Classes Abstratas
**Arquivos:** `BancoBase.java`, `Entidade.java`

#### Classe Entidade:
```java
public abstract class Entidade implements Serializable {
    private int codigo;
    
    protected Entidade(int codigo) { ... }
    
    // Método abstrato que deve ser implementado pelas subclasses
    @Override
    public abstract String toString();
}
```

#### Classe BancoBase:
```java
public abstract class BancoBase<T extends Entidade> {
    protected final List<T> lista;
    
    // Método abstrato que deve ser implementado pelas subclasses
    protected abstract boolean existe(T entidade);
    
    // Métodos concretos compartilhados
    public boolean adicionar(T entidade) { ... }
    public boolean remover(Predicate<T> criterio) { ... }
    public List<T> listarTodos() { ... }
}
```

**Características:**
- Não podem ser instanciadas diretamente
- Podem ter métodos abstratos e concretos
- Fornecem estrutura comum para subclasses

---

### 7. ✅ Sobrescrição de Métodos (Override)
**Presente em várias classes**

#### Em Entidades (toString, equals, hashCode):
```java
// Autor.java
@Override
public String toString() {
    String pseudonimo = autpseudomo.isEmpty() ? "" : " (Pseudonimo: " + autpseudomo + ")";
    String obs = autobservacoes.isEmpty() ? "" : " - " + autobservacoes;
    return "[" + getCodigo() + "] " + autnome + pseudonimo + obs;
}

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
```

#### Em Bancos (existe):
```java
// AutorBanco.java
@Override
protected boolean existe(Autor autor) {
    return pesquisar(autor.getAutid()) != null;
}

// EditoraBanco.java
@Override
protected boolean existe(Editora e) {
    return pesquisar(e.getEdid()) != null;
}

// LivroBanco.java
@Override
protected boolean existe(Livro l) {
    return pesquisar(l.getLivid()) != null;
}
```

---

## 🎯 Regras Especiais Implementadas

### 1. ✅ GERAÇÃO AUTOMÁTICA DE CÓDIGO
**Implementação:** `BancoBase.java`

```java
/**
 * Adiciona uma entidade gerando código automático
 * GERAÇÃO AUTOMÁTICA DE CÓDIGO
 */
public boolean adicionarComCodigoAutomatico(T entidade) {
    if (entidade == null) return false;
    
    // Gera código automático
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
```

**Uso nos Menus:**
```java
// MenuAutores.java
Autor autor = new Autor(nome, pseudonimo);
banco.adicionarComCodigoAutomatico(autor);  // ID gerado automaticamente
```

---

### 2. ✅ CONTADOR DE REGISTROS
**Implementação:** `BancoBase.java`

```java
private int contadorRegistros;  // Contador de registros adicionados

public boolean adicionarComCodigoAutomatico(T entidade) {
    // ...
    contadorRegistros++;  // Incrementa ao adicionar
    // ...
}

public boolean remover(Predicate<T> criterio) {
    // ...
    contadorRegistros--;  // Decrementa ao remover
    // ...
}

public int contadorRegistrosAdicionados() {
    return contadorRegistros;
}

public int contar() {
    return lista.size();  // Total atual
}
```

**Uso nos Menus:**
```java
// MenuAutores.java
private void obterNumeroItens() {
    int totalAtual = banco.contar();
    int totalAdicionados = banco.contadorRegistrosAdicionados();
    System.out.println("Total de autores cadastrados: " + totalAtual);
    System.out.println("Total de registros adicionados: " + totalAdicionados);
}
```

---

### 3. ✅ IMPRIMIR TODOS REGISTROS
**Implementação em todos os menus**

#### MenuAutores:
```java
private void imprimirTodos() {
    System.out.println("\n--- TODOS OS AUTORES ---");
    List<Autor> lista = banco.listarTodos();
    if (lista.isEmpty()) {
        System.out.println("Nenhum autor cadastrado.");
        return;
    }
    System.out.println("Total: " + lista.size() + " autor(es)");
    for (Autor autor : lista) {
        System.out.println(autor);
    }
}
```

#### MenuEditoras:
```java
private void imprimirTodas() {
    System.out.println("\n--- TODAS ---");
    List<Editora> lista = banco.listarTodos();
    if (lista.isEmpty()) {
        System.out.println("Nenhuma editora cadastrada.");
        return;
    }
    for (Editora e : lista) {
        System.out.println(e);
    }
}
```

#### MenuLivros:
```java
private void imprimirTodos() {
    System.out.println("\n--- TODOS OS LIVROS ---");
    List<Livro> lista = livroBanco.listarTodos();
    if (lista.isEmpty()) {
        System.out.println("Nenhum livro cadastrado.");
        return;
    }
    System.out.println("Total: " + lista.size() + " livro(s)");
    for (Livro livro : lista) {
        System.out.println(livro);
    }
}
```

---

## 📊 Resumo Final

### Conceitos POO ✅
1. ✅ **Classe Base** - `Entidade`
2. ✅ **Herança** - Todas as entidades herdam de `Entidade`
3. ✅ **Encapsulamento** - Atributos privados com getters/setters
4. ✅ **Sobrecarga de Métodos** - Múltiplos construtores e métodos em `Validador`
5. ✅ **Classes Estáticas** - `Validador` (final, construtor privado, métodos estáticos)
6. ✅ **Classes Abstratas** - `Entidade` e `BancoBase`
7. ✅ **Sobrescrição de Métodos** - toString, equals, hashCode, existe

### Regras Especiais ✅
1. ✅ **Geração Automática de Código** - Implementada em `BancoBase`
2. ✅ **Contador de Registros** - Implementado em `BancoBase`
3. ✅ **Imprimir Todos Registros** - Implementado em todos os menus

### CRUDs Completos ✅
1. ✅ **Autores** - Create, Read, Update, Delete
2. ✅ **Editoras** - Create, Read, Update, Delete
3. ✅ **Livros** - Create, Read, Update, Delete

---

## 🎓 Conclusão

O projeto atende **TODOS** os requisitos solicitados de POO:
- ✅ Separação clara de responsabilidades
- ✅ 3 CRUDs completos
- ✅ Todos os 7 conceitos POO implementados
- ✅ Todas as 3 regras especiais implementadas
- ✅ Código bem documentado e organizado
