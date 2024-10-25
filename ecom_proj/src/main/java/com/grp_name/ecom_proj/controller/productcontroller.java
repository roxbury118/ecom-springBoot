package com.grp_name.ecom_proj.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grp_name.ecom_proj.model.product;
import com.grp_name.ecom_proj.service.productsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api")
public class productcontroller {
  @Autowired
  private productsService service;

//we are using api on top of controller
  @GetMapping("/products/{id}")
  public ResponseEntity<product> getproduct(@PathVariable int id){
     product prod= service.getProductById(id);
     if(prod!=null){
      return new ResponseEntity<>(prod,HttpStatus.OK);
     }
     else{
        return new ResponseEntity<>(prod,HttpStatus.NOT_FOUND);
     }
    //service.getProductById(id);
  }
  @GetMapping("/products")
  public ResponseEntity<List<product>> getAllproducts(){
    return new ResponseEntity<>(service.getAllproducts(),HttpStatus.OK);
  }
  @PostMapping("/product")
  public ResponseEntity<?> addProduct(@RequestPart product prod, @RequestPart MultipartFile imageFile){
      try{
        product prod1=service.addProduct(prod,imageFile);
        return new ResponseEntity<>(prod1,HttpStatus.CREATED);
      }
      catch(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }

  
  @GetMapping("/product/{productId}/image")
  public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId){
    product prod=service.getProductById(productId);
    byte[] imageFile=prod.getImageDate();

    return ResponseEntity.ok().contentType(MediaType.valueOf(prod.getImageType()))
    .body(imageFile);
  }
// @PutMapping("/product/{id}")
// public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart product prod,@RequestPart MultipartFile imagFile) throws IOException{
//   product prod1=service.updateProduct(id,prod,imagFile);
//   if(prod !=null){
//     return new ResponseEntity<>("update",HttpStatus.OK);
//   }
//   else{
//     return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);
//   }
// }


@PutMapping("/product/{id}")
public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart("prod") product prod, @RequestPart(required = false) MultipartFile imageFile) throws IOException {
    product updatedProd = service.updateProduct(id, prod, imageFile);
    if (updatedProd != null) {
        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Product update failed", HttpStatus.BAD_REQUEST);
    }
}
  
//  @PutMapping("/product/{id}")
//public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart product prod, @RequestPart MultipartFile imageFile) throws IOException {
//    product updatedProd = service.updateProduct(id, prod, imageFile);
//    if (updatedProd != null) {
//        return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
//    } else {
//        return new ResponseEntity<>("Product update failed", HttpStatus.BAD_REQUEST);
//    }
//}

  @DeleteMapping("/product/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable int id){
    product prod=service.getProductById(id);
    if(prod!=null){
      service.deleteProduct(id);
       return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    else{
      return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
    }
  }
  @GetMapping("/products/search")
  public ResponseEntity<List<product>> searchProducts(@RequestParam String keyword){
    List<product> prod=service.searchProducts(keyword);
    return new ResponseEntity<>(prod,HttpStatus.OK);
  }

}