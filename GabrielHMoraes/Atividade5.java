class Pedido {
    String NomeCliente;
    int QuantidadeLanches;
    double PrecoLanche;
    double TaxaEntrega;
    String Status;

    Pedido(String nomeCliente) {
        NomeCliente = nomeCliente;
        QuantidadeLanches = 0;
        PrecoLanche = 18.00;
        TaxaEntrega = 7.00;
        Status = "Aberto";
    }

    void adicionarLanches(int quantidade) {
        if (Status.equals("Finalizado")) {
            System.out.println("Operação não permitida: o pedido já foi finalizado.");
        } else {
            QuantidadeLanches = QuantidadeLanches + quantidade;
            System.out.println(quantidade + " lanche(s) adicionado(s). Operação permitida.");
        }
    }

    double calcularTotal() {
        double valorLanches = QuantidadeLanches * PrecoLanche;

        if (QuantidadeLanches >= 3) {
            valorLanches = valorLanches - (valorLanches * 0.10);
        }

        double total = valorLanches + TaxaEntrega;
        return total;
    }

    void finalizarPedido() {
        Status = "Finalizado";
        System.out.println("Pedido finalizado.");
    }

    void exibirPedido() {
        System.out.println("----- Pedido -----");
        System.out.println("Cliente: " + NomeCliente);
        System.out.println("Lanches: " + QuantidadeLanches);
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
        System.out.println("Status: " + Status);
    }
}

public class Atividade5 {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Maria");

        pedido.adicionarLanches(2);
        pedido.adicionarLanches(1);

        System.out.printf("Total calculado: R$ %.2f%n", pedido.calcularTotal());

        pedido.finalizarPedido();
        pedido.exibirPedido();

        pedido.adicionarLanches(1);
    }
}