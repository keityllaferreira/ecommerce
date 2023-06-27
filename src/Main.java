import controller.ProductController;
import entity.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;


import java.util.List;
import java.util.Scanner;


public class Main {

    

    public static void main(String[] args) {

       Product product = new Product();

        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();

        ProductController productController = new ProductController(new ProductService(productRepositoryImpl));

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1. Listar todos os produtos;");
            System.out.println("2. Buscar produtos por ID;");
            System.out.println("3. Adicionar novo produto;");
            System.out.println("4. Atualizar produto;");
            System.out.println("5. Remover produto;");
            System.out.println("6. Sair.");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                 product = productController.getProducts();
                    System.out.println(product);
                    break;
                case 2:

                    System.out.println("Digite o ID do produto:");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    product = productController.getProductById(productId);
                    break;
                case 3:

                    System.out.println("Digite as informações do novo produto:");

                    Product newProduct = new Product();
                    productController.addProduct(newProduct);
                    break;
                case 4:

                    System.out.println("Digite as informações do produto a ser atualizado:");

                    Product updatedProduct = new Product();
                    productController.updateProduct(updatedProduct);
                    break;
                case 5:

                    System.out.println("Digite o ID do produto a ser removido:");
                    int removeProductId = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    productController.deleteProduct(removeProductId);
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        scanner.close();
    }


}
