package modelo;

abstract class Funcionario {
    String nome;
    String cargo;
    double salarioBase;
    int anosDeServico;

    Funcionario(String nome, String cargo, double salarioBase, int anosDeServico) {
        this.nome = nome;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.anosDeServico = anosDeServico;
    }

    public abstract double calcularSalario();
    public abstract double calcularBeneficios();
}
