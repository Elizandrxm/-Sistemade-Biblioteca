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
            noAtual.esquerdo = inserirRecursivo(noAtual.esquerdo, novoLivro);
        } else if (novoLivro.id > noAtual.livro.id) {
            noAtual.direito = inserirRecursivo(noAtual.direito, novoLivro);
        }

        return noAtual;
    }
}