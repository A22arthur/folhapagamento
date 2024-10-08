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
--EXPLICANDO O CÓDIGO--
Classe FolhaDePagamento

Esta classe contém métodos para calcular diferentes aspectos da folha de pagamento.

Método totalPago(List<Funcionario> funcionarios): Calcula o total pago a todos os funcionários somando seus salários e benefícios. Itera sobre a lista de funcionários e adiciona os valores, retornando o total.

Métodos totalSalario(List<Funcionario> funcionarios) e totalBeneficios(List<Funcionario> funcionarios): Calculam, respectivamente, o total de salários e o total de benefícios, iterando da mesma forma que totalPago.

Método funcionarioComMaiorSalario(List<Funcionario> funcionarios): Encontra o funcionário com o maior salário, incluindo benefícios, comparando o total de cada funcionário.


Classe Funcionario

Essa classe é uma classe abstrata que serve como base para outros tipos de funcionários.

Atributos: Contém informações básicas como nome, cargo, salário base e anos de serviço.

Construtor: Inicializa um funcionário com os dados fornecidos.

Métodos Abstratos: Define calcularSalario() e calcularBeneficios(), que devem ser implementados pelas subclasses.


Classe Gerente

Representa um gerente e estende Funcionario.

Construtor: Define um salário base fixo e um cargo de "Gerente".

Método calcularSalario(): Calcula o salário adicionando um bônus por anos de serviço.

Método calcularBeneficios(): Retorna 0, pois gerentes não têm benefícios definidos.


Classe Secretario

Outra extensão de Funcionario, representando um secretário.

Construtor e Métodos: Similar ao Gerente, mas implementa cálculos diferentes para salário e benefícios.


Classe Vendedor

Representa um vendedor e também estende Funcionario.

Atributos: Inclui um array para armazenar as vendas realizadas.

Construtor e Métodos: Implementa métodos de calcular salário e benefícios, considerando uma comissão sobre as vendas realizadas.


Classe Main

Serve como ponto de entrada do programa.

Inicialização: Cria uma lista de funcionários e adiciona instâncias de Secretario, Vendedor e Gerente.

Cálculos: Chama métodos da classe FolhaDePagamento para calcular totais e imprime os resultados.
