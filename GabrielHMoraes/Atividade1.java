class Estacionamento {
    String Placa;
    String Modelo;
    int MinutosEstacionado;
    double ValorPago;

    Estacionamento(String placa, String modelo) {
        Placa = placa;
        Modelo = modelo;
        MinutosEstacionado = 0;
        ValorPago = 0;
    }

    void adicionarTempo(int minutos) {
        if (minutos < 0) {
            System.out.println("Erro: o tempo não pode ser negativo.");
        } else {
            MinutosEstacionado = MinutosEstacionado + minutos;
            System.out.println(minutos + " minutos adicionados.");
        }
    }

    void calcularValor() {
        if (MinutosEstacionado <= 30) {
            ValorPago = 5.00;
        } else {
            int minutosExtras = MinutosEstacionado - 30;
            ValorPago = 5.00 + (minutosExtras * 0.10);
        }

        if (ValorPago > 30.00) {
            ValorPago = 30.00;
        }
    }

    void exibirResumo() {
        System.out.println("----- Resumo -----");
        System.out.println("Placa: " + Placa);
        System.out.println("Modelo: " + Modelo);
        System.out.println("Tempo: " + MinutosEstacionado + " minutos");
        System.out.printf("Valor a pagar: R$ %.2f%n", ValorPago);
    }
}

public class Atividade1 {
    public static void main(String[] args) {
        Estacionamento carro = new Estacionamento("ABC-1234", "Honda Civic");

        carro.adicionarTempo(45);
        carro.adicionarTempo(20);
        carro.adicionarTempo(-10);

        carro.calcularValor();
        carro.exibirResumo();
    }
}