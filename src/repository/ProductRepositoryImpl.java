package repository;

import entity.Product;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository { //responsavel por gerenciar as operacoes de CRUD

    private Set<Product> productSet = new HashSet<>();



    public Product findById(int id){ //busca um produto pelo seu ID

        Product produtoEncontrado = null;
        for(Product product: productSet){
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
        if (product == productSet) {
            return true;
        }else{
                productSet.add(id);
                return false;
            }
    }

    public boolean delete(Product product){
        productSet.remove(product);
        return true;
    }









}
