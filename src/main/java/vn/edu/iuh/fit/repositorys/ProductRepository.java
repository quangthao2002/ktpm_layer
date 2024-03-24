package vn.edu.iuh.fit.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
     Product findByName(String name);
}