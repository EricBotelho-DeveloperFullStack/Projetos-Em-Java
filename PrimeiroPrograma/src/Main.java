import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        String nome_usuario;
        String email_usuario;
        String senha_usuario;

        System.out.println("--- CAMPO DE REGISTRO ---");
        System.out.print("Nome: ");
            nome_usuario = sc.nextLine();
        System.out.print("Email: ");
            email_usuario = sc.nextLine();
        System.out.print("Senha: ");
            senha_usuario = sc.nextLine();
            
        System.out.println("--- RESGISTRO CRIADO COM SUCESSO ---");
        System.out.println(" ");

        System.out.println("--- SEJA BEM-VINDO SENHOR(A) " + nome_usuario + " AO SISTEMA DE COMPRAS ---");
        System.out.println(" ");

        int N, quant_parcelas;
        double total_compras = 0.0;
        double valor_pagamento;
        double troco_pagamento;
        double valor_parcela;
        char opcao_pagamento;

        System.out.print("Quantos produtos está sendo comprado? ");
            N = sc.nextInt();
        sc.nextLine();
        System.out.println(" ");

        String[] produtos = new String[N];
        int[] quantidade_produtos = new int[N];
        double[] preco_produto = new double[N];
        double[] calculo_produtos = new double[N];

        System.out.println("-- DADOS DA SUA COMPRA --");
        System.out.println(" ");

        for (int i = 0; i < N; i++) {
            System.out.print("Informe o "+ (i + 1) +"º produto: ");
                produtos[i] = sc.nextLine();
            System.out.print("Informe quantas unidades o produto "+ produtos[i] + " está sendo comprado: ");
                quantidade_produtos[i] = sc.nextInt();
            System.out.print("Informe o preço da unidade do produto "+ produtos[i] +": R$");
                preco_produto[i] = sc.nextDouble();
            sc.nextLine();
        }

        System.out.println(" ");
        for (int i = 0; i < N; i++) {
            System.out.print("Preço total do produto "+ produtos[i] +": R$");

            calculo_produtos[i] = preco_produto[i] * quantidade_produtos[i];

            System.out.println(String.format("%.2f", calculo_produtos[i]));
        }

        for (int i = 0; i < N; i++) {
            total_compras += calculo_produtos[i];
        }

        System.out.println(" ");
        System.out.println("O total da sua compra é: R$"+ String.format("%.2f", total_compras));
        System.out.print(" ");

        System.out.print("Qual o valor de pagamento? R$");
            valor_pagamento = sc.nextDouble();

        while (valor_pagamento < total_compras) {
            System.out.print("Valor insuficiente! Digite novamente o valor de pagamento: R$");
                valor_pagamento = sc.nextDouble();
        }

        System.out.println(" ");
        System.out.println("-- Escolha umas das opções abaixo --");
        System.out.println("A - A vista ");
        System.out.println("P - Parcelamento ");
        System.out.println(" ");
        System.out.print("Qual opção deseja? ");
            opcao_pagamento = sc.next().charAt(0);

        switch (opcao_pagamento) {
            case 'A':
                    if (valor_pagamento == total_compras) {
                        System.out.println(" ");
                        System.out.println("Pagamento Concluido!");
                    }
                    else if ( valor_pagamento > total_compras) {
                        troco_pagamento = valor_pagamento - total_compras;

                        System.out.println(" ");
                        System.out.println("Pagamento Concluido!");
                        System.out.println("Seu troco ficou no valor de: R$"+ String.format("%.2f", troco_pagamento));
                    }
                break;
            case 'P':
                System.out.println(" ");
                    System.out.print("Em quantas vezes deseja parcelar a sua compra? ");
                        quant_parcelas = sc.nextInt();

                    valor_parcela = valor_pagamento / quant_parcelas;
                System.out.println(" ");
                    System.out.println("Pagamento Concluido!");
                    System.out.println("A compra foi Parcelada em "+ quant_parcelas +
                            " vezes no valor de R$"+ String.format("%.2f", valor_parcela));
                break;
        }
      sc.close();
    }
}