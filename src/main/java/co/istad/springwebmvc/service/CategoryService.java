package co.istad.springwebmvc.service;

import co.istad.springwebmvc.dto.CategoryRequest;
import co.istad.springwebmvc.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    void deleteById(Integer id);
    CategoryResponse editCategoryById(Integer id,CategoryRequest request);
    void createNewCategory(CategoryRequest request);
    CategoryResponse findCategoryByName(String name);
    CategoryResponse findCategoryById(Integer id);
    List<CategoryResponse> findCategories();
}
