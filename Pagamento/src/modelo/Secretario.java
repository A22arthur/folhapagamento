package modelo;

class Secretario extends Funcionario {
    Secretario(String nome, int anosDeServico) {
        super(nome, "Secretário", 7000.00, anosDeServico);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (1000.00 * anosDeServico) + (0.20 * salarioBase);
    }

    @Override
    public double calcularBeneficios() {
        return (1000.00 * anosDeServico) + (0.20 * salarioBase);
    }
}
	