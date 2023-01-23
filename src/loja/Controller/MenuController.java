package loja.Controller;
import loja.Entity.Produto;

import java.util.ArrayList;
import java.util.Scanner;



public class MenuController {

    static Scanner sc = new Scanner(System.in);

    private static ArrayList<Produto> produtos;


    public static void main(String[] args) {
        produtos = new ArrayList<>();
        produtos.add(new Produto(0, "Parafuso 9mm 0",1.0, 150));
        produtos.add(new Produto(1, "Veda-Rosca 20m",1.0, 60));
        produtos.add(new Produto(2, "Fita-Isolante 50m",1.0, 70));
        produtos.add(new Produto(3, "Prego 3mm",1.0, 65));
        produtos.add(new Produto(4, "Fio de cobre 10m",1.0, 10));
        produtos.add(new Produto(5, "Chapa 1x1m",1.0, 30));
        produtos.add(new Produto(6, "Bucha",1.0, 90));
        produtos.add(new Produto(7, "Cimento 50kg",1.0, 75));
        produtos.add(new Produto(8, "Bloco de concreto 4 furos",1.0, 1560));



        menu();
    }

    public static void menu() {

        System.out.println("___________________________________________________");
        System.out.println("           CONTROLE DE ESTOQUE                     ");
        System.out.println("                                                   ");
        System.out.println("                                                   ");
        System.out.println("     SELECIONE UMA OP QUE DESEJA REALIZAR          ");
        System.out.println("                                                   ");
        System.out.println("      1 - CADASTRAR                                ");
        System.out.println("      2 - BUSCAR PRODUTO                           ");
        System.out.println("      3 - LISTAR                                   ");
        System.out.println("      4 - ALTERAR                                  ");
        System.out.println("      5 - EXCLUIR                                  ");
        System.out.println("      6 - SAIR                                     ");
        System.out.println("___________________________________________________");

        int option = sc.nextInt();

        switch (option) {
            case 1:
               cadastrarProduto();
                break;
            case 2:
                buscarProduto();
                break;
            case 3:
                listarProdutos();
                break;
            case 4:
               alterarProduto();
                break;

            case 5:
                excluirProduto();
                break;

            case 6:
                System.out.println(" Obrigado pela preferencia !! ");
                System.exit(0);
            default:
                System.out.println("Opção invalida ! ");
                menu();
                break;
        }
    }

    private static void cadastrarProduto() {



        System.out.print("Digite o nome do produto:  ");
        String nome = sc.skip("\\R?").nextLine().toUpperCase();

        System.out.print("Digite ID do produto:  ");
        Integer id = sc.nextInt();

        System.out.print("\nDigite o preco do produto:  \n");
        Double preco = sc.nextDouble();

        System.out.print("\nDigite a quantidade do produto:  \n");
        Integer quantidade = sc.nextInt();


        Produto produto = new  Produto(id, nome, preco, quantidade);
        produtos.add(produto);


        System.out.println(produto.getNome() + "Foi cadastrado com sucesso !");
        menu();
    }


    private static void buscarProduto() {
        if (produtos.size() > 0) {

            System.out.println("Digite o ID do produto: ");
            int ids = sc.nextInt();
            for (Produto p : produtos) {
                if(p.getId() == ids){
                    System.out.println(p);
                }




            }
        } else System.out.println("Não há produtos cadastrados");

        menu();

    }

    private static void listarProdutos() {
        if (produtos.size() > 0) {

            for (Produto p : produtos) {
                System.out.println("Posicao: "+produtos.indexOf(p)+ "\n");
                System.out.println(p);



            }
        } else System.out.println("Não há produtos cadastrados");

        menu();

    }


   private static void alterarProduto(){
        if(produtos.size()>0){

            System.out.println("          PRODUTOS DISPONIVEIS              ");
            for (Produto p : produtos) {

                System.out.println("Posicao: "+produtos.indexOf(p)+ "\n");
                System.out.println(p);
            }
            int ids = sc.nextInt();

            System.out.print("Digite o nome do produto:  ");
            String nome = sc.skip("\\R?").nextLine().toUpperCase();

            System.out.print("\nDigite o preco do produto:  \n");
            Double preco = sc.nextDouble();

            System.out.print("\nDigite a quantidade do produto:  \n");
            Integer quantidade = sc.nextInt();


            Integer id = ids;

            for (Produto p : produtos){
                if(p.getId() == ids){
                    produtos.set(ids,new Produto(id,nome,preco, quantidade));

                    System.out.println(p.getNome() + " Produto Alterado!!");
                    menu();
                }
            }
        }else System.out.println("Nenhum Produto cadastrado!!");
    }

    private static void excluirProduto(){
        if(produtos.size()>0){

            System.out.println("          PRODUTOS DISPONIVEIS              ");
            for (Produto p : produtos) {
                System.out.println(produtos.indexOf(p));
                System.out.println(p + "\n");
            }
            int id = sc.nextInt();

            for (Produto p : produtos){
                if( p.getId() == id){
                    produtos.remove(p);
                    System.out.println(p.getNome() + " Removido.");
                    menu();
                }
            }
        }else System.out.println("Nenhum Produto cadastrado!!");
    }






}
