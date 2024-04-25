package co.com.poli.productservice.controller;


import co.com.poli.productservice.persistence.entity.Category;
import co.com.poli.productservice.persistence.entity.Product;
import co.com.poli.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    @PostMapping
    public Product save(@RequestBody Product product){
        service.save(product);
        return product;
    }
    @DeleteMapping("/{id}")
    public Product delete(@PathVariable("id") Long id){
        Product product = service.findById(id);
        service.delete(product);
        return product;
    }
    @GetMapping
    public List<Product> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    @GetMapping("/category/{id}")
    public List<Product> findByCategory(@PathVariable("id") Long id){
        Category category = new Category();
        category.setId(id);
        return service.findByCategory(category);
    }
}
