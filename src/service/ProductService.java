package service;

import entity.Product;
import repository.ProductRepository;

import java.util.*;


public class ProductService { //Define métodos que implementam a lógica de negócio da entidade Product.
    private ProductRepository productRepository; //interface
    Set<Integer> productSet = new HashSet<Integer>();

    public ProductService(ProductRepository productRepository){

        this.productRepository = productRepository;
    }

    public Product findByid(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Digite um id válido.");
        }

        Product produtoLocalizado = null;


        List<Product> products = new ArrayList<>();
        for (Product product : products) {
            if (product.getId() == id) {
                produtoLocalizado = product;
                break;
            }
        }

        if (produtoLocalizado == null) {
            throw new RuntimeException("Produto não localizado.");
        }

        return produtoLocalizado;
    }

    public Product findAll(){ //retorna todos os produtos

        return Collections.unmodifiableSet(productSet);
    }

    public Product save(Product product){
        productSet.add(product.getId());
        return true;
    }

    public Product update(Product product, int id){
        if (product == productSet) {
            return true;
        }else{
            productSet.add(id);
            return false;
        }
    }

    public boolean delete(int product){
        productSet.remove(product);
        return true;
    }


}
