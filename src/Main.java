import controller.ProductController;
import entity.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;
import service.ProductService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {


    public static void main(String[] args) throws ParseException {

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


                case 1: //Listar todos os produtos;
                    buscarEListarTodosOsProdutos(productController);
                    break;

                case 2: //Buscar produtos por ID;
                    buscaEListaProdutoPorId(productController, scanner);
                    break;

                case 3: //Adicionar novo produto
                    adicionaProduto(productController, scanner);
                    break;

                case 4: //Atualizar produto
                    atualizaProduto(productController, scanner);
                    break;

                case 5: //Remover produto
                    removeProduto(productController, scanner);
                    break;

                case 6: //sair
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        scanner.close();
    }

    private static void removeProduto(ProductController productController, Scanner scanner) {
        System.out.println("Digite o ID do produto a ser removido:");
        int removeProductId = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        productController.deleteProduct(removeProductId);
    }

    private static void atualizaProduto(ProductController productController, Scanner scanner) throws ParseException {

        Product product = new Product();

        System.out.println("Digite as informações do produto a ser atualizado:");
        System.out.println("- Insira ID do produto a ser atualizado;");
        int novoId = scanner.nextInt();
        product.setId(novoId);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira ID da empresa a ser atualizado;");
        int companyId = scanner.nextInt();
        product.setCompanyId(companyId);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira Código do ID a ser atualizado");
        int codeId = scanner.nextInt();
        product.setCodeId(codeId);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira o nome do produto a ser atualizado;");
        String productName = scanner.nextLine();
        product.setProductName(productName);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira o valor do produto a ser atualizado;");
        double value = scanner.nextDouble();
        product.setValue(value);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira o tipo do produto a ser atualizado;");
        String productType = scanner.nextLine();
        product.setProductType(productType);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira a descrição do produto a ser atualizado;");
        String productDescription = scanner.nextLine();
        product.setProductDescription(productDescription);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira a imagem do produto a ser atualizado;");
        String productImage = scanner.nextLine();
        product.setProductImage(productImage);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira a data da criação do produto a ser atualizado;");
        String creationDate = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(creationDate);
        product.setCreationDate(date);

        productController.updateProduct(product);
    }

    private static void adicionaProduto(ProductController productController, Scanner scanner) throws ParseException {
        Product product = new Product();

        System.out.println("Digite as informações do novo produto:");
        System.out.println("- Insira ID do produto;");
        int novoId = scanner.nextInt();
        product.setId(novoId);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira ID da empresa;");
        int companyId = scanner.nextInt();
        product.setCompanyId(companyId);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira Código do ID");
        int codeId = scanner.nextInt();
        product.setCodeId(codeId);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira o nome do produto;");
        String productName = scanner.nextLine();
        product.setProductName(productName);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira o valor do produto;");
        double value = scanner.nextDouble();
        product.setValue(value);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira o tipo do produto;");
        String productType = scanner.nextLine();
        product.setProductType(productType);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira a descrição do produto");
        String productDescription = scanner.nextLine();
        product.setProductDescription(productDescription);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira a imagem do produto;");
        String productImage = scanner.nextLine();
        product.setProductImage(productImage);
        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("- Insira a data da criação do produto");
        String creationDate = scanner.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(creationDate);
        product.setCreationDate(date);

        productController.addProduct(product);
    }

    private static void buscaEListaProdutoPorId(ProductController productController, Scanner scanner) {
        System.out.println("Digite o ID do produto:");
        int productId = scanner.nextInt();
        Product product = productController.getProductById(productId);
        System.out.println(product);
    }

    private static void buscarEListarTodosOsProdutos(ProductController productController) {
        System.out.println(productController.getProducts());
        System.out.println();
    }

}
