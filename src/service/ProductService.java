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

    public Product findAll(){ //retorna todos os produtos e realiza as validações necessárias

        return Collections.unmodifiableSet(productRepositoryImpl);
    }

    public boolean save(Product product){ //adiciona um produto novo e e realiza as validações necessárias
        productRepositoryImpl.add(product.getId());
        return true;
    }

    public boolean update(Product product){ //atualiza um produto existente e realiza as validações necessárias
        if (product == productRepositoryImpl) {
            return true;
        }else{
            productRepositoryImpl.add(id.getId());
            return false;
        }
    }

    public boolean delete(int product){ //remove um produto e realiza as validações necessárias
        productRepositoryImpl.delete(product);
        return true;
    }


}
