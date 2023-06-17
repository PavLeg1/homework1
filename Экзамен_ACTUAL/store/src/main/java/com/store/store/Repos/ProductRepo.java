package com.store.store.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.store.Models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> 
{
    List<Product> findByType(String pr_type);
}