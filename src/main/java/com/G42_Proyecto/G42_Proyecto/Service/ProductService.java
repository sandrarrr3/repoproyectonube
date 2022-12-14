package com.G42_Proyecto.G42_Proyecto.Service;

import com.G42_Proyecto.G42_Proyecto.entities.Product;
import com.G42_Proyecto.G42_Proyecto.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public Product save(Product p) {

        if (p.getId() == null) {
            return productRepository.save(p);
        } else {
            Optional<Product> e = productRepository.getProduct(p.getId());
            if (e.isPresent()) {
                return e.get();
            } else {
                return productRepository.save(p);
            }
        }
    }

    public Product update(Product p) {
        if (p.getId() != null) {
            Optional<Product> q = productRepository.getProduct(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }

                if (p.getBrand() != null) {
                    q.get().setBrand(p.getBrand());
                }

                if (p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }

                if (p.getYear() != null) {
                    q.get().setYear(p.getYear());
                }
                if (p.getCategory() != null) {
                    q.get().setCategory(p.getCategory());
                }

                productRepository.save(q.get());
                return q.get();

            } else {
                return p;
            }

        } else {
            return p;
        }
    }

    public boolean deleteCloud(int id) {
        Boolean d = getProduct(id).map(cloud -> {
            productRepository.delete(cloud);
            return true;
        }).orElse(false);
        return d;
    }

}
