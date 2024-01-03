package br.com.udemy.domain.dto;

import br.com.udemy.domain.model.Entry;

public class EntryDTO {

    private Long id;

    private Long productId;

    private Double amout;


    public EntryDTO() {
    }


    public EntryDTO(Entry entry) {
        this.id = entry.getId();
        this.productId = entry.getProduct().getId();
        this.amout = entry.getAmout();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getAmout() {
        return amout;
    }

    public void setAmout(Double amout) {
        this.amout = amout;
    }
}
