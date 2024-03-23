package co.istad.springwebmvc.controller;

import co.istad.springwebmvc.dto.CategoryRequest;
import co.istad.springwebmvc.dto.CategoryResponse;
import co.istad.springwebmvc.model.Product;
import co.istad.springwebmvc.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    CategoryResponse findCategoryById(@PathVariable Integer id){
        return categoryService.findCategoryById(id);
    }

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the categories",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Categories not found",
                    content = @Content) })
    @GetMapping
    ResponseEntity<?> findCategories(){
        return ResponseEntity.accepted().body(
                Map.of(
                        "data", categoryService.findCategories()
                )
        );
    }
    @GetMapping("/name/{name}")
    ResponseEntity<?> findCategoryByName(@PathVariable String name) {
        return ResponseEntity.accepted().body(
                Map.of(
                        "data",categoryService.findCategoryByName(name)
                )
        );
    }
    @PostMapping
    void createNewCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        categoryService.createNewCategory(categoryRequest);
    }
    @PutMapping("/{id}")
    CategoryResponse editCategoryById(@PathVariable Integer id, @Valid @RequestBody CategoryRequest categoryRequest){
        return categoryService.editCategoryById(id, categoryRequest);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable Integer id){
        categoryService.deleteById(id);
    }
}
