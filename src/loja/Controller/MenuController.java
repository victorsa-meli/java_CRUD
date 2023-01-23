package loja.Controller;
import loja.Entity.Produto;

import java.util.ArrayList;
import java.util.Scanner;



public class MenuController {

    static Scanner sc = new Scanner(System.in);

    private static ArrayList<Produto> produtos;


    public static void main(String[] args) {
        produtos = new ArrayList<>();
        produtos.add(new Produto(0, "Padrao 0",1.0));
        produtos.add(new Produto(1, "Padrao 1",1.0));
        produtos.add(new Produto(2, "Padrao 2",1.0));
        produtos.add(new Produto(3, "Padrao 3",1.0));
        produtos.add(new Produto(4, "Padrao 4",1.0));
        produtos.add(new Produto(5, "Padrao 5",1.0));
        produtos.add(new Produto(6, "Padrao 6",1.0));
        produtos.add(new Produto(7, "Padrao 7",1.0));
        produtos.add(new Produto(8, "Padrao 8",1.0));
        produtos.add(new Produto(9, "Padrao 9",1.0));
        produtos.add(new Produto(10, "Padrao 10",1.0));


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
        System.out.println("      2 - LISTAR                                   ");
        System.out.println("      3 - ALTERAR                                  ");
        System.out.println("      4 - EXCLUIR                                  ");
        System.out.println("      5 - SAIR                                     ");
        System.out.println("___________________________________________________");

        int option = sc.nextInt();

        switch (option) {
            case 1:
               cadastrarProduto();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
               alterarProduto();
                break;

            case 4:
                excluirProduto();
                break;

            case 5:
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
        String nome = sc.next().toUpperCase();

        System.out.print("Digite ID do produto:  ");
        Integer id = sc.nextInt();

        System.out.print("\nDigite o preco do produto:  \n");
        Double preco = sc.nextDouble();


        Produto produto = new  Produto(id, nome, preco);
        produtos.add(produto);


        System.out.println(produto.getNome() + "Foi cadastrado com sucesso !");
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
            String nome = sc.next().toUpperCase();

            System.out.print("\nDigite o preco do produto:  \n");
            Double preco = sc.nextDouble();


            Integer id = ids;

            for (Produto p : produtos){
                if(p.getId() == ids){
                    produtos.set(ids,new Produto(id,nome,preco));

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
