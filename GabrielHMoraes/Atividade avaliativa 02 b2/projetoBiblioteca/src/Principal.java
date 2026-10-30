import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		Livro[] livros = new Livro[20];
		String[] usuarios = new String[20];
		int quantidadeLivros = 0;
		int quantidadeUsuarios = 0;
		int opcao = -1;

		livros[0] = novoLivro("Dom Casmurro", "Machado de Assis");
		livros[1] = novoLivro("O Pequeno Principe", "Antoine de Saint-Exupery");
		livros[2] = novoLivro("O Hobbit", "J. R. R. Tolkien");
		livros[3] = novoLivro("Capitaes da Areia", "Jorge Amado");
		livros[4] = novoLivro("Turma da Monica", "Mauricio de Sousa");
		quantidadeLivros = 5;

		usuarios[0] = "Patrick";
		usuarios[1] = "Gabriel";
		usuarios[2] = "Theo";
		quantidadeUsuarios = 3;

		while (opcao != 0) {
			System.out.println("----- Biblioteca -----");
			System.out.println("1 - Listar livros");
			System.out.println("2 - Cadastrar livro");
			System.out.println("3 - Excluir livro");
			System.out.println("4 - Emprestar livro");
			System.out.println("5 - Devolver livro");
			System.out.println("6 - Registrar usuario");
			System.out.println("7 - Listar usuarios");
			System.out.println("0 - Sair");
			opcao = entrada.nextInt();
			entrada.nextLine();

			if (opcao == 1) {
				listarLivros(livros, quantidadeLivros);
			} else if (opcao == 2) {
				if (quantidadeLivros == 20) {
					System.out.println("Nao cabe mais livro");
				} else {
					System.out.println("Nome do livro:");
					String nome = entrada.nextLine();
					System.out.println("Autor do livro:");
					String autor = entrada.nextLine();
					livros[quantidadeLivros] = novoLivro(nome, autor);
					quantidadeLivros = quantidadeLivros + 1;
					System.out.println("Livro cadastrado");
				}
			} else if (opcao == 3) {
				listarLivros(livros, quantidadeLivros);
				System.out.println("Numero do livro para excluir:");
				int numero = entrada.nextInt();
				entrada.nextLine();
				int posicao = numero - 1;

				if (posicao < 0 || posicao >= quantidadeLivros) {
					System.out.println("Numero invalido");
				} else if (!livros[posicao].emprestadoPara.equals("")) {
					System.out.println("Livro emprestado, nao pode excluir");
				} else {
					int i = posicao;
					while (i < quantidadeLivros - 1) {
						livros[i] = livros[i + 1];
						i = i + 1;
					}
					quantidadeLivros = quantidadeLivros - 1;
					System.out.println("Livro excluido");
				}
			} else if (opcao == 4) {
				listarUsuarios(usuarios, livros, quantidadeUsuarios, quantidadeLivros);
				System.out.println("Numero do usuario:");
				int numeroUsuario = entrada.nextInt();
				entrada.nextLine();
				int posicaoUsuario = numeroUsuario - 1;

				if (posicaoUsuario < 0 || posicaoUsuario >= quantidadeUsuarios) {
					System.out.println("Usuario invalido");
				} else {
					int quantos = contarLivros(livros, quantidadeLivros, usuarios[posicaoUsuario]);
					if (quantos == 2) {
						System.out.println("Usuario ja tem 2 livros. Devolva um primeiro");
					} else {
						listarLivros(livros, quantidadeLivros);
						System.out.println("Numero do livro:");
						int numeroLivro = entrada.nextInt();
						entrada.nextLine();
						int posicaoLivro = numeroLivro - 1;

						if (posicaoLivro < 0 || posicaoLivro >= quantidadeLivros) {
							System.out.println("Livro invalido");
						} else if (!livros[posicaoLivro].emprestadoPara.equals("")) {
							System.out.println("Livro ja esta emprestado");
						} else {
							livros[posicaoLivro].emprestadoPara = usuarios[posicaoUsuario];
							System.out.println("Livro emprestado");
						}
					}
				}
			} else if (opcao == 5) {
				listarUsuarios(usuarios, livros, quantidadeUsuarios, quantidadeLivros);
				System.out.println("Numero do usuario:");
				int numeroUsuario = entrada.nextInt();
				entrada.nextLine();
				int posicaoUsuario = numeroUsuario - 1;

				if (posicaoUsuario < 0 || posicaoUsuario >= quantidadeUsuarios) {
					System.out.println("Usuario invalido");
				} else {
					System.out.println("Numero do livro que ele vai devolver:");
					int numeroLivro = entrada.nextInt();
					entrada.nextLine();
					int posicaoLivro = numeroLivro - 1;

					if (posicaoLivro < 0 || posicaoLivro >= quantidadeLivros) {
						System.out.println("Livro invalido");
					} else if (!livros[posicaoLivro].emprestadoPara.equals(usuarios[posicaoUsuario])) {
						System.out.println("Esse usuario nao esta com esse livro");
					} else {
						livros[posicaoLivro].emprestadoPara = "";
						System.out.println("Livro devolvido");
					}
				}
			} else if (opcao == 6) {
				if (quantidadeUsuarios == 20) {
					System.out.println("Nao cabe mais usuario");
				} else {
					System.out.println("Nome do usuario:");
					usuarios[quantidadeUsuarios] = entrada.nextLine();
					quantidadeUsuarios = quantidadeUsuarios + 1;
					System.out.println("Usuario cadastrado");
				}
			} else if (opcao == 7) {
				listarUsuarios(usuarios, livros, quantidadeUsuarios, quantidadeLivros);
			} else if (opcao == 0) {
				System.out.println("Sistema encerrado");
			} else {
				System.out.println("Opcao invalida");
			}
		}

		entrada.close();
	}

	static Livro novoLivro(String nome, String autor) {
		Livro livro = new Livro();
		livro.nome = nome;
		livro.autor = autor;
		livro.emprestadoPara = "";
		return livro;
	}

	static void listarLivros(Livro[] livros, int quantidadeLivros) {
		System.out.println("----- Livros -----");
		if (quantidadeLivros == 0) {
			System.out.println("Nenhum livro");
		}
		int i = 0;
		while (i < quantidadeLivros) {
			livros[i].mostrar(i + 1);
			i = i + 1;
		}
	}

	static void listarUsuarios(String[] usuarios, Livro[] livros, int quantidadeUsuarios, int quantidadeLivros) {
		System.out.println("----- Usuarios -----");
		int i = 0;
		while (i < quantidadeUsuarios) {
			System.out.println((i + 1) + " - " + usuarios[i]);
			int j = 0;
			while (j < quantidadeLivros) {
				if (livros[j].emprestadoPara.equals(usuarios[i])) {
					System.out.println("   Livro: " + livros[j].nome);
				}
				j = j + 1;
			}
			i = i + 1;
		}
	}

	static int contarLivros(Livro[] livros, int quantidadeLivros, String nomeUsuario) {
		int quantos = 0;
		int i = 0;
		while (i < quantidadeLivros) {
			if (livros[i].emprestadoPara.equals(nomeUsuario)) {
				quantos = quantos + 1;
			}
			i = i + 1;
		}
		return quantos;
	}

}
