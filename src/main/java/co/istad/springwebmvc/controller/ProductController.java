package co.istad.springwebmvc.controller;

import co.istad.springwebmvc.dto.ProductCreateRequest;
import co.istad.springwebmvc.dto.ProductEditRequest;
import co.istad.springwebmvc.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct(@Valid @RequestBody ProductCreateRequest request){
        System.out.println("Request "+ request);
        productService.createNewProduct(request);
    }

    @PutMapping("/{uuid}")
    void editProductByUuid(@PathVariable String uuid,@RequestBody ProductEditRequest request){
        productService.editProductByUuid(uuid,request);
    }

//    successfully delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @GetMapping
    ResponseEntity<?> findProducts(@RequestParam(required = false, defaultValue = "") String name,
                                     @RequestParam(required = false, defaultValue = "true") Boolean status) {
        //constructor
//        return new ResponseEntity<>( Map.of(
//                "message", "Products have been found",
//                "data", productService.findProducts(name, status)
//        ), HttpStatus.ACCEPTED);

        //builder pattern
        Map<String, Object> data= Map.of(
                "message", "Products have been found",
                "data", productService.findProducts(name,status));
        return ResponseEntity.accepted().body(data);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findProductById(@PathVariable Integer id) {
        return ResponseEntity.accepted().body(
                Map.of(
                        "message", "Product has been found",
                        "data", productService.findProductById(id)
                )
        );
    }

    @GetMapping("/uuid/{uuid}")
    ResponseEntity<?> findProductByUuid(@PathVariable String uuid) {
        return ResponseEntity.accepted().body(
                Map.of(
                        "message", "Product has been found",
                        "data", productService.findProductByUuid(uuid)
                )
        );
    }

}
