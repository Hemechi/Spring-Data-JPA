package co.istad.springwebmvc.repository;

import co.istad.springwebmvc.dto.CategoryResponse;
import co.istad.springwebmvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    // Derived query method - Auto Generated query
    boolean existsByName(String name);

    CategoryResponse findByName(String name);
}
