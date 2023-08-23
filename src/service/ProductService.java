package service;

import entity.Product;
import repository.ProductRepositoryImpl;

import java.util.*;


public class ProductService { //Define métodos que implementam a lógica de negócio da entidade Product.
    private ProductRepositoryImpl productRepositoryImpl; //todo eu ja nao mencionei varias vezes que voce deve depender de abstraçoes e nao de implementaçoes? corrija estude mais sobre, escreva um resumo explicando o que significa, quais os beneficios

//todo para que todo esse espaço


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

        if (productRepositoryImpl == null) {// todo oi? qual o sentido disso aqui?  sera que é essa a validação que voce tinha que fazer aqui nesse lugar? esse o erro?
            throw new IllegalArgumentException("Digite um id válido.");// todo oi? qual o sentido disso aqui?  sera que é essa a validação que voce tinha que fazer aqui nesse lugar? esse o erro?
        }
        return productRepositoryImpl.findAll();
    }

    public boolean save(Product product){ //adiciona um produto novo e e realiza as validações necessárias
        if (productRepositoryImpl == null) {// todo oi? qual o sentido disso aqui?  sera que é essa a validação que voce tinha que fazer aqui nesse lugar? esse o erro?
            throw new IllegalArgumentException("Digite um id válido."); // todo oi? qual o sentido disso aqui?  sera que é essa a validação que voce tinha que fazer aqui nesse lugar? esse o erro?
        }
        productRepositoryImpl.save(product);
        return true;
    }

    public boolean update(Product product){ //atualiza um produto existente e realiza as validações necessárias
        if (product.getId() < 0) {
            throw new IllegalArgumentException("Digite um id válido."); // todo aqui beleza, voce ta validando, faz sentido o que vc ta validando, mas abaixo na linha 50 voce chama o findbyid do repository, sera que nao teria como chamar o do service, que ja faz essa validação e deixar só la???
        }

        if (productRepositoryImpl.findById(product.getId()) == null){ 
            throw new IllegalArgumentException("Digite um id válido."); // todo sera que aqui realmente seria id invalido? pense bem no que aconteceu nesse if, e qual a mensagem de erro apropriada
        }else{
              return productRepositoryImpl.update(product);
        }

    }

    public boolean delete(int product){ //remove um produto e realiza as validações necessárias
        if (productRepositoryImpl == null) {// todo oi? qual o sentido disso aqui?  sera que é essa a validação que voce tinha que fazer aqui nesse lugar? esse o erro?
            throw new IllegalArgumentException("Digite um id válido.");  // todo oi? qual o sentido disso aqui?  sera que é essa a validação que voce tinha que fazer aqui nesse lugar? esse o erro?
        }
        productRepositoryImpl.delete(product);
        return true;
    }


}
