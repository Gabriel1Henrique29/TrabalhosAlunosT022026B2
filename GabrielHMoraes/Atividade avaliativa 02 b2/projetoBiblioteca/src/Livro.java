public class Livro {

	String nome;
	String autor;
	String emprestadoPara;

	void mostrar(int numero) {
		System.out.println(numero + " - " + nome + " - " + autor);
		if (emprestadoPara.equals("")) {
			System.out.println("   Disponivel");
		} else {
			System.out.println("   Emprestado para " + emprestadoPara);
		}
	}

}
