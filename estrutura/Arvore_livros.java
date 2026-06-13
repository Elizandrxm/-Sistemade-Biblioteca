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
        }else {
            System.out.println("ISBN ja cadastrado. Nao e permitido duplicatas.");
        }

        return noAtual;
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

    private void emOrdem(No atual) {
        if (atual == null) return;
        emOrdem(atual.esq);
        System.out.println("  " + atual.livro);
        emOrdem(atual.dir);
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
        System.out.println("  " + atual.livro);
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
        System.out.println("  " + atual.livro);
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
        if (atual == null) return 0;
        return 1 + contarNos(atual.esq) + contarNos(atual.dir);
    }

    public void mostrarAltura() {
        int altura = calcularAltura(raiz);
        System.out.println("Altura da arvore: " + altura);
    }

    private int calcularAltura(No atual) {
        if (atual == null) return -1; 
        int altEsq = calcularAltura(atual.esq);
        int altDir = calcularAltura(atual.dir);
        return 1 + Math.max(altEsq, altDir);
    }

    private No encontrarMenor(No atual) {
        // Aguardando implementação da equipe
        return null;
    }

    private No encontrarMaior(No atual) {
        // Aguardando implementação da equipe
        return null;
    }
}
