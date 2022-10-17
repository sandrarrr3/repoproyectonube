package com.G42_Proyecto.G42_Proyecto.Controller;


import com.G42_Proyecto.G42_Proyecto.Service.CategoryService;
import com.G42_Proyecto.G42_Proyecto.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();       
    }
    
        @GetMapping("{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId);       
    }
    
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update (@RequestBody Category c){ return categoryService.update(c);}
    
    @PostMapping("/save")
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
        
    }
    
}
