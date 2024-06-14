package com.example.afford.app.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.afford.app.model.Product;




public interface ProductRepository extends JpaRepository<Product,Long>{
    ProductRepository findByPid(Long pid);
}