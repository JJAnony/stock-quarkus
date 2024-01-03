package br.com.udemy.service;

import br.com.udemy.domain.dto.LowDTO;
import br.com.udemy.domain.exeption.AmoutException;
import br.com.udemy.domain.model.Low;
import br.com.udemy.domain.model.Product;
import br.com.udemy.repository.LowRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class LowService {

    @Inject
    private LowRepository repository;

    @Inject
    private ProductService productService;

    public List<LowDTO> list() {
        return this.repository.findAll()
                .stream()
                .map(value -> new LowDTO(value))
                .toList();
    }

    @Transactional
    public void save(LowDTO dto){
        Product product = this.productService.getById(dto.getProductId());

        if((product.getAmout() - dto.getAmout()) < 0){
            throw new AmoutException();
        }

        product.setAmout(product.getAmout() - dto.getAmout());

        Low low = new Low(dto, product);
        this.repository.persist(low);
    }
}
