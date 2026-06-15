package estrutura;

public class Livro {
    public long id;
    public String titulo;
    public String autor;
    public String area;
    public int quantidadeDisponivel;

    public Livro(long id, String titulo, String autor, String area, int quantidadeDisponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.area = area;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | Título: %-20s | Autor: %s | Área: %s | Quantidade: %d",
                id, titulo, autor, area, quantidadeDisponivel
        );
    }
}