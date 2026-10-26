class MaquinaRefrigerante {
    int QuantidadeEstoque;
    double Preco;
    double DinheiroArrecadado;

    public MaquinaRefrigerante(int estoqueInicial) {
        Preco = 4.50;
        DinheiroArrecadado = 0.0;
        QuantidadeEstoque = Math.max(estoqueInicial, 0);
    }

    public void comprar(int Quantidade, double valorPago) {
        System.out.println("--- Tentando comprar " + Quantidade + " refrigerante(s), pagando R$ "
                + String.format("%.2f", valorPago) + " ---");

        if (Quantidade <= 0) {
            System.out.println("Erro: a quantidade deve ser maior que zero.");
            return;
        }

        if (Quantidade > QuantidadeEstoque) {
            System.out.println("Compra não realizada: estoque insuficiente (disponível: "
                    + QuantidadeEstoque + ").");
            return;
        }

        double total = Quantidade * Preco;

        if (valorPago < total) {
            System.out.printf("Compra não realizada: dinheiro insuficiente. Total: R$ %.2f, faltam R$ %.2f.%n",
                    total, total - valorPago);
            return;
        }

        QuantidadeEstoque -= Quantidade;
        DinheiroArrecadado += total;
        System.out.printf("Compra realizada! Total: R$ %.2f%n", total);

        double troco = valorPago - total;
        if (troco > 0) {
            System.out.printf("Troco: R$ %.2f%n", troco);
        }
    }

    public void reporEstoque(int Quantidade) {
        if (Quantidade <= 0) {
            System.out.println("Erro: a reposição deve ser de uma quantidade positiva.");
            return;
        }
        QuantidadeEstoque += Quantidade;
        System.out.println(Quantidade + " refrigerante(s) repostos.");
    }

    public void exibirEstado() {
        System.out.println("===== Estado da Máquina =====");
        System.out.println("Estoque: " + QuantidadeEstoque + " unidade(s)");
        System.out.printf("Preço: R$ %.2f%n", Preco);
        System.out.printf("Dinheiro arrecadado: R$ %.2f%n", DinheiroArrecadado);
        System.out.println("=============================");
    }
}

public class Atividade2 {
    public static void main(String[] args) {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante(5);
        maquina.exibirEstado();

        maquina.comprar(2, 10.00);

        maquina.comprar(5, 30.00);

        maquina.comprar(1, 3.00);

        maquina.reporEstoque(10);
        maquina.exibirEstado();
    }
}