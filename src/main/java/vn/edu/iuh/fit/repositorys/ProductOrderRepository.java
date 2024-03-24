package vn.edu.iuh.fit.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.ProductOrder;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{
}
