package co.com.poli.productservice.controller;

import co.com.poli.productservice.persistence.entity.Category;
import co.com.poli.productservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;
    @PostMapping
    public Category save(@RequestBody Category category){
        service.save(category);
        return category;
    }
    @GetMapping
    public List<Category> findAll(){
        return service.findAll();
    }
}

