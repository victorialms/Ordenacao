package ordenacao;

import java.util.Scanner;

class Produto {
    String nome;
    int codigo;
    double preco;

    Produto(String nome, int codigo, double preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$ " + preco;
    }
}

public class Produtos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[10];

        for (int i = 0; i < produtos.length; i++) {
            System.out.print("Código do produto " + (i + 1) + ": ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Nome do produto " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Preço do produto " + (i + 1) + ": ");
            double preco = scanner.nextDouble();
            scanner.nextLine(); 

            produtos[i] = new Produto(nome, codigo, preco);
        }

        // A
        System.out.println("\nProdutos ordenados por código: ");
        Produto[] ordenadoPorCodigo = produtos.clone();
        for (int i = 0; i < ordenadoPorCodigo.length - 1; i++) {
            for (int j = 0; j < ordenadoPorCodigo.length - 1 - i; j++) {
                if (ordenadoPorCodigo[j].codigo > ordenadoPorCodigo[j + 1].codigo) {
                    Produto temp = ordenadoPorCodigo[j];
                    ordenadoPorCodigo[j] = ordenadoPorCodigo[j + 1];
                    ordenadoPorCodigo[j + 1] = temp;
                }
            }
        }
        for (Produto produto : ordenadoPorCodigo) {
            System.out.println(produto);
        }

        // B
        System.out.println("\nProdutos ordenados por preço:");
        Produto[] ordenadoPorPreco = produtos.clone();
        for (int i = 0; i < ordenadoPorPreco.length - 1; i++) {
            for (int j = 0; j < ordenadoPorPreco.length - 1 - i; j++) {
                if (ordenadoPorPreco[j].preco > ordenadoPorPreco[j + 1].preco) {
                    Produto temp = ordenadoPorPreco[j];
                    ordenadoPorPreco[j] = ordenadoPorPreco[j + 1];
                    ordenadoPorPreco[j + 1] = temp;
                }
            }
        }
        for (Produto produto : ordenadoPorPreco) {
            System.out.println(produto);
        }

        scanner.close();
    }
}
