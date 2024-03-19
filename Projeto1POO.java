import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

class Produto {
    private String nome;
    private String categoria;
    private int quantidade;
    private double preco;

    public Produto(String nome, String categoria, int quantidade, double preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}

class SistemaEstoque {
    private ArrayList<Produto> produtos;
    private static final String FILENAME = "estoque.txt";

    public SistemaEstoque() {
        produtos = new ArrayList<>();
        carregarEstoque();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao estoque.");
    }

    public void removerProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produtos.remove(produto);
                System.out.println("Produto removido do estoque.");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    public void consultarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                System.out.println("Nome: " + produto.getNome() + "\nCategoria: " + produto.getCategoria() + "\nQuantidade: " + produto.getQuantidade() + "\nPreço: " + produto.getPreco());
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }
    public void consultarPorCategoria(String categoria) {
        System.out.println("Produtos na categoria " + categoria + ":");
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println("Nome: " + produto.getNome() + "\nQuantidade: " + produto.getQuantidade() + "\nPreço: " + produto.getPreco());
            }
        }
    }
    public void atualizarProduto(String nome, int quantidade, double preco) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.setQuantidade(quantidade);
                produto.setPreco(preco);
                System.out.println("Produto atualizado.");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque.");
    }

    public void ordenarPorNome() {
        Collections.sort(produtos, Comparator.comparing(Produto::getNome));
        System.out.println("Produtos ordenados por nome:");
        mostrarProdutos();
    }

    public void ordenarPorQuantidade() {
        Collections.sort(produtos, Comparator.comparingInt(Produto::getQuantidade));
        System.out.println("Produtos ordenados por quantidade:");
        mostrarProdutos();
    }

    public void ordenarPorPreco() {
        Collections.sort(produtos, Comparator.comparingDouble(Produto::getPreco));
        System.out.println("Produtos ordenados por preço:");
        mostrarProdutos();
    }

    public void mostrarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (Produto produto : produtos) {
                System.out.println("Nome: " + produto.getNome() + "\nCategoria: " + produto.getCategoria() + "\nQuantidade: " + produto.getQuantidade() + "\nPreço: " + produto.getPreco());
            }
        }
    }

    public void salvarEstoque() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Produto produto : produtos) {
                writer.println(produto.getNome() + ";" + produto.getCategoria() + ";" + produto.getQuantidade() + ";" + produto.getPreco());
            }
            System.out.println("Estoque salvo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o estoque.");
        }
    }

    public void removerTodoEstoque() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tem certeza que deseja remover todo o estoque? (s/n)");
        String resposta = scanner.nextLine().trim().toLowerCase();
        if (resposta.equals("s")) {
            produtos.clear();
            System.out.println("Todo o estoque foi removido.");
        } else if (resposta.equals("n")) {
            System.out.println("Operação cancelada.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private void carregarEstoque() {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String[] dados = scanner.nextLine().split(";");
                if (dados.length == 4) {
                    String nome = dados[0];
                    String categoria = dados[1];
                    int quantidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);
                    Produto produto = new Produto(nome, categoria, quantidade, preco);
                    produtos.add(produto);
                }
            }
            System.out.println("Estoque carregado com sucesso.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de estoque não encontrado. Criando um novo arquivo.");
        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("Erro ao carregar o estoque. Os dados no arquivo estão em um formato inválido.");
        }
    }
}

public class Projeto1POO {
    public static void main(String[] args) {
        SistemaEstoque sistema = new SistemaEstoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n ========================================");
            System.out.println("|               MENU DE OPÇÕES           |");
            System.out.println(" ========================================");
            System.out.println("|  1. Adicionar produto                  |");
            System.out.println("|  2. Remover produto                    |");
            System.out.println("|  3. Consultar por categoria            |");
            System.out.println("|  4. Consultar produto                  |");
            System.out.println("|  5. Atualizar produto                  |");
            System.out.println("|  6. Ordenar produtos por nome          |");
            System.out.println("|  7. Ordenar produtos por quantidade    |");
            System.out.println("|  8. Ordenar produtos por preço         |");
            System.out.println("|  9. Mostrar todos os produtos          |");
            System.out.println("|  10. Remover todo o estoque            |");
            System.out.println("|  11. Salvar estoque                    |");
            System.out.println("|  12. Sair                              |");
            System.out.println(" ========================================");
            System.out.print("Escolha uma opção: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    try {
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();
                        System.out.print("Categoria do produto: ");
                        String categoria = scanner.nextLine();
                        System.out.print("Quantidade: ");
                        int quantidade = Integer.parseInt(scanner.nextLine());
                        System.out.print("Preço: ");
                        double preco = Double.parseDouble(scanner.nextLine());
                        if (quantidade < 0 || preco < 0) {
                            System.out.println("Quantidade e preço devem ser valores positivos.");
                            break;
                        }
                        Produto produto = new Produto(nome, categoria, quantidade, preco);
                        sistema.adicionarProduto(produto);
                    } catch (NumberFormatException e) {
                        System.out.println("Formato inválido. Certifique-se de inserir um número para quantidade e preço.");
                    }
                    break;
                case "2":
                    System.out.print("Nome do produto a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    sistema.removerProduto(nomeRemover);
                    break;
                case "3":
                    System.out.print("Categoria a ser consultada: ");
                    String categoriaConsultar = scanner.nextLine();
                    sistema.consultarPorCategoria(categoriaConsultar);
                    break;
                case "4":
                    System.out.print("Nome do produto a ser consultado: ");
                    String nomeConsultar = scanner.nextLine();
                    sistema.consultarProduto(nomeConsultar);
                    break;
                case "5":
                    System.out.print("Nome do produto a ser atualizado: ");
                    String nomeAtualizar = scanner.nextLine();
                    try {
                        System.out.print("Nova quantidade: ");
                        int novaQuantidade = Integer.parseInt(scanner.nextLine());
                        System.out.print("Novo preço: ");
                        double novoPreco = Double.parseDouble(scanner.nextLine());
                        if (novaQuantidade < 0 || novoPreco < 0) {
                            System.out.println("Quantidade e preço devem ser valores positivos.");
                            break;
                        }
                        sistema.atualizarProduto(nomeAtualizar, novaQuantidade, novoPreco);
                    } catch (NumberFormatException e) {
                        System.out.println("Formato inválido. Certifique-se de inserir um número para quantidade e preço.");
                    }
                    break;
                case "6":
                    sistema.ordenarPorNome();
                    break;
                case "7":
                    sistema.ordenarPorQuantidade();
                    break;
                case "8":
                    sistema.ordenarPorPreco();
                    break;
                case "9":
                    sistema.mostrarProdutos();
                    break;
                case "10":
                    sistema.removerTodoEstoque();
                    break;
                case "11":
                    sistema.salvarEstoque();
                    break;
                case "12":
                    System.out.println("Saindo do sistema.");
                    sistema.salvarEstoque();
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}