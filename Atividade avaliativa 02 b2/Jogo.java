public class Jogo {

    private int id;
    private String nome;
    private String genero;

    public Jogo(int id, String nome, String genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void exibir() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Genero: " + genero);
    }
}
