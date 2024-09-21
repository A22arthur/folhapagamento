package modelo;

class Gerente extends Funcionario {
    Gerente(String nome, int anosDeServico) {
        super(nome, "Gerente", 20000.00, anosDeServico);
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (3000.00 * anosDeServico);
    }

    @Override
    public double calcularBeneficios() {
        return 0; // Sem benefícios
    }
}
