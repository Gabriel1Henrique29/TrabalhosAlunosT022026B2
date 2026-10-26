
class Cofrinho {
    String Dono;
    double Saldo;
    double MetaEconomia;

    public Cofrinho(String dono, double metaEconomia) {
        Dono = dono;
        Saldo = 0.0;
        MetaEconomia = metaEconomia;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o depósito deve ser de um valor positivo.");
            return;
        }
        Saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado.%n", valor);
    }

    public void retirar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: o valor da retirada deve ser positivo.");
            return;
        }
        if (valor > Saldo) {
            System.out.printf("Retirada de R$ %.2f negada: saldo insuficiente (saldo atual: R$ %.2f).%n",
                    valor, Saldo);
            return;
        }
        Saldo -= valor;
        System.out.printf("Retirada de R$ %.2f realizada.%n", valor);
    }
 
    public void verificarMeta() {
        if (Saldo >= MetaEconomia) {
            System.out.printf("Parabéns, %s! A meta de R$ %.2f foi atingida!%n", Dono, MetaEconomia);
        } else {
            System.out.printf("Meta ainda não atingida. Faltam R$ %.2f para chegar a R$ %.2f.%n",
                    MetaEconomia - Saldo, MetaEconomia);
        }
    }
 
    public void exibirSaldo() {
        System.out.printf("Cofrinho de %s | Saldo: R$ %.2f | Meta: R$ %.2f%n", Dono, Saldo, MetaEconomia);
    }
}
 
public class Atividade4 {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho("João", 500.00);
 
        cofrinho.depositar(150.00);
        cofrinho.depositar(100.00);
        cofrinho.depositar(-20.00); 
        cofrinho.exibirSaldo();
 
       
        cofrinho.retirar(400.00);
        cofrinho.exibirSaldo();
 
        cofrinho.verificarMeta();
 
        
        cofrinho.depositar(250.00);
        cofrinho.exibirSaldo();
        cofrinho.verificarMeta();
        
    }
   
}    