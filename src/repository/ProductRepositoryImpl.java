package repository;

import entity.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository { //responsavel por gerenciar as operacoes de CRUD

    private Set<Product> products = new HashSet<>();



    public Product findById(int id){ //busca um produto pelo seu ID

        Product produtoEncontrado = null;
        for(Product product: products){
            if (product.getId() == id)
                produtoEncontrado = product;
        }
        return produtoEncontrado;
    }

    public Set<Product> findAll(){ //retorna todos os produtos da colecao

        return Collections.unmodifiableSet(products);
    }

    public boolean save(Product product){ //adiciona um novo produto na colecao
        products.add(product);


        return true;
    }

    public boolean update(Product product){ //atualiza um produto existente na colecao
        if (product == products) {
            return true;
        }else{
                products.add(product);
                return false;
            }
    }

    public boolean delete(int product){ //remove um produto da colecao
        products.remove(product);
        return true;
    }









}
