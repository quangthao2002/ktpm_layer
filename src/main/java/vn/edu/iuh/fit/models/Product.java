package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.services.OrderProduct;

@Entity @Getter @Setter @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "product_name", nullable = false, length = 100)
    private String name;
    private String description;
    @Column(name = "quantity_in_stock")
    private long quantityInStock;

    public Product(String name, String description, long quantityInStock) {
        this.name = name;
        this.description = description;
        this.quantityInStock = quantityInStock;
    }
}
