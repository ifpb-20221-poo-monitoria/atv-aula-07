package ct03;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Menu {

    private static int count = 1;
    private static List<Conta> contas = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Escolha:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Verificar Saldo");
            System.out.println("3 - Sacar");
            System.out.println("4 - Depositar");
            System.out.println("0 - Sair");
            Scanner in = new Scanner(System.in);
            int opt = in.nextInt();
            in.nextLine();

            switch (opt) {
                case 1:
                    int num = criarConta(in);
                    System.out.println("O numero da conta criada é: " + num);
                    break;
                case 2:
                    verificarSaldo(in);
                    break;
                case 3:
                    sacar(in);
                    break;
                case 4:
                    depositar(in);
                    break;
                case 0:
                    System.out.println("BYE");
                    return;
                default:
                    System.out.println("Opção invalida");
            }
        }

    }

    private static void depositar(Scanner in){
        Conta conta = getAcc(in);
        System.out.println("Digite o valor: ");
        double valor = in.nextDouble();
        in.nextLine();
        conta.depositar(valor);
    }

    private static void sacar(Scanner in){
        Conta conta = getAcc(in);
        System.out.println("Digite o valor: ");
        double valor = in.nextDouble();
        in.nextLine();
        if(conta.sacar(valor)){
            System.out.println("Saque realizado com sucesso!");
        }else{
            System.out.println("Saque não pode ser realizado :V");
        }
    }

    private static int criarConta(Scanner in){
        System.out.println("1 - Conta Poupança\n2-Conta Especial");
        int type = in.nextInt();
        in.nextLine();
        System.out.println("Digite o nome: ");
        String nome = in.nextLine();
        System.out.println("Digite o cpf: ");
        String cpf = in.nextLine();
        System.out.println("Digite o saldo inicial: ");
        double saldo = in.nextDouble();
        in.nextLine();
        Conta conta = type==1? new ContaPoupanca() : new ContaEspecial();
        Cliente cli = new Cliente(nome,cpf);
        conta.setTitular(cli);
        conta.depositar(saldo);
        int numero = count++;
        conta.setNumero(numero);
        contas.add(conta);
        return numero;
    }

    private static void verificarSaldo(Scanner in){
        System.out.println("Numero da conta: ");
        int numero = in.nextInt();
        in.nextLine();

        contas.forEach(value ->{
            if (value.getNumero() == numero){
                System.out.println("Saldo é: "+value.getSaldo());
            }
        });

    }

    private static Conta getAcc(Scanner in){
        System.out.println("Numero da conta: ");
        int numero = in.nextInt();
        return contas.stream().filter(item ->{
            return item.getNumero() == numero;
        }).collect(Collectors.toList()).get(0);
    }
}
