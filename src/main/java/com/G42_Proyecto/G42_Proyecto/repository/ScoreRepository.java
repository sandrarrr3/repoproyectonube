/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.G42_Proyecto.G42_Proyecto.repository;

import com.G42_Proyecto.G42_Proyecto.crudRepository.ScoreCrudRepository;
import com.G42_Proyecto.G42_Proyecto.entities.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScoreRepository {
    

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);

    }

    public Score save(Score s) {
        return scoreCrudRepository.save(s);
    }

    public void delete(Score s) {
        scoreCrudRepository.delete(s);
    }

}
