package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter
@Setter
@NoArgsConstructor
public class ProductOrder {

    @Id
    @Column(name = "order_id")
    private long id;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "status", nullable = false)
    private String status;

    public ProductOrder(String customerId, Product product, long quantity, String status) {
        this.customerId = customerId;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }
}
