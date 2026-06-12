package estrutura;

public class No {
    public Livro livro;
    public No esquerdo;
    public No direito;

    public No(Livro livro) {
        this.livro = livro;
        this.esquerdo = null;
        this.direito = null;
    }
}