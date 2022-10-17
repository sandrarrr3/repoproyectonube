
package com.G42_Proyecto.G42_Proyecto.Service;

import com.G42_Proyecto.G42_Proyecto.entities.Score;
import com.G42_Proyecto.G42_Proyecto.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
     @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getUser(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score s) {
        if (s.getId()== null) {
            return scoreRepository.save(s);
        } else {
            Optional<Score> e = scoreRepository.getScore(s.getId());
            if (e.isPresent()) {
                return e.get();
            } else {
                return scoreRepository.save(s);
            }
        }
    }

    public Score update(Score s) {
        if (s.getId() != null) {
            Optional<Score>q = scoreRepository.getScore(s.getId());
            if (q.isPresent()){
                if(s.getScore()!=null){
                    q.get().setScore(s.getScore());
                }
                scoreRepository.save(q.get());
                return q.get();
            }else{
                return s;
            }
        }else{
            return s;
        }
    }
      
    
    public  boolean delete  (int id){
        boolean flag = false;
        Optional <Score>p = scoreRepository.getScore(id);
        if (p.isPresent()){
            scoreRepository.delete(p.get());
            flag = true;
        }
        return flag;
    }

    public Optional<Score> getScore(int scoreId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
     
}
    
    
