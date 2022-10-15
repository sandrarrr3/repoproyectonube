package com.G42_Proyecto.G42_Proyecto.Controller;


import com.G42_Proyecto.G42_Proyecto.Service.CategoryService;
import com.G42_Proyecto.G42_Proyecto.entities.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
        
    }
    
    @PostMapping("/save")
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
        
    }
    
}
