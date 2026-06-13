package estrutura;

public class Livro {
    public int id;
    public String titulo;
    public String autor;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Título: %-20s | Autor: %s", id, titulo, autor);
    }
}