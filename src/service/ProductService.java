package service;

import entity.Product;
import repository.ProductRepository;

import java.util.*;


public class ProductService { //Define métodos que implementam a lógica de negócio da entidade Product.
    private ProductRepository productRepository; //interface
    Product product;

    Set<Integer> productSet = new HashSet<Integer>();

    public ProductService(ProductRepository productRepository){

        this.productRepository = productRepository;
    }

    public Product findByid(int id) {

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

    public Set<Integer> findAll(){ //retorna todos os produtos

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
