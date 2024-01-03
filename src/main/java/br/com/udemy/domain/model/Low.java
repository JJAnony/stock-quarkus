package br.com.udemy.domain.model;

import br.com.udemy.domain.dto.LowDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Low {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "product_id_fk"))
    private Product product;

    private Date date;

    private Double amout;


    public Low() {
    }

    public Low(LowDTO dto, Product product) {
        this.id = dto.getId();
        this.product = product;
        this.date = new Date();
        this.amout = dto.getAmout();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmout() {
        return amout;
    }

    public void setAmout(Double amout) {
        this.amout = amout;
    }
}
