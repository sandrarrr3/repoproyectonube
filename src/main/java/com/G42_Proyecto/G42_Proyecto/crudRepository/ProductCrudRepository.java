package com.G42_Proyecto.G42_Proyecto.crudRepository;


import com.G42_Proyecto.G42_Proyecto.entities.Product;
import org.springframework.data.repository.CrudRepository;




public interface ProductCrudRepository extends CrudRepository<Product, Integer>{
    
}
