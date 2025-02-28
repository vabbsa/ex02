abstract class Veiculo {
    protected String marca, modelo, combustivel;
    protected int ano, capacidadePassageiros;

    public Veiculo(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
        this.combustivel = combustivel;
    }

    public abstract double calcularAutonomia();

    public void exibirDetalhes() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Capacidade de Passageiros: " + capacidadePassageiros + ", Combustível: " + combustivel);
    }
}

class Carro extends Veiculo {
    private String tipoCarro;

    public Carro(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, String tipoCarro) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.tipoCarro = tipoCarro;
    }

    public double calcularAutonomia() {
        return 50 * 12;
    }
}

class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        this.capacidadeCarga = capacidadeCarga;
    }

    public double calcularAutonomia() {
        double consumo = 6;
        consumo *= (1 - Math.min(capacidadeCarga * 0.01, 0.25));
        return 300 * consumo;
    }
}

class Onibus extends Veiculo {
    private int quantidadeEixos;

    public Onibus(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, int quantidadeEixos) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel);
        if (quantidadeEixos < 6 || quantidadeEixos > 8) {
            throw new IllegalArgumentException("Ônibus deve ter entre 6 a 8 eixos.");
        }
        this.quantidadeEixos = quantidadeEixos;
    }

    public double calcularAutonomia() {
        return 200 * 5;
    }
}

class CarroEletrico extends Carro {
    private int bateriaKWh;

    public CarroEletrico(String marca, String modelo, int ano, int capacidadePassageiros, String tipoCarro, int bateriaKWh) {
        super(marca, modelo, ano, capacidadePassageiros, "Elétrico", tipoCarro);
        this.bateriaKWh = bateriaKWh;
    }

    public double calcularAutonomia() {
        return bateriaKWh * 5;
    }
}

class CaminhaoRefrigerado extends Caminhao {
    private double temperaturaMinima;

    public CaminhaoRefrigerado(String marca, String modelo, int ano, int capacidadePassageiros, String combustivel, double capacidadeCarga, double temperaturaMinima) {
        super(marca, modelo, ano, capacidadePassageiros, combustivel, capacidadeCarga);
        this.temperaturaMinima = temperaturaMinima;
    }

    public double calcularAutonomia() {
        return super.calcularAutonomia() * 0.9;
    }
}