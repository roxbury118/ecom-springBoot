package com.grp_name.ecom_proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grp_name.ecom_proj.model.product;
import com.grp_name.ecom_proj.service.productsService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
}
