package com.G42_Proyecto.G42_Proyecto.crudRepository;

import com.G42_Proyecto.G42_Proyecto.entities.Score;
import org.springframework.data.repository.CrudRepository;


public interface ScoreCrudRepository extends CrudRepository <Score, Integer> {
    
}
