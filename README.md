# 📚 Sistema de Gestão - Editoras, Livros e Autores

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-orange.svg)
![POO](https://img.shields.io/badge/Paradigma-POO-blue.svg)
![Status](https://img.shields.io/badge/Status-Concluído-green.svg)

**Sistema CRUD completo com conceitos avançados de POO desenvolvido em Java**

</div>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Conceitos POO Implementados](#-conceitos-poo-implementados)
- [Funcionalidades Principais](#-funcionalidades-principais)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Como Executar](#-como-executar)
- [Modelo de Dados](#-modelo-de-dados)

---

## 🎯 Sobre o Projeto

Sistema acadêmico completo para gerenciamento de **Editoras**, **Livros** e **Autores**, desenvolvido em Java puro aplicando todos os principais conceitos de **Programação Orientada a Objetos**.

### Destaques do Sistema:
- ✅ **3 CRUDs completos** (Autores, Editoras, Livros)
- ✅ **Geração automática de código** - IDs gerados automaticamente
- ✅ **Contador de registros** integrado aos métodos ADICIONAR/REMOVER
- ✅ **Persistência em arquivos** (serialização)
- ✅ **Validações robustas** em todas as entidades
- ✅ **Menus interativos** via terminal

---

## 🔷 Conceitos POO Implementados

### 1. **Classe Base Abstrata** (`Entidade`)
```java
public abstract class Entidade implements Serializable {
    private int codigo;
    protected Entidade(int codigo) { setCodigo(codigo); }
    public abstract String toString();
}
```

### 2. **Herança**
- `Autor extends Entidade`
- `Editora extends Entidade`
- `Livro extends Entidade`
- `BancoBase<T extends Entidade>` (genérico com herança)

### 3. **Encapsulamento**
- Todos os atributos são `private`
- Acesso via getters/setters com validações

### 4. **Sobrecarga de Métodos**
```java
// Classe Autor - Múltiplos construtores
public Autor(int autid, String autnome, String autpseudomo, String autobservacoes)
public Autor(int autid, String autnome)
public Autor(String autnome)
public Autor(String autnome, String autpseudomo)

// Classe Validador - Métodos estáticos sobrecarregados
public static boolean validarId(int id)
public static boolean validarId(int id, int min, int max)
public static String formatarTexto(String texto)
public static String formatarTexto(String texto, boolean uppercase)
```

### 5. **Classes Estáticas**
```java
public final class Validador {
    private Validador() { } // Construtor privado - não pode ser instanciada
    public static boolean validarId(int id) { }
    public static boolean validarNome(String nome) { }
}
```

### 6. **Sobrescrição de Métodos (Override)**
```java
@Override
public String toString() { }

@Override
public boolean equals(Object obj) { }

@Override
public int hashCode() { }
```

### 7. **Separação de Responsabilidades**
- **Entidades**: `Autor`, `Editora`, `Livro`, `Entidade`
- **Persistência**: `BancoBase`, `AutorBanco`, `EditoraBanco`, `LivroBanco`
- **Interface**: `MenuAutores`, `MenuEditoras`, `MenuLivros`
- **Validações**: `Validador` (classe estática)
- **Ponto de Entrada**: `Main`

---

## ⚙️ Funcionalidades Principais

### 🆔 Geração Automática de Código
O sistema **NÃO solicita** que o usuário informe o código/ID. Ao inserir um registro:
```
[INFO] O codigo sera gerado automaticamente.
Nome: João Silva
[OK] Autor inserido: [1] João Silva
```

### 📊 Contador de Registros
Cada módulo possui opção que exibe:
- **Total atual** de registros cadastrados
- **Total histórico** de registros adicionados

```
========== CONTADOR DE REGISTROS ==========
[INFO] Total de autores cadastrados: 5
[INFO] Total de registros adicionados: 8
==========================================
```

### 📋 Imprimir Todos os Registros
Cada menu possui opção para listar todos os registros cadastrados:
```
--- TODOS OS AUTORES ---
Total: 3 autor(es)
----------------------------
[1] João Silva (Pseudonimo: JS)
[2] Maria Santos
[3] Pedro Costa - Especialista em Java
----------------------------
```

---

## 📂 Estrutura do Projeto

```
projeto-poo-java/
│
├── Entidade.java           # ⭐ Classe base abstrata
├── Autor.java              # Entidade Autor (herda de Entidade)
├── Editora.java            # Entidade Editora (herda de Entidade)
├── Livro.java              # Entidade Livro (herda de Entidade)
├── AutorLivro.java         # Relacionamento N:N
│
├── BancoBase.java          # ⭐ Classe base genérica para persistência
├── AutorBanco.java         # Persistência de Autores
├── EditoraBanco.java       # Persistência de Editoras
├── LivroBanco.java         # Persistência de Livros
├── AutorLivroBanco.java    # Persistência de relacionamentos
│
├── MenuAutores.java        # Interface do menu de autores
├── MenuEditoras.java       # Interface do menu de editoras
├── MenuLivros.java         # Interface do menu de livros
│
├── Validador.java          # ⭐ Classe estática de validações
├── Main.java               # Ponto de entrada do sistema
│
├── data/                   # Diretório de persistência
│   ├── autores.dat
│   ├── editoras.dat
│   └── livros.dat
│
└── README.md               # Este arquivo
```

**Métricas**: 14 arquivos | ~1.500 linhas de código

---

## 🗂️ Modelo de Dados

```
Editora (1) ─────→ (N) Livro (N) ←────→ (N) Autor
                           │
                           └──→ AutorLivro (Tabela de relacionamento)
```

### Entidades:
- **Editora**: `codigo`, `nome`, `sigla`, `observacoes`
- **Livro**: `codigo`, `nome`, `anoPublicacao`, `isbn`, `observacoes`, `editoraId`
- **Autor**: `codigo`, `nome`, `pseudonimo`, `observacoes`
- **AutorLivro**: `livroId`, `autorId` (relacionamento N:N)

---

## 🚀 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- Terminal/CMD/PowerShell

### Compilação e Execução

```bash
# Compilar todos os arquivos
javac -encoding UTF-8 *.java

# Executar o sistema
java Main

# Limpar arquivos compilados (PowerShell)
Remove-Item *.class -Force

# Limpar arquivos compilados (Linux/Mac)
rm *.class
```

### Usando Tasks do VS Code
O projeto inclui tasks configuradas:
- `clean`: Limpa arquivos compilados
- `build`: Compila o projeto
- `run`: Executa o sistema

---

## 📋 Menu do Sistema

```
========================================
  SISTEMA DE GESTAO COMPLETO
  Editoras | Livros | Autores
========================================

========================================
          MENU PRINCIPAL
========================================
1 - Gerenciar Editoras
2 - Gerenciar Livros
3 - Gerenciar Autores
0 - Sair do Sistema
========================================
```

### Opções de Cada Módulo (CRUD):
1. **Inserir** (com código automático)
2. **Alterar** (busca por ID)
3. **Excluir** (remove por ID)
4. **Pesquisar** (busca por ID)
5. **Imprimir Todos** (lista completa)
6. **Obter Número de Itens** (contador)
0. **Voltar** ao menu principal

---

## ✅ Validações Implementadas

### Códigos (gerados automaticamente)
- Devem ser > 0
- São únicos para cada entidade

### Campos de Texto
- **Nomes**: Mínimo 3 caracteres
- **Siglas**: Mínimo 2 caracteres
- **Observações**: Opcionais

### Campos Numéricos
- **Anos**: Entre 1000 e ano atual
- **ISBN**: Deve ser > 0
- **IDs de Relacionamento**: Devem existir

---

## 🛠️ Tecnologias e Conceitos

### Linguagem e Ferramentas
- **Java SE 8+** com recursos modernos
- **Serialização** para persistência
- **Collections Framework** (ArrayList, List)

### Recursos Java Utilizados
- **Generics** (`<T extends Entidade>`)
- **Lambdas** e **Predicates**
- **Streams API**
- **Try-with-resources**
- **Annotations** (@Override)

### Princípios de Design
- **DRY** (Don't Repeat Yourself)
- **SRP** (Single Responsibility Principle)
- **Encapsulamento** com validações
- **Arquitetura em 3 camadas**

---

## 📊 Resumo dos Conceitos POO

| Conceito | Implementação | Localização |
|----------|--------------|-------------|
| **Classe Base** | `Entidade` (abstrata) | Entidade.java |
| **Herança** | Autor, Editora, Livro extends Entidade | Todas as entidades |
| **Encapsulamento** | Atributos private + getters/setters | Todas as classes |
| **Sobrecarga** | Múltiplos construtores e métodos | Autor, Editora, Livro, Validador |
| **Classes Estáticas** | Validador (final + métodos static) | Validador.java |
| **Classes Abstratas** | Entidade e BancoBase | Entidade.java, BancoBase.java |
| **Override** | toString(), equals(), hashCode() | Todas as entidades |
| **Separação** | Model-Data-View | Estrutura de pastas |

---

## 👨‍💻 Autor

**João Lucas**  
Trabalho Acadêmico - Programação Orientada a Objetos

---

## 📄 Licença

Este projeto é um trabalho acadêmico desenvolvido para fins educacionais.

---

<div align="center">

**⭐ Sistema completo implementando todos os requisitos de POO ⭐**

![Java](https://img.shields.io/badge/Made%20with-Java-red.svg)
![POO](https://img.shields.io/badge/Paradigm-OOP-blue.svg)
![Academic](https://img.shields.io/badge/Type-Academic-green.svg)

</div>
