package modelo;

class Vendedor extends Funcionario {
    private double[] vendas;

    Vendedor(String nome, int anosDeServico, double[] vendas) {
        super(nome, "Vendedor", 12000.00, anosDeServico);
        this.vendas = vendas;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (1800.00 * anosDeServico) + calcularComissao();
    }

    private double calcularComissao() {
        double totalVendas = 0;
        for (double venda : vendas) {
            totalVendas += venda;
        }
        return 0.30 * totalVendas;
    }

    @Override
    public double calcularBeneficios() {
        return (1800.00 * anosDeServico);
    }
    
    public double totalVendas() {
        double total = 0;
        for (double venda : vendas) {
            total += venda;
        }
        return total;
    }
}
