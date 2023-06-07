package service;

import entity.Product;
import repository.ProductRepository;

import java.util.Collections;
import java.util.Set;



public class ProductService { //Define métodos que implementam a lógica de negócio da entidade Product.
    private ProductRepository productRepository; //interface
    Product product;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findByid(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Digite um id válido.");
        }

        Product produtoLocalizado = null;


        Product[] products = new Product[];
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

    public Set<Product> findAll(){

        return Collections.unmodifiableSet(product);
    }


}
