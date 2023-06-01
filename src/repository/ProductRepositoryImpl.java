package repository;

import entity.Product;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository { //responsavel por gerenciar as operacoes de CRUD

    private Set<Product> productSet = new HashSet<>();



    public Product findById(int id){ //busca um produto pelo seu ID

        Product produtoEncontrado = null;
        Product[] produtos = new Product[0];
        for(Product product: produtos){
            if (product.getId() == id){
                produtoEncontrado = product;
            }
        }
        return produtoEncontrado;
    }

    public Set<Product> findAll(){
        return Collections.unmodifiableSet(productSet);
    }

    public boolean save(Product product){
        productSet.add(product);
        return true;
    }

    public boolean update(Product product, int id){
        if (product == productSet){
            else{
                productSet.add(id);
            }
        }
    }

    public boolean delete(Product product){
        productSet.remove(product);
        return true;
    }









}
