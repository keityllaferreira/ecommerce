package service;

import entity.Product;
import repository.ProductRepositoryImpl;

import java.util.*;


public class ProductService { //Define métodos que implementam a lógica de negócio da entidade Product.
    private ProductRepositoryImpl productRepositoryImpl;




    public ProductService(ProductRepositoryImpl productRepositoryImpl){

        this.productRepositoryImpl = productRepositoryImpl;
    }

    public Product findByid(int id) { //busca um produto pelo id e realiza as validações necessárias

        if (id <= 0) {
            throw new IllegalArgumentException("Digite um id válido.");
        }

        return productRepositoryImpl.findById(id);
    }

    public Set<Product> findAll(){ //retorna todos os produtos e realiza as validações necessárias

        if (productRepositoryImpl == null) {
            throw new IllegalArgumentException("Digite um id válido.");
        }
        return productRepositoryImpl.findAll();
    }

    public boolean save(Product product){ //adiciona um produto novo e e realiza as validações necessárias
        if (productRepositoryImpl == null) {
            throw new IllegalArgumentException("Digite um id válido.");
        }
        productRepositoryImpl.save(product);
        return true;
    }

    public boolean update(Product product){ //atualiza um produto existente e realiza as validações necessárias
        if (product.getId() < 0) {
            throw new IllegalArgumentException("Digite um id válido.");
        }

        if (productRepositoryImpl.findById(product.getId()) == null){
            throw new IllegalArgumentException("Digite um id válido.");
        }else{
              return productRepositoryImpl.update(product);
        }

    }

    public boolean delete(int product){ //remove um produto e realiza as validações necessárias
        if (productRepositoryImpl == null) {
            throw new IllegalArgumentException("Digite um id válido.");
        }
        productRepositoryImpl.delete(product);
        return true;
    }


}
