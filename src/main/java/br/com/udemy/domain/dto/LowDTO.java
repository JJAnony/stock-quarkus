package br.com.udemy.domain.dto;

import br.com.udemy.domain.model.Low;

public class LowDTO {

    private Long id;

    private Long productId;

    private Double amout;

    public LowDTO() {
    }


    public LowDTO(Low low) {
        this.id = low.getId();
        this.productId = low.getProduct().getId();
        this.amout = low.getAmout();
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
