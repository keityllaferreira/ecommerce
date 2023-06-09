package controller;

import entity.Product;
import service.ProductService;


public class ProductController { //possui métodos que controlam o fluxo da aplicação

    private ProductService productService;




    public Product getProduct() {
        return productService.findAll();
    }

    public Product getProductById(int id){
        return productService.findByid(id);
    }

    public Product addProduct(Product product) {
        return productService.save(product);
    }


    public Product updateProduct( int id, Product product) {
        return productService.update(product, id);
    }

    public void deleteProduct(int id) {
        productService.delete(id);
    }

}
