package repository;

import entity.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository { //responsavel por gerenciar as operacoes de CRUD

    private Set<Product> products = new HashSet<>();



    public Integer findById(int id){ //busca um produto pelo seu ID

        Integer produtoEncontrado = null;
        List<Product> products = new ArrayList<>();
        for(Product product: products){
            if (product.getId() == id){
                produtoEncontrado = id;
            }
        }
        return produtoEncontrado;
    }

    public Set<Product> findAll(){

        return Collections.unmodifiableSet(products);
    }

    public boolean save(int product){
        products.add(product);
        return true;
    }

    public boolean update(Product product, int id){
        if (product == products) {
            return true;
        }else{
                products.add(id);
                return false;
            }
    }

    public boolean delete(int product){
        products.remove(product);
        return true;
    }









}
