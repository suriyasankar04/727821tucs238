package com.example.afford.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.afford.app.dto.request.ProductRequest;
import com.example.afford.app.model.Product;
import com.example.afford.app.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/20.244.56.144/test/companies") // Changed the request mapping to match the resource being dealt with
@RequiredArgsConstructor
@CrossOrigin(origins="*",allowedHeaders = "*")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<String> createJob(@RequestBody ProductRequest request) {
        boolean isSaved = productService.Createjob(request);
        return isSaved ? ResponseEntity.status(201).body("Job added successfully")
                : ResponseEntity.badRequest().build();
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAlljob() {
        List<Product> job = productService.getAllproduct();
        return !job.isEmpty() ? ResponseEntity.status(200).body(job)
                : ResponseEntity.noContent().build();
    }

    @PutMapping("/edit/{pid}")
    public ResponseEntity<String> updateCourse(@RequestBody ProductRequest request, @PathVariable("pid") Long pid) {
        boolean isUpdate = productService.updateProduct(request, pid);
        return isUpdate
                ? ResponseEntity.status(200).body("Job updated successfully!")
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteCourse(@PathVariable("pid") Long pid) {
        boolean isDelete = productService.deletejob(pid);
        return isDelete ? ResponseEntity.status(200).body("Job deleted successfully!")
                : ResponseEntity.notFound().build();
    }
}
