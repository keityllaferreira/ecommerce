package repository;

import entity.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository { //responsavel por gerenciar as operacoes de CRUD

    private Set<Integer> productSet = new HashSet<>();



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

    public Set<Integer> findAll(){

        return Collections.unmodifiableSet(productSet);
    }

    public boolean save(Integer product){
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
