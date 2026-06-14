package estrutura;

public class FuncoesBiblioteca {

    public static Livro buscarLivro(Arvore_livros arvore, int isbn) {
        No atual = arvore.raiz;

        while (atual != null) {
            if (isbn == atual.livro.id) {
                return atual.livro;
            }

            if (isbn < atual.livro.id) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }
        return null;
    }

    public static Livro maiorISBN(Arvore_livros arvore) {
        if (arvore.raiz == null) {
            return null;
        }

        No atual = arvore.raiz;

        while (atual.dir != null) {
            atual = atual.dir;
        }

        return atual.livro;
    }

    public static Livro menorISBN(Arvore_livros arvore) {
        if (arvore.raiz == null) {
            return null;
        }

        No atual = arvore.raiz;

        while (atual.esq != null) {
            atual = atual.esq;
        }

        return atual.livro;
    }

    public static int quantidadeLivros(Arvore_livros arvore) {
        return contar(arvore.raiz);
    }

    private static int contar(No atual) {
        if (atual == null) {
            return 0;
        }

        return 1 + contar(atual.esq) + contar(atual.dir);
    }
}
