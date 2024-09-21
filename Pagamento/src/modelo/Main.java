package modelo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Secretario("Jorge Carvalho", 6));
        funcionarios.add(new Secretario("Maria Souza", 8));
        funcionarios.add(new Vendedor("Ana Silva", 2, new double[]{5200, 4000, 4200, 5850, 7000}));
        funcionarios.add(new Vendedor("João Mendes", 2, new double[]{3400, 7700, 5000, 5900, 6500}));
        funcionarios.add(new Gerente("Juliana Alves", 7));
        funcionarios.add(new Gerente("Bento Albino", 10));

        // Cálculos
        double totalPago = FolhaDePagamento.totalPago(funcionarios);
        System.out.println("Total pago: R$ " + totalPago);

        double totalSalario = FolhaDePagamento.totalSalario(funcionarios);
        System.out.println("Total salário: R$ " + totalSalario);

        double totalBeneficios = FolhaDePagamento.totalBeneficios(funcionarios);
        System.out.println("Total benefícios: R$ " + totalBeneficios);

        Funcionario maxSalario = FolhaDePagamento.funcionarioComMaiorSalario(funcionarios);
        System.out.println("Funcionário com maior salário: " + maxSalario.nome);

        Funcionario maxBeneficio = FolhaDePagamento.funcionarioComMaiorBeneficio(funcionarios);
        System.out.println("Funcionário com maior benefício: " + maxBeneficio.nome);

        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add((Vendedor) funcionarios.get(2)); // Ana Silva
        vendedores.add((Vendedor) funcionarios.get(3)); // João Mendes

        Vendedor maxVendas = FolhaDePagamento.vendedorComMaiorVenda(vendedores);
        System.out.println("Vendedor com maior venda: " + maxVendas.nome);
    }
}
