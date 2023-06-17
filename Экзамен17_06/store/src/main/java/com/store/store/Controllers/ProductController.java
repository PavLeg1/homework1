package com.store.store.Controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.store.Models.Product;
import com.store.store.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public void save(@RequestBody Product product){
        productService.saveProduct(product);
    }

    @GetMapping("")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteProduct(id);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try{
            Product product = productService.getProductById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        catch(NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id){
    //     try{
    //         Product  = 
    //     }
    // }
        @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id){
        try{
            Product _product = productService.getProductById(id);
            _product.updateProduct(product);
            productService.saveProduct(_product);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}