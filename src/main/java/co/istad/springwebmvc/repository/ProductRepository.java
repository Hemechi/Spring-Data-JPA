package co.istad.springwebmvc.repository;

import co.istad.springwebmvc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByUuid(String uuid);
}
