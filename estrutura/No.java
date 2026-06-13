package estrutura;

public class No {
    public Livro livro;
    public No esq;
    public No dir;

    public No(Livro livro) {
        this.livro = livro;
        this.esq = null;
        this.dir = null;
    }
}