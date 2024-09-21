package modelo;

import java.util.List;

class FolhaDePagamento {

    public static double totalPago(List<Funcionario> funcionarios) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario() + f.calcularBeneficios();
        }
        return total;
    }

    public static double totalSalario(List<Funcionario> funcionarios) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario();
        }
        return total;
    }

    public static double totalBeneficios(List<Funcionario> funcionarios) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            if (f.calcularBeneficios() > 0) {
                total += f.calcularBeneficios();
            }
        }
        return total;
    }

    public static Funcionario funcionarioComMaiorSalario(List<Funcionario> funcionarios) {
        Funcionario maxFuncionario = null;
        double maxSalario = 0;
        for (Funcionario f : funcionarios) {
            double salario = f.calcularSalario() + f.calcularBeneficios();
            if (salario > maxSalario) {
                maxSalario = salario;
                maxFuncionario = f;
            }
        }
        return maxFuncionario;
    }

    public static Funcionario funcionarioComMaiorBeneficio(List<Funcionario> funcionarios) {
        Funcionario maxFuncionario = null;
        double maxBeneficio = 0;
        for (Funcionario f : funcionarios) {
            double beneficio = f.calcularBeneficios();
            if (beneficio > maxBeneficio) {
                maxBeneficio = beneficio;
                maxFuncionario = f;
            }
        }
        return maxFuncionario;
    }

    public static Vendedor vendedorComMaiorVenda(List<Vendedor> vendedores) {
        Vendedor maxVendedor = null;
        double maxVenda = 0;
        for (Vendedor v : vendedores) {
            double totalVendas = v.totalVendas();
            if (totalVendas > maxVenda) {
                maxVenda = totalVendas;
                maxVendedor = v;
            }
        }
        return maxVendedor;
    }
}
	