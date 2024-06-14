package com.example.afford.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.afford.app.dto.request.ProductRequest;
import com.example.afford.app.model.Product;
import com.example.afford.app.repository.ProductRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public boolean Createjob(ProductRequest request) {
        // Creating a new course object from the request
        var pro = Product.builder()
                .pid(request.getPid())
                .productname(request.getProductname())
                .price(request.getPrice())
                .rating(request.getRating())
                .discount(request.getDiscount())
                .availability(request.getAvailability())
                .build();
        
        // Saving the course to the repository
        repository.save(pro);

        return true;
    }

    public List<Product> getAllproduct() {
        // Retrieve all courses from the repository
        return repository.findAll();
    }

    public boolean updateProduct(ProductRequest request, Long pid) {
        Optional<Product> optionalCourse = repository.findById(pid);

        if (optionalCourse.isPresent()) {
            Product pro = optionalCourse.get();
            // Update the fields of the course with the new values from the request
            pro.setProductname(request.getProductname());
            pro.setPrice(request.getPrice());
            pro.setRating(request.getRating());
            pro.setDiscount(request.getDiscount());
            pro.setAvailability(request.getAvailability());

            // Save the updated course to the repository
            repository.save(pro);

            return true;
        } else {
            // Throw an exception if the course with the specified ID is not found
            throw new EntityNotFoundException("Product with id " + pid + " not found");
        }
    }

    public boolean deletejob(Long pid) {
        // Delete the course with the specified ID from the repository
        repository.deleteById(pid);
        return true;
    }

}
