package br.com.udemy.service;

import br.com.udemy.domain.dto.EntryDTO;
import br.com.udemy.domain.model.Entry;
import br.com.udemy.domain.model.Product;
import br.com.udemy.repository.EntryRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EntryService {


    @Inject
    private EntryRepository repository;
    
    @Inject
    private ProductService productService;

    public List<EntryDTO> list() {
        return this.repository.findAll()
                .stream()
                .map(value -> new EntryDTO(value))
                .toList();
    }

    @Transactional
    public void save(EntryDTO dto){
        Product product = this.productService.getById(dto.getProductId());
        product.setAmout(product.getAmout() + dto.getAmout());

        Entry entry = new Entry(dto, product);
        this.repository.persist(entry);
    }




}
