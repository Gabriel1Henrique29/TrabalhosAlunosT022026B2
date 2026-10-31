import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Jogo> jogos = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println();
            System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println();
            System.out.println("1 - Cadastrar");
            System.out.println();
            System.out.println("2 - Listar todos");
            System.out.println();
            System.out.println("3 - Buscar por ID");
            System.out.println();
            System.out.println("4 - Atualizar");
            System.out.println();
            System.out.println("5 - Excluir");
            System.out.println();
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Escolha uma opcao: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                cadastrar(teclado, jogos);
            } else if (opcao == 2) {
                listar(jogos);
            } else if (opcao == 3) {
                buscar(teclado, jogos);
            } else if (opcao == 4) {
                atualizar(teclado, jogos);
            } else if (opcao == 5) {
                excluir(teclado, jogos);
            } else if (opcao == 0) {
                System.out.println("Programa encerrado.");
            } else {
                System.out.println("Opcao invalida.");
            }
        }

        teclado.close();
    }

    public static void cadastrar(Scanner teclado, ArrayList<Jogo> jogos) {
        System.out.print("ID: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        boolean existe = false;
        for (int i = 0; i < jogos.size(); i++) {
            if (jogos.get(i).getId() == id) {
                existe = true;
            }
        }

        if (existe == true) {
            System.out.println("Ja existe um jogo com esse ID.");
        } else {
            System.out.print("Nome: ");
            String nome = teclado.nextLine();

            System.out.print("Genero: ");
            String genero = teclado.nextLine();

            Jogo jogo = new Jogo(id, nome, genero);
            jogos.add(jogo);
            System.out.println("Jogo cadastrado.");
        }
    }

    public static void listar(ArrayList<Jogo> jogos) {
        if (jogos.size() == 0) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            for (int i = 0; i < jogos.size(); i++) {
                jogos.get(i).exibir();
            }
        }
    }

    public static void buscar(Scanner teclado, ArrayList<Jogo> jogos) {
        if (jogos.size() == 0) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.print("ID: ");
            int id = teclado.nextInt();
            teclado.nextLine();

            boolean achou = false;
            for (int i = 0; i < jogos.size(); i++) {
                if (jogos.get(i).getId() == id) {
                    jogos.get(i).exibir();
                    achou = true;
                }
            }

            if (achou == false) {
                System.out.println("ID nao encontrado.");
            }
        }
    }

    public static void atualizar(Scanner teclado, ArrayList<Jogo> jogos) {
        if (jogos.size() == 0) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.print("ID: ");
            int id = teclado.nextInt();
            teclado.nextLine();

            boolean achou = false;
            for (int i = 0; i < jogos.size(); i++) {
                if (jogos.get(i).getId() == id) {
                    System.out.print("Novo nome: ");
                    String nome = teclado.nextLine();

                    System.out.print("Novo genero: ");
                    String genero = teclado.nextLine();

                    jogos.get(i).setNome(nome);
                    jogos.get(i).setGenero(genero);
                    System.out.println("Jogo atualizado.");
                    achou = true;
                }
            }

            if (achou == false) {
                System.out.println("ID nao encontrado.");
            }
        }
    }

    public static void excluir(Scanner teclado, ArrayList<Jogo> jogos) {
        if (jogos.size() == 0) {
            System.out.println("Nenhum jogo cadastrado.");
        } else {
            System.out.print("ID: ");
            int id = teclado.nextInt();
            teclado.nextLine();

            int posicao = -1;
            for (int i = 0; i < jogos.size(); i++) {
                if (jogos.get(i).getId() == id) {
                    posicao = i;
                }
            }

            if (posicao == -1) {
                System.out.println("ID nao encontrado.");
            } else {
                jogos.remove(posicao);
                System.out.println("Jogo excluido.");
            }
        }
    }
}
