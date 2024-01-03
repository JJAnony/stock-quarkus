package br.com.udemy.service;

import br.com.udemy.domain.model.Product;
import br.com.udemy.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    public List<Product> list() {
        return this.repository.findAll().stream().toList();
    }

    public Product getById(Long id){
        return this.repository.findById(id);
    }


    @Transactional
    public void save(Product product){
        this.repository.persist(product);
    }


    public void delete(Long id){
        Product product = this.getById(id);
        this.repository.delete(product);
    }


}
