package com.example.ecom_project.controller;

import com.example.ecom_project.model.Product;
import com.example.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping ("/api")
public class ProductController {
    @Autowired
    private ProductService service;
    @RequestMapping ("/")
    public String greeting(){
        return "Welcome";
    }
    @GetMapping ("/products")
    public ResponseEntity<List<Product>> getALLProduct(){
        return new ResponseEntity<>(service.getProduct(), HttpStatus.OK);
    }
    @GetMapping ("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable  int id){
        Product prod =service.getProductByid(id);
        if (prod!=null)
            return new ResponseEntity<>(prod,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
        System.out.println(product);
        try{
            Product product1=service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
        Product product=service.getProductByid(productId);
        byte[] imageFile=product.getImageData();
        System.out.println("hi");
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product,
                                                @RequestPart MultipartFile imageFile) throws IOException {
        Product product1= service.updateProduct(id,product,imageFile);
        if (product1 !=null)
            return new ResponseEntity<>("Updated Successfully",HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update",HttpStatus.BAD_GATEWAY);
    }
    @DeleteMapping ("/product/{id}")
    public ResponseEntity<String> deletePRoduct(@PathVariable int id){
        Product product=service.getProductByid(id);
        if (product!=null) {
            service.deleteById(id);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Product notfound",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> search(@RequestPart String keyword){
      List<Product> products = service.searchProduct(keyword);
      return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
