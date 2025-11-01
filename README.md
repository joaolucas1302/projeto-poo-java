# 📚 Sistema de Gerenciamento de Editoras, Livros e Autores# 📚 Sistema de Gestão - Editoras, Livros e Autores



[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)> Trabalho Acadêmico de Programação Orientada a Objetos (POO)

[![POO](https://img.shields.io/badge/Paradigma-POO-blue.svg)](https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_orientada_a_objetos)

[![Status](https://img.shields.io/badge/Status-Concluído-green.svg)]()Sistema completo desenvolvido em Java para gerenciamento de **Editoras**, **Livros** e **Autores**, implementando CRUD completo com relacionamentos entre entidades, validações de dados e arquitetura orientada a objetos com herança e genéricos.

[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)



> Sistema acadêmico completo de gerenciamento de editoras, livros e autores com relacionamentos 1:N e N:N, implementado em Java puro com princípios de Programação Orientada a Objetos.## 📋 Índice



---- [Sobre o Projeto](#sobre-o-projeto)

- [Modelo de Dados](#modelo-de-dados)

## 📋 Índice- [Estrutura do Projeto](#estrutura-do-projeto)

- [Conceitos de POO Aplicados](#conceitos-de-poo-aplicados)

- [Sobre o Projeto](#-sobre-o-projeto)- [Funcionalidades](#funcionalidades)

- [Modelo de Dados](#-modelo-de-dados)- [Validações Implementadas](#validações-implementadas)

- [Estrutura do Projeto](#-estrutura-do-projeto)- [Como Executar](#como-executar)

- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)- [Exemplos de Uso](#exemplos-de-uso)

- [Funcionalidades](#-funcionalidades)- [Tecnologias Utilizadas](#tecnologias-utilizadas)

- [Validações Implementadas](#-validações-implementadas)- [Autor](#autor)

- [Como Executar](#-como-executar)

- [Exemplos de Uso](#-exemplos-de-uso)---

- [Tecnologias Utilizadas](#-tecnologias-utilizadas)

- [Métricas do Projeto](#-métricas-do-projeto)## 🎯 Sobre o Projeto

- [Conceitos Acadêmicos](#-conceitos-acadêmicos)

- [Melhorias Futuras](#-melhorias-futuras)Este projeto foi desenvolvido como trabalho acadêmico da disciplina de **Programação Orientada a Objetos**, com o objetivo de aplicar na prática os principais conceitos de POO:

- [Autor](#-autor)

- [Licença](#-licença)- ✅ **Encapsulamento** - Atributos privados com getters/setters validados

- ✅ **Herança** - Classe base genérica `BancoBase<T>` para reutilização de código

---- ✅ **Polimorfismo** - Uso de generics e métodos abstratos

- ✅ **Abstração** - Separação clara entre Model, Data e View

## 🎯 Sobre o Projeto- ✅ **Validação de Dados** - Regras de negócio implementadas nas entidades

- ✅ **Relacionamentos** - Implementação de FK (1:N) e tabela associativa (N:N)

Este projeto é um **trabalho acadêmico** desenvolvido para demonstrar a aplicação prática de conceitos de **Programação Orientada a Objetos (POO)** em Java. O sistema implementa um CRUD completo para gerenciamento de:

### 📊 Modelo de Dados

- **Editoras** (tbleditoras)

- **Livros** (tblivros) O sistema implementa o seguinte modelo relacional:

- **Autores** (tblautores)

- **Relacionamento Autor-Livro** (tblautoreslivros)```

┌─────────────────────┐       ┌──────────────────────┐       ┌──────────────────────┐       ┌─────────────────────┐

### ✨ Diferenciais Técnicos│   tbleditoras       │       │     tblivros         │       │  tblautoreslivros    │       │    tblautores       │

├─────────────────────┤       ├──────────────────────┤       ├──────────────────────┤       ├─────────────────────┤

- ✅ **Arquitetura em 3 camadas** (Modelo, Dados, Visão)│ *PK edid: int       │◄──────│ *PK livid: int       │◄──────│ *PK livid: int       │──────►│ *PK autid: int      │

- ✅ **Relacionamentos complexos**: 1:N (Editora→Livro) e N:N (Livro↔Autor)│     ednome: varchar │       │     livnome: varchar │       │ *PK autid: int       │       │     autnome: varchar│

- ✅ **Classe genérica base** (`BancoBase<T>`) aplicando **DRY** e **reuso de código**│     edsigla: varchar│       │  livanopubli: int    │       └──────────────────────┘       │  autpseudomo: var.. │

- ✅ **Uso de Generics, Lambdas e Predicates** (Java 8+)│  edcbservacoes: var.│       │     livisbn: int     │                                      │  autobservacoes: ..│

- ✅ **Validações robustas** em todas as camadas└─────────────────────┘       │ livobservacoes: var. │                                      └─────────────────────┘

- ✅ **Menus interativos** via terminal                              │ *FK edid: int        │

- ✅ **Armazenamento em memória** (ArrayList) para fins acadêmicos                              └──────────────────────┘



---Relacionamentos:

• Editora → Livro (1:N) - Uma editora publica vários livros

## 🗂️ Modelo de Dados• Livro ↔ Autor (N:N) - Um livro pode ter vários autores e um autor pode escrever vários livros

```

O sistema implementa o seguinte modelo relacional:

## 📂 Estrutura do Projeto

```

┌──────────────────┐           ┌──────────────────┐```

│   tbleditoras    │           │    tblivros      │projeto-poo-java/

├──────────────────┤           ├──────────────────┤│

│ edid (PK)        │───┐       │ livid (PK)       │├── 📄 Entidades (Model)

│ ednome           │   │       │ livnome          ││   ├── Editora.java          # Entidade Editora

│ edsigla          │   │       │ livanopubli      ││   ├── Livro.java             # Entidade Livro (com FK edid)

│ edcbservacoes    │   │       │ livisbn          ││   ├── Autor.java             # Entidade Autor

└──────────────────┘   │       │ livobservacoes   ││   └── AutorLivro.java        # Tabela associativa (N:N)

                       │       │ edid (FK)        │───────┐│

                       └───────│                  │       │├── 🗄️ Camada de Dados (Data/DAO)

                               └──────────────────┘       ││   ├── BancoBase.java         # ⭐ Classe base genérica (herança)

                                       │                  ││   ├── EditoraBanco.java      # CRUD de Editoras

                                       │ N:N              │ 1:N│   ├── LivroBanco.java        # CRUD de Livros

                                       │                  ││   ├── AutorBanco.java        # CRUD de Autores

                               ┌───────┴───────┐          ││   └── AutorLivroBanco.java   # Gerenciamento de relacionamentos

                               │               │          ││

                         ┌─────▼─────────────┐ │          │├── 🖥️ Interface (View)

                         │ tblautoreslivros  │ │          ││   ├── Main.java              # Menu principal

                         ├───────────────────┤ │          ││   ├── MenuEditoras.java      # Menu de Editoras

                         │ livid (FK, PK)    │─┘          ││   ├── MenuLivros.java        # Menu de Livros

                         │ autid (FK, PK)    │───┐        ││   └── MenuAutores.java       # Menu de Autores

                         └───────────────────┘   │        ││

                                                 │        │└── 📖 README.md               # Documentação

                               ┌─────────────────▼────────┘```

                               │

                         ┌─────▼────────────┐### 🏗️ Arquitetura em Camadas

                         │   tblautores     │

                         ├──────────────────┤O projeto segue uma **arquitetura em 3 camadas**:

                         │ autid (PK)       │

                         │ autnome          │1. **Camada de Modelo (Model)** - Entidades com validações

                         │ autpseudomo      │2. **Camada de Dados (Data/DAO)** - Gerenciamento de dados em memória

                         │ autobservacoes   │3. **Camada de Apresentação (View)** - Menus interativos CLI

                         └──────────────────┘

```---



### Relacionamentos:## 🔧 Conceitos de POO Aplicados

- **1:N** - Uma Editora possui vários Livros (edid)

- **N:N** - Livros podem ter múltiplos Autores e vice-versa (via tblautoreslivros)### 1️⃣ Herança e Generics



---```java

// Classe base genérica que elimina código duplicado

## 📁 Estrutura do Projetopublic abstract class BancoBase<T> {

    protected final List<T> lista;

```    

projeto-poo-java/    public boolean adicionar(T entidade) { ... }

├── Editora.java              # Classe modelo Editora    public boolean remover(Predicate<T> criterio) { ... }

├── Livro.java                # Classe modelo Livro    public T pesquisar(Predicate<T> criterio) { ... }

├── Autor.java                # Classe modelo Autor    // ... outros métodos comuns

├── AutorLivro.java           # Classe de relacionamento N:N    

├── BancoBase.java            # ⭐ Classe genérica abstrata (elimina duplicação)    protected abstract boolean existe(T entidade);

├── EditoraBanco.java         # Gerenciador CRUD de Editoras}

├── LivroBanco.java           # Gerenciador CRUD de Livros

├── AutorBanco.java           # Gerenciador CRUD de Autores// Implementação específica

├── AutorLivroBanco.java      # Gerenciador de relacionamentos N:Npublic class EditoraBanco extends BancoBase<Editora> {

├── MenuEditoras.java         # Menu interativo para Editoras    @Override

├── MenuLivros.java           # Menu interativo para Livros    protected boolean existe(Editora e) {

├── MenuAutores.java          # Menu interativo para Autores        return pesquisar(e.getEdid()) != null;

├── Main.java                 # ⭐ Ponto de entrada da aplicação    }

└── README.md                 # Este arquivo}

``````



**Total**: 13 classes | ~1.200 linhas de código**Vantagens:**

- ✅ ~105 linhas de código eliminadas

---- ✅ Manutenção centralizada

- ✅ Type-safe em compile-time

## 🎓 Conceitos de POO Aplicados- ✅ Fácil extensibilidade



### 1️⃣ **Encapsulamento**### 2️⃣ Encapsulamento com Validação

Todos os atributos são privados com getters/setters:

```java```java

public class Editora {public class Livro {

    private int edid;    private int livid;

    private String ednome;    private String livnome;

        // ... outros atributos

    public int getEdid() { return edid; }    

    public void setEdid(int edid) {    public void setLivid(int livid) {

        if (edid <= 0) throw new IllegalArgumentException("ID deve ser maior que 0");        if (livid <= 0) {

        this.edid = edid;            throw new IllegalArgumentException("ID deve ser maior que zero.");

    }        }

}        this.livid = livid;

```    }

}

### 2️⃣ **Herança e Abstração**```

Classe genérica base elimina ~105 linhas de código duplicado:

```java### 3️⃣ Uso de Lambdas e Predicates

public abstract class BancoBase<T> {

    protected ArrayList<T> itens = new ArrayList<>();```java

    // Busca elegante usando expressões lambda

    public boolean adicionar(T item) {public Editora pesquisar(int edid) {

        if (item != null && !existe(item)) {    return super.pesquisar(e -> e.getEdid() == edid);

            itens.add(item);}

            return true;```

        }

        return false;---

    }

    ## ⚙️ Funcionalidades

    public List<T> pesquisar(Predicate<T> criterio) {

        return itens.stream()### 📘 Gerenciamento de Editoras

            .filter(criterio)- ✅ Inserir nova editora

            .collect(Collectors.toList());- ✅ Alterar dados (nome, sigla, observações)

    }- ✅ Excluir editora

    - ✅ Pesquisar por ID

    protected abstract boolean existe(T item);- ✅ Listar todas as editoras

}- ✅ Obter total de editoras cadastradas

```

### 📕 Gerenciamento de Livros

**Implementação concreta**:- ✅ Inserir novo livro (com FK para editora)

```java- ✅ Alterar dados (nome, ano, ISBN, observações, editora)

public class EditoraBanco extends BancoBase<Editora> {- ✅ Excluir livro

    @Override- ✅ Pesquisar por ID

    protected boolean existe(Editora editora) {- ✅ Listar todos os livros

        return pesquisar(e -> e.getEdid() == editora.getEdid()).size() > 0;- ✅ Obter total de livros cadastrados

    }

}### 📗 Gerenciamento de Autores

```- ✅ Inserir novo autor

- ✅ Alterar dados (nome, pseudônimo, observações)

### 3️⃣ **Polimorfismo**- ✅ Excluir autor

Uso de lambdas e Predicates para buscas flexíveis:- ✅ Pesquisar por ID

```java- ✅ Listar todos os autores

// Buscar por ID- ✅ Obter total de autores cadastrados

Editora ed = editoraBanco.pesquisar(e -> e.getEdid() == 10).get(0);

### 🔗 Relacionamentos

// Buscar por nome- ✅ Associar autores a livros (N:N)

List<Editora> eds = editoraBanco.pesquisar(e -> e.getEdnome().contains("Atlas"));- ✅ Remover associações

```- ✅ Listar livros de um autor

- ✅ Listar autores de um livro

### 4️⃣ **Generics**

`BancoBase<T>` funciona com qualquer tipo:---

```java

EditoraBanco extends BancoBase<Editora>   // T = Editora## ✅ Validações Implementadas

LivroBanco extends BancoBase<Livro>       // T = Livro

AutorBanco extends BancoBase<Autor>       // T = Autor### Editora (tbleditoras)

```| Campo | Validação |

|-------|-----------|

---| `edid` | Deve ser > 0, único |

| `ednome` | Não nulo, mínimo 3 caracteres |

## ⚙️ Funcionalidades| `edsigla` | Não nulo, mínimo 2 caracteres |

| `edcbservacoes` | Opcional |

### 📌 Menu Principal

1. Gerenciar Editoras### Livro (tblivros)

2. Gerenciar Livros| Campo | Validação |

3. Gerenciar Autores|-------|-----------|

0. Sair| `livid` | Deve ser > 0, único |

| `livnome` | Não nulo, mínimo 3 caracteres |

### 📚 Operações de Cada Entidade (CRUD Completo)| `livanopubli` | Deve ser > 0 |

1. **Inserir** - Adiciona novo registro com validação| `livisbn` | Deve ser > 0 |

2. **Alterar** - Modifica registro existente| `edid` (FK) | Deve ser > 0, referencia editora existente |

3. **Excluir** - Remove registro por ID| `livobservacoes` | Opcional |

4. **Pesquisar** - Busca registro por ID

5. **Imprimir Todos** - Lista todos os registros### Autor (tblautores)

6. **Obter Número de Itens** - Conta registros cadastrados| Campo | Validação |

0. **Voltar** - Retorna ao menu principal|-------|-----------|

| `autid` | Deve ser > 0, único |

---| `autnome` | Não nulo, mínimo 3 caracteres |

| `autpseudomo` | Opcional |

## ✅ Validações Implementadas| `autobservacoes` | Opcional |



### Editora (tbleditoras)### AutorLivro (tblautoreslivros)

| Campo          | Validação                           || Campo | Validação |

|----------------|-------------------------------------||-------|-----------|

| `edid`         | Deve ser maior que 0                || `livid` (PK/FK) | Deve ser > 0, referencia livro existente |

| `ednome`       | Não pode ser null/vazio, min 3 chars|| `autid` (PK/FK) | Deve ser > 0, referencia autor existente |

| `edsigla`      | Não pode ser null/vazio, min 2 chars|| Relacionamento | Não permite duplicatas |

| `edcbservacoes`| Pode ser null                       |

---

### Livro (tblivros)

| Campo           | Validação                           |## 🚀 Como Executar

|-----------------|-------------------------------------|

| `livid`         | Deve ser maior que 0                |### Pré-requisitos

| `livnome`       | Não pode ser null/vazio, min 3 chars|- Java JDK 8 ou superior

| `livanopubli`   | Deve ser maior que 0                |- Terminal/Prompt de Comando

| `livisbn`       | Não pode ser null/vazio, min 3 chars|

| `livobservacoes`| Pode ser null                       |### Compilação

| `edid` (FK)     | Deve ser maior que 0 (referencia Editora) |

```powershell

### Autor (tblautores)# Compilar todos os arquivos

| Campo           | Validação                           |javac -encoding UTF-8 *.java

|-----------------|-------------------------------------|```

| `autid`         | Deve ser maior que 0                |

| `autnome`       | Não pode ser null/vazio, min 3 chars|### Execução

| `autpseudomo`   | Pode ser null/vazio                 |

| `autobservacoes`| Pode ser null                       |```powershell

# Executar o sistema

### AutorLivro (tblautoreslivros)java Main

| Campo       | Validação                |```

|-------------|--------------------------|

| `livid` (FK)| Deve ser maior que 0     |---

| `autid` (FK)| Deve ser maior que 0     |

| Duplicação  | Não permite relacionamento duplicado |

## � Tecnologias Utilizadas

---

- **Linguagem:** Java SE (Standard Edition)

## 🚀 Como Executar- **Paradigma:** Programação Orientada a Objetos (POO)

- **Estruturas de Dados:** ArrayList, Iterator

### Pré-requisitos- **Java Features:** Generics, Lambdas, Predicates, Streams

- Java JDK 8 ou superior instalado- **Padrões:** DAO (Data Access Object), Herança, Polimorfismo

- Terminal/Prompt de Comando- **Entrada/Saída:** Scanner (console)

- **Arquitetura:** 3 camadas (Model-Data-View)

### Passo a Passo

---

#### 1️⃣ Compilar todos os arquivos

```bash## 📊 Métricas do Projeto

javac -encoding UTF-8 *.java

```| Métrica | Quantidade |

|---------|------------|

#### 2️⃣ Executar o programa| Classes Total | 13 |

```bash| Classes de Entidade | 4 |

java Main| Classes DAO | 5 (incluindo base) |

```| Classes de Menu | 4 |

| Linhas de Código | ~1200 |

#### 3️⃣ Limpar arquivos compilados (opcional)| Operações CRUD | 18 (6 por entidade) |

```bash| Relacionamentos | 2 (1:N e N:N) |

# Windows PowerShell

Remove-Item *.class -Force---



# Linux/Mac## 🎓 Conceitos Acadêmicos Demonstrados

rm *.class

```### ✅ Programação Orientada a Objetos

- [x] Classes e Objetos

---- [x] Encapsulamento

- [x] Herança

## 💡 Exemplos de Uso- [x] Polimorfismo

- [x] Abstração

### Exemplo 1: Inserir Editora- [x] Composição

```

Menu Principal### ✅ Estruturas de Dados

1. Gerenciar Editoras- [x] ArrayList (listas dinâmicas)

2. Gerenciar Livros- [x] Generics (type safety)

3. Gerenciar Autores- [x] Iterator (percorrer coleções)

0. Sair

Escolha: 1### ✅ Boas Práticas

- [x] DRY (Don't Repeat Yourself)

--- Menu Editoras ---- [x] SOLID Principles

1. Inserir Editora- [x] Validação de dados

Escolha: 1- [x] Tratamento de exceções

- [x] Código limpo e legível

Digite o ID da editora: 1- [x] Documentação adequada

Digite o nome da editora: Editora Atlas

Digite a sigla da editora: EA### ✅ Modelagem de Dados

Digite as observações: Editora especializada em tecnologia- [x] Entidades e relacionamentos

✓ Editora inserida com sucesso!- [x] Chaves primárias (PK)

```- [x] Chaves estrangeiras (FK)

- [x] Relacionamento 1:N

### Exemplo 2: Inserir Livro com FK- [x] Relacionamento N:N (tabela associativa)

```

--- Menu Livros ------

1. Inserir Livro

Escolha: 1## 🔄 Possíveis Melhorias Futuras



Digite o ID do livro: 101- [ ] Persistência em banco de dados real (MySQL, PostgreSQL)

Digite o nome do livro: Java para Iniciantes- [ ] Interface gráfica (JavaFX ou Swing)

Digite o ano de publicação: 2023- [ ] API REST (Spring Boot)

Digite o ISBN: 978-1234567890- [ ] Testes unitários (JUnit)

Digite as observações: Livro introdutório- [ ] Logging (Log4j)

Digite o ID da editora (FK): 1- [ ] Relatórios (PDF, Excel)

✓ Livro inserido com sucesso!- [ ] Sistema de busca avançada

```- [ ] Autenticação e autorização

- [ ] Histórico de alterações (audit trail)

### Exemplo 3: Listar Todos

```---

--- Menu Editoras ---

5. Imprimir Todos## 👨‍💻 Autor

Escolha: 5

**João Lucas**  

=== Lista de Editoras ===Estudante de Programação  

ID: 1Trabalho Acadêmico - Programação Orientada a Objetos

Nome: Editora Atlas

Sigla: EA---

Observações: Editora especializada em tecnologia

-------------------------## 📝 Notas Técnicas

Total: 1 editora(s)

```### Decisões de Design



---1. **ArrayList vs outras estruturas**: Escolhido pela simplicidade e adequação ao escopo

2. **Armazenamento em memória**: Adequado para fins acadêmicos e demonstração

## 🛠️ Tecnologias Utilizadas3. **Validações na entidade**: Garante consistência dos dados em qualquer contexto

4. **Classe base genérica**: Demonstra reuso de código e conceitos avançados de POO

- **Java SE** - Linguagem principal5. **Lambdas**: Torna o código mais conciso e expressivo

- **java.util.ArrayList** - Armazenamento em memória

- **java.util.Scanner** - Entrada de dados via terminal### Arquivos Fonte

- **java.util.stream** - Operações funcionais (filter, map)

- **java.util.function.Predicate** - Critérios de busca flexíveis```

- **java.util.Iterator** - Iteração segura para remoçãoTotal: 13 arquivos .java



---Model (Entidades):

├── Autor.java

## 📊 Métricas do Projeto├── AutorLivro.java

├── Editora.java

| Métrica                     | Valor |└── Livro.java

|-----------------------------|-------|

| Classes Total               | 13    |Data (DAO):

| Classes de Modelo           | 4     |├── AutorBanco.java

| Classes de Dados (Banco)    | 5     |├── AutorLivroBanco.java

| Classes de Visão (Menu)     | 4     |├── BancoBase.java ⭐

| Linhas de Código (aprox.)   | 1.200 |├── EditoraBanco.java

| **Linhas Eliminadas** (DRY) | **~105** |└── LivroBanco.java

| Relacionamentos             | 2 (1:N + N:N) |

| Operações CRUD por Entidade | 6     |View (Interface):

├── Main.java

### 🎯 Impacto da Refatoração├── MenuAutores.java

Antes da classe `BancoBase<T>`:├── MenuEditoras.java

- EditoraBanco: ~60 linhas└── MenuLivros.java

- LivroBanco: ~55 linhas```

- AutorBanco: ~55 linhas

- **Total**: ~170 linhas---



Depois da classe `BancoBase<T>`:## 📄 Licença

- BancoBase: ~35 linhas (reutilizável)

- EditoraBanco: ~30 linhasEste projeto foi desenvolvido para fins acadêmicos e educacionais.

- LivroBanco: ~28 linhas

- AutorBanco: ~26 linhas---

- **Total**: ~119 linhas

## 🙏 Agradecimentos

**Redução**: ~105 linhas (**~30% menos código**)

Agradecimentos especiais ao professor e colegas da disciplina de Programação Orientada a Objetos pela oportunidade de aplicar os conceitos estudados em um projeto prático.

---

---

## 📖 Conceitos Acadêmicos Demonstrados

<div align="center">

- [x] **Classes e Objetos** - 13 classes com responsabilidades bem definidas

- [x] **Encapsulamento** - Atributos privados, métodos públicos**Desenvolvido com ❤️ usando Java**

- [x] **Herança** - BancoBase → EditoraBanco, LivroBanco, AutorBanco

- [x] **Polimorfismo** - Predicates, sobrecarga de métodos![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

- [x] **Abstração** - Classe abstrata BancoBase![POO](https://img.shields.io/badge/POO-Oriented-blue?style=for-the-badge)

- [x] **Generics** - BancoBase<T> parametrizado![Status](https://img.shields.io/badge/Status-Completo-success?style=for-the-badge)

- [x] **Validação de Dados** - Setters com IllegalArgumentException

- [x] **Relacionamentos** - 1:N (Editora-Livro), N:N (Livro-Autor)</div>

- [x] **Design Patterns** - DAO Pattern, Template Method

- [x] **Princípio DRY** - Don't Repeat Yourself via BancoBase### Menu Principal

- [x] **Streams e Lambdas** - Java 8+ functional programming

- [x] **Collections Framework** - ArrayList, List, Iterator```

========================================

---  SISTEMA DE GESTAO COMPLETO

  Editoras | Livros | Autores

## 🔮 Melhorias Futuras========================================



- [ ] Persistência em banco de dados (MySQL/PostgreSQL)========================================

- [ ] Interface gráfica (JavaFX ou Swing)          MENU PRINCIPAL

- [ ] Exportação de dados (CSV, JSON)========================================

- [ ] Sistema de login e autenticação1 - Gerenciar Editoras

- [ ] Relatórios estatísticos2 - Gerenciar Livros

- [ ] API REST (Spring Boot)3 - Gerenciar Autores

- [ ] Testes unitários (JUnit 5)0 - Sair do Sistema

- [ ] Logs de operações========================================

- [ ] Internacionalização (i18n)Escolha uma opcao: 

- [ ] Docker para containerização```



---### Inserindo uma Editora



## 👨‍💻 Autor```

--- INSERIR EDITORA ---

**João**  ID (>0): 1

Estudante de Programação Orientada a Objetos  Nome (min 3 chars): Companhia das Letras

📧 Email: [seu-email@exemplo.com](mailto:seu-email@exemplo.com)Sigla (min 2 chars): CDL

Observacoes (opcional): Principal editora brasileira

---[OK] [1] Companhia das Letras (CDL) - Principal editora brasileira

```

## 📄 Licença

### Inserindo um Livro

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

```

------ INSERIR LIVRO ---

ID (>0): 1

## 🙏 AgradecimentosNome (min 3 chars): 1984

Ano de Publicacao (>0): 2009

- Professor(a) da disciplina de POOISBN (>0): 9788535914849

- Colegas de turma pelas discussões técnicasID da Editora (>0): 1

- Comunidade Java BrasilObservacoes (opcional): Edicao comemorativa

[OK] Livro inserido: [ID:1] 1984 (Ano: 2009, ISBN: 9788535914849, Ed:1, Obs: Edicao comemorativa)

---```



## 📝 Notas Técnicas### Inserindo um Autor



### Decisões de Design```

--- INSERIR AUTOR ---

1. **Armazenamento em Memória**: Escolhido por ser adequado para projeto acadêmico e facilitar demonstração de conceitos sem dependências externas.ID (>0): 1

Nome (min 3 chars): George Orwell

2. **Classe Genérica Base**: Implementada após identificação de ~105 linhas duplicadas nas classes Banco, demonstrando refatoração e princípio DRY.Pseudonimo (opcional): Eric Arthur Blair

Observacoes (opcional): Escritor britanico

3. **Validações no Setter**: Preferidas sobre validações no construtor para permitir alteração de dados mantendo integridade.[OK] Autor inserido: [1] George Orwell (Pseudonimo: Eric Arthur Blair) - Escritor britanico

```

4. **Uso de Predicates**: Escolha deliberada para demonstrar programação funcional e flexibilidade em buscas.

---

5. **Menus Separados**: Facilita manutenção e segue Single Responsibility Principle.

```

---projeto-poo-java/

├── Editora.java              # Classe base com validações

## 📦 Arquivos do Projeto├── EditoraBanco.java         # Classe banco (gerencia dados)

├── MenuEditoras.java         # Menu interativo CRUD

```├── Main.java                 # Método main do projeto

✓ Editora.java              (Modelo)└── README.md                 # Documentação

✓ Livro.java                (Modelo)```

✓ Autor.java                (Modelo)

✓ AutorLivro.java           (Modelo)## 🎯 Componentes Obrigatórios Entregues

✓ BancoBase.java            (Dados - Abstrata/Genérica)

✓ EditoraBanco.java         (Dados)### a) Classe Base: `Editora.java`

✓ LivroBanco.java           (Dados)Entidade principal com validações implementadas:

✓ AutorBanco.java           (Dados)- **Atributos:**

✓ AutorLivroBanco.java      (Dados)  - `codigo` (int): Identificador único

✓ MenuEditoras.java         (Visão)  - `descricao` (String): Nome/descrição da editora

✓ MenuLivros.java           (Visão)  

✓ MenuAutores.java          (Visão)- **Validações obrigatórias:**

✓ Main.java                 (Ponto de Entrada)  - ✅ Código não pode ser negativo ou zero

✓ README.md                 (Documentação)  - ✅ Descrição não pode ser nula, vazia ou ter menos de 3 caracteres

```  - Exceções são lançadas quando regras são violadas



---### b) Classe Banco: `EditoraBanco.java`

Gerencia a coleção de editoras em memória:

<div align="center">- Utiliza `ArrayList<Editora>` para armazenamento

- Garante códigos únicos

**Desenvolvido com ❤️ para fins acadêmicos**- Implementa todas as operações CRUD



[![Made with Java](https://img.shields.io/badge/Made%20with-Java-red.svg)](https://www.java.com)### c) Menu Interativo: `MenuEditoras.java`

[![POO](https://img.shields.io/badge/Paradigm-Object--Oriented-blue.svg)]()Interface com o usuário para executar operações:

- Menu formatado e intuitivo

</div>- Tratamento de exceções

- Feedback claro das operações

### d) Método Main: `Main.java`
Ponto de entrada do sistema:
- Inicializa o scanner
- Exibe menu principal
- Gerencia ciclo de vida da aplicação

## 🔧 Operações Implementadas

### 1. **Inserir** (Create)
- Solicita código e descrição
- Valida dados conforme regras
- Verifica duplicidade de código
- Adiciona editora ao banco

### 2. **Alterar** (Update)
- Busca editora por código
- Permite alterar apenas a descrição
- Valida nova descrição

### 3. **Excluir** (Delete)
- Remove editora por código
- Confirma remoção

### 4. **Pesquisar** (Read)
- Busca editora específica por código
- Exibe dados encontrados

### 5. **Imprimir Todas** (Read All)
- Lista todas as editoras cadastradas
- Formato: `[codigo] descricao`

### 6. **Obter Número de Itens** (Count)
- Retorna quantidade total de editoras cadastradas

## 🚀 Como Usar

### Compilar
```powershell
javac -encoding UTF-8 *.java
```

### Executar
```powershell
java Main
```

## ✅ Regras de Validação Implementadas

### Código (int)
- ❌ Não pode ser **zero**
- ❌ Não pode ser **negativo**
- ✅ Deve ser **maior que zero**
- ✅ Deve ser **único** (não pode haver códigos duplicados)

### Descrição (String)
- ❌ Não pode ser **nula**
- ❌ Não pode ser **vazia** (string vazia ou apenas espaços)
- ❌ Não pode ter **menos de 3 caracteres**
- ✅ Deve ter **no mínimo 3 caracteres** após remover espaços extras

### Exemplos de Validação

**Código inválido:**
```
codigo = 0     → ERRO: "Codigo deve ser maior que zero."
codigo = -5    → ERRO: "Codigo deve ser maior que zero."
```

**Descrição inválida:**
```
descricao = null        → ERRO: "Descricao invalida: minimo 3 caracteres."
descricao = ""          → ERRO: "Descricao invalida: minimo 3 caracteres."
descricao = "  "        → ERRO: "Descricao invalida: minimo 3 caracteres."
descricao = "ab"        → ERRO: "Descricao invalida: minimo 3 caracteres."
```

**Válidos:**
```
codigo = 1, descricao = "ABC"           → OK
codigo = 100, descricao = "Editora XYZ" → OK
```

## � Exemplo de Uso

```
========== MENU PRINCIPAL ==========
1 - Gerenciar Editoras
0 - Sair
====================================
Escolha uma opcao: 1

========== MENU DE EDITORAS ==========
1 - Inserir Editora
2 - Alterar Descricao
3 - Excluir Editora
4 - Pesquisar por Codigo
5 - Imprimir Todas
6 - Obter Numero de Itens
0 - Voltar ao Menu Principal
======================================
Escolha uma opcao: 1

--- INSERIR ---
Codigo (>0): 1
Descricao (min 3 chars): Editora ABC
[OK] [1] Editora ABC
```

## 💡 Tecnologias Utilizadas

- **Linguagem:** Java SE
- **Paradigma:** Programação Orientada a Objetos (POO)
- **Estruturas de Dados:** ArrayList
- **Entrada/Saída:** Scanner (console)

## 📝 Conceitos de POO Aplicados

- ✅ **Encapsulamento:** Atributos privados com getters/setters validados
- ✅ **Validação de Dados:** Regras de negócio implementadas na classe base
- ✅ **Separação de Responsabilidades:** Classes Model, Storage e View
- ✅ **Tratamento de Exceções:** `IllegalArgumentException` para validações
- ✅ **Imutabilidade:** Uso de `final` em atributos apropriados

## 🔧 Requisitos

- Java JDK 8 ou superior
- Codificação UTF-8

## 👨‍💻 Autor

**João Lucas**  
Projeto Acadêmico - Programação Orientada a Objetos

---

**Versão:** 2.0 - CRUD Completo  
**Data:** Outubro 2025  
**Status:** ✅ Entregue com todas as operações e validações obrigatórias implementadas
