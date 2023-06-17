package com.store.store.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.store.Models.Product;
import com.store.store.Repos.ProductRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public void saveProduct(Product product){
        productRepo.save(product);
    }

    public Product getProductById(Long id){
        return productRepo.findById(id).get();
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }

}
