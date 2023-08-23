package repository;

import entity.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository { //responsavel por gerenciar as operacoes de CRUD

    private Set<Product> products = new HashSet<>();


    public Product findById(int id) { //busca um produto pelo seu ID

        Product produtoEncontrado = null;
        for (Product product : products) { // todo se o sentido desse metdo é encontrar um produto com o id especifico, e existe apenas um produto com esse id, pq nao diabos parar o loop e retornar quando encontrar a porra do produto? 
            if (product.getId() == id)
                produtoEncontrado = product;
        }
        return produtoEncontrado;
    }

    public Set<Product> findAll() { //retorna todos os produtos da colecao

        return Collections.unmodifiableSet(products);
    }

    public boolean save(Product product) { //adiciona um novo produto na colecao 
        products.add(product);

// todo e se ja existir produto ?
        return true; // todo faz sentido um metodo que sempre retorna true?
    }

    public boolean update(Product product) { //atualiza um produto existente na colecao
        if (product == products) { //todo esse metodo voce nem testou e validou o resultado pq ele nao faz o menor sentido, serio oq vc tava pensando? vc pensa?
            return true;
        } else {
            products.add(product);
            return false;
        }
    }

    public boolean delete(int product) { //remove um produto da colecao
        products.remove(product);
        return true;// todo faz sentido um metodo que sempre retorna true?
    }


}
