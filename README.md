# Sistema de Gestão de Biblioteca

Aplicação de consola em Java para gerir o acervo de uma biblioteca, desenvolvida no âmbito da unidade curricular de **Programação Orientada a Objetos** do curso de Desenvolvimento Web e Multimédia — Universidade Politécnica de Castelo Branco (ano letivo 2025/2026).

## Funcionalidades

- Adicionar, remover e procurar livros pelo título
- Listar todos os livros, apenas os disponíveis, ou por tipo
- Emprestar e devolver livros
- Contar livros por tipo
- Três tipos de livro, cada um com características próprias:
  - **Livro físico**: número de páginas e localização na estante
  - **Livro digital**: tamanho (MB) e formato; pode ser emprestado várias vezes
  - **Audiolivro**: duração e narrador

## Conceitos aplicados

- Classes e objetos
- Encapsulamento (atributos privados/protegidos, getters e setters com validação)
- Herança (`LivroFisico`, `LivroDigital` e `AudioLivro` estendem `Livro`)
- Polimorfismo (métodos como `emprestarLivro()` e `toString()` redefinidos em cada tipo)
- Coleções (`ArrayList`)

## Estrutura
src/
├── app/
│ └── BibliotecaApp.java # menu e interação com o utilizador
└── model/
├── Biblioteca.java # gestão da lista de livros
├── Livro.java # classe base
├── LivroFisico.java
├── LivroDigital.java
└── AudioLivro.java


## Como executar

Com o Java (JDK) instalado, dentro da pasta `src`:

```bash
javac app/*.java model/*.java
java app.BibliotecaApp
```

## Autores

Larissa Berkenbrock e Guilherme Fernandes
