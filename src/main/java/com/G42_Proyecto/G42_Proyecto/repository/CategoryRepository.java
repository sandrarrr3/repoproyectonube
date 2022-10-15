package com.G42_Proyecto.G42_Proyecto.repository;


import com.G42_Proyecto.G42_Proyecto.crudRepository.CategoryCrudRepository;
import com.G42_Proyecto.G42_Proyecto.entities.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return  (List<Category>) categoryCrudRepository.findAll();
    }
    
     public Optional <Category> getCategory (int id){
         return categoryCrudRepository.findById(id);
     }   
     
     public Category save (Category c){
         return categoryCrudRepository.save(c);
     }
     
     public void delete (Category c){
         categoryCrudRepository.delete(c);
     }


}
