package estrutura;

public class Arvore_livros {
    public No raiz;

    public Arvore_livros() {
        this.raiz = null;
    }

    public void inserir(Livro novoLivro) {
        this.raiz = inserirRecursivo(this.raiz, novoLivro);
    }

    private No inserirRecursivo(No noAtual, Livro novoLivro) {
        if (noAtual == null) {
            return new No(novoLivro);
        }

        if (novoLivro.id < noAtual.livro.id) {
            noAtual.esq = inserirRecursivo(noAtual.esq, novoLivro);
        } else if (novoLivro.id > noAtual.livro.id) {
            noAtual.dir = inserirRecursivo(noAtual.dir, novoLivro);
        } else {
            System.out.println("ISBN ja cadastrado. Nao e permitido duplicatas.");
        }

        return noAtual;
    }

    public Livro buscarLivro(long id) {
        return buscarLivroRecursivo(raiz, id);
    }

    private Livro buscarLivroRecursivo(No noAtual, long id) {
        if (noAtual == null) {
            return null;
        }

        if (id == noAtual.livro.id) {
            return noAtual.livro;
        }

        if (id < noAtual.livro.id) {
            return buscarLivroRecursivo(noAtual.esq, id);
        }

        return buscarLivroRecursivo(noAtual.dir, id);
    }

    private void emOrdem(No atual) {
        if (atual == null) return;
        emOrdem(atual.esq);
        System.out.println(" " + atual.livro);
        emOrdem(atual.dir);
    }

    public void exibirEmOrdem() {
        System.out.println("\n--- Livros em Ordem Crescente de ISBN (In-Order) ---");
        if (raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }
        emOrdem(raiz);
        System.out.println();
    }

    public void exibirPreOrdem() {
        System.out.println("\n--- Livros em Pre-Ordem (Pre-Order) ---");
        if (raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }

        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(No atual) {
        if (atual == null) return;
        System.out.println(" " + atual.livro);
        preOrdem(atual.esq);
        preOrdem(atual.dir);
    }

    public void exibirPosOrdem() {
        System.out.println("\n--- Livros em Pos-Ordem (Post-Order) ---");
        if (raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }

        posOrdem(raiz);
        System.out.println();
    }

    private void posOrdem(No atual) {
        if (atual == null) return;
        posOrdem(atual.esq);
        posOrdem(atual.dir);
        System.out.println(" " + atual.livro);
    }

    public void mostrarMaiorISBN() {
        if (raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }

        No maior = encontrarMaior(raiz);
        System.out.println("Livro com maior ISBN: " + maior.livro);
    }

    public void mostrarMenorISBN() {
        if (raiz == null) {
            System.out.println("Arvore vazia.");
            return;
        }

        No menor = encontrarMenor(raiz);
        System.out.println("Livro com menor ISBN: " + menor.livro);
    }

    public void mostrarQuantidade() {
        int total = contarNos(raiz);
        System.out.println("Total de livros cadastrados: " + total);
    }

    private int contarNos(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarNos(atual.esq) + contarNos(atual.dir);
    }

    public void mostrarAltura() {
        int altura = calcularAltura(raiz);
        System.out.println("Altura da arvore: " + altura);
    }

    private int calcularAltura(No atual) {
        if (atual == null) {
            return -1;
        }

        int altEsq = calcularAltura(atual.esq);
        int altDir = calcularAltura(atual.dir);

        return 1 + Math.max(altEsq, altDir);
    }

    private No encontrarMenor(No atual) {
        if (atual == null) {
            return null;
        }

        if (atual.esq == null) {
            return atual;
        }

        return encontrarMenor(atual.esq);
    }

    private No encontrarMaior(No atual) {
        if (atual == null) {
            return null;
        }

        if (atual.dir == null) {
            return atual;
        }

        return encontrarMaior(atual.dir);
    }

    public void removerLivro(long id) {
        this.raiz = removerRecursivo(this.raiz, id);
    }

    private No removerRecursivo(No noAtual, long id) {
        if (noAtual == null) {
            return null;
        }

        if (id < noAtual.livro.id) {
            noAtual.esq = removerRecursivo(noAtual.esq, id);
            return noAtual;
        }

        if (id > noAtual.livro.id) {
            noAtual.dir = removerRecursivo(noAtual.dir, id);
            return noAtual;
        }

        if (noAtual.esq == null && noAtual.dir == null) {
            return null;
        }

        if (noAtual.esq == null) {
            return noAtual.dir;
        }

        if (noAtual.dir == null) {
            return noAtual.esq;
        }

        No predecessor = encontrarMaior(noAtual.esq);
        noAtual.livro = predecessor.livro;
        noAtual.esq = removerRecursivo(noAtual.esq, predecessor.livro.id);

        return noAtual;
    }

    public void popularBiblioteca(Arvore_livros biblioteca) {
        biblioteca.inserir(new Livro(50, "Java Básico", "Ana", "Programação", 3));
        biblioteca.inserir(new Livro(30, "Estruturas de Dados", "Carlos", "Computação", 5));
        biblioteca.inserir(new Livro(70, "Banco de Dados", "Marina", "Tecnologia", 2));
        biblioteca.inserir(new Livro(20, "Algoritmos", "Pedro", "Computação", 4));
        biblioteca.inserir(new Livro(40, "POO", "Julia", "Programação", 6));
        biblioteca.inserir(new Livro(60, "Redes de Computadores", "Lucas", "Infraestrutura", 1));
        biblioteca.inserir(new Livro(80, "Segurança da Informação", "Fernanda", "Segurança", 7));
        biblioteca.inserir(new Livro(10, "Cálculo I", "Roberto", "Matemática", 8));
        biblioteca.inserir(new Livro(25, "Física Geral", "Helena", "Física", 2));
        biblioteca.inserir(new Livro(35, "Sistemas Operacionais", "Ricardo", "Computação", 3));
        biblioteca.inserir(new Livro(45, "Engenharia de Software", "Patrícia", "Software", 4));
        biblioteca.inserir(new Livro(55, "Inteligência Artificial", "Bianca", "IA", 5));
        biblioteca.inserir(new Livro(65, "Compiladores", "Sérgio", "Computação", 2));
        biblioteca.inserir(new Livro(75, "Machine Learning", "Camila", "IA", 6));
        biblioteca.inserir(new Livro(85, "Cloud Computing", "Rafael", "Infraestrutura", 3));
    }
}