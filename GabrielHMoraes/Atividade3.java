class Time {
    String Nome;
    int	Vitorias;
    int Empates;
    int Derrotas;
    int Pontos;

    Time(String Nome) {
        Nome = Nome;
        Vitorias = 0;
        Empates = 0;
        Derrotas = 0;
        Pontos = 0;
    }

    void registrarVitoria() {
        Vitorias = Vitorias + 1;
        Pontos = Pontos + 3;
    }

    void registrarEmpate() {
        Empates = Empates + 1;
        Pontos = Pontos + 1;
    }

    void registrarDerrota() {
        Derrotas = Derrotas + 1;
    }

    void exibirEstatisticas() {
        System.out.println("----- " + Nome + " -----");
        System.out.println("Vitórias: " + Vitorias);
        System.out.println("Empates: " + Empates);
        System.out.println("Derrotas: " + Derrotas);
        System.out.println("Pontos: " + Pontos);
    }
}

public class Atividade3 {
    public static void main(String[] args) {
        Time time1 = new Time("Grêmio");
        Time time2 = new Time("Inter");

        time1.registrarVitoria();
        time1.registrarVitoria();
        time1.registrarDerrota();

        time2.registrarVitoria();
        time2.registrarEmpate();
        time2.registrarEmpate();

        time1.exibirEstatisticas();
        time2.exibirEstatisticas();

        if (time1.Pontos > time2.Pontos) {
            System.out.println(time1.Nome + " tem mais pontos.");
        } else if (time2.Pontos > time1.Pontos) {
            System.out.println(time2.Nome + " tem mais pontos.");
        } else {
            System.out.println("Houve empate na classificação.");
        }
    }
}