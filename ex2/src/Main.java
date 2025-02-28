public class Main {
    public static void main(String[] args) {
        Veiculo carro = new Carro("Toyota", "Corolla", 2021, 5, "Gasolina", "Sedan");
        Veiculo caminhao = new Caminhao("Volvo", "FH", 2019, 2, "Diesel", 10);
        Veiculo onibus = new Onibus("Mercedes", "OF-1721", 2020, 40, "Diesel", 6);
        Veiculo carroEletrico = new CarroEletrico("Tesla", "Model 3", 2022, 5, "Hatch", 75);
        Veiculo caminhaoRefrigerado = new CaminhaoRefrigerado("Scania", "R500", 2018, 2, "Diesel", 8, -18);

        Veiculo[] veiculos = {carro, caminhao, onibus, carroEletrico, caminhaoRefrigerado};

        for (Veiculo veiculo : veiculos) {
            veiculo.exibirDetalhes();
            System.out.println("Autonomia: " + veiculo.calcularAutonomia() + " km");
            System.out.println();
        }
    }
}