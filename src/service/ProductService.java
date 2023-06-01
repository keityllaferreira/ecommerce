package service;

import entity.Product;
import repository.ProductRepository;

import java.util.Collections;

public class ProductService {
    ProductRepository productRepository;

    public Product findByid(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("Digite um id válido.");
        }

        Product produtoLocalizado = null;
        Product[] produtos = new Product[0]; //a variável produtos é um array.
        for (Product product : produtos) {
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

    public Product findAll(){

        return Collections.unmodifiableSet();
    }


}
