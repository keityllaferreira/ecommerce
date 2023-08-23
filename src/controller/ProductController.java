package controller;

import entity.Product;
import service.ProductService;

import java.util.Set;

public class ProductController { //possui métodos que controlam o fluxo da aplicação

    private final ProductService productService;

    public ProductController (ProductService ProductService){

        this.productService = ProductService;
    }

    public Set<Product> //todo: pq esse cara está aqui? ele esta sendo usado? faz parte dessa camada ter esse atributo?


    getProducts() { //retona todos os produtos cadastrados na aplicação

        return productService.findAll();
    }

    public Product getProductById(int id){ //retorna o produto com o id especificado.

        return productService.findByid(id);
    }

    public void addProduct(Product product) { //adiciona um novo produto na aplicação

        productService.save(product);
    }

    public void updateProduct(Product product) { //atualiza um produto existente na aplicacao

        productService.update(product);
    }

    public void deleteProduct(int id) { //remove um produto existente na aplicacao

        productService.delete(id);
    }

}
