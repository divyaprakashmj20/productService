package com.myCompany.store.product.Controller;

import com.myCompany.store.product.dao.ProductRepository;
import com.myCompany.store.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Service
//@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/product/{id}")
    Optional<Product> getProduct(@PathVariable("id") int id){
        return productRepository.findById(id);
    }

    @RequestMapping("/products")
    List<Product> getProductIds(@RequestParam int id){
        return productRepository.findByCatId(id);
    }

    @RequestMapping("/products/all")
    List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    ResponseEntity<Product> insertProduct(@RequestBody Product product){
        Product savedProduct = productRepository.save(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    Product updateProduct(@PathVariable int id, @RequestBody Product product){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product prod = optionalProduct.get();

        prod.setCatId(product.getCatId());
        prod.setName(product.getName());

        Product savedProduct = productRepository.save(prod);

        return savedProduct;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    Product deleteProduct(@PathVariable int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product prod = optionalProduct.get();
        productRepository.delete(prod);
        return prod;
    }
}
