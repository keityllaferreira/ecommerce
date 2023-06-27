package controller;

import entity.Product;
import service.ProductService;

public class ProductController { //possui métodos que controlam o fluxo da aplicação

    private ProductService productService;

    public ProductController (ProductService ProductService){

        this.productService = ProductService;
    }

    public Product getProducts() {

        return productService.findAll();
    }

    public Product getProductById(int id){

        return productService.findByid(id);
    }

    public void addProduct(Product product) {

        productService.save(product);
    }

    public void updateProduct(Product product) {

        productService.update(product);
    }

    public void deleteProduct(int id) {

        productService.delete(id);
    }

}
