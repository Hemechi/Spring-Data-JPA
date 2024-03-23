package co.istad.springwebmvc.service;

import co.istad.springwebmvc.dto.ProductCreateRequest;
import co.istad.springwebmvc.dto.ProductEditRequest;
import co.istad.springwebmvc.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createNewProduct(ProductCreateRequest request);
    void editProductByUuid(String uuid, ProductEditRequest request);
    void deleteProductById(Integer id);
    List<ProductResponse> findProducts(String name, Boolean status);

    ProductResponse findProductById(Integer id);

    ProductResponse findProductByUuid(String uuid);
}
