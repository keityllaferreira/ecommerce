package service;

import entity.Product;
import repository.ProductRepository;

import java.util.Collections;
import java.util.Set;



public class ProductService {
    ProductRepository productRepository;
    Product product;
    public Product findByid(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Digite um id válido.");
        }

        Product produtoLocalizado = null;

        for (Product product : ) {
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
