package com.grp_name.ecom_proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp_name.ecom_proj.model.product;
import com.grp_name.ecom_proj.repo.productRepo;
@Service
public class productsService {
  @Autowired
  private productRepo repo;

    public List<product> getAllproducts(){
      return repo.findAll();
    }

  public product getProductById(int id){
    return repo.findById(id).orElse(null);
  }
}
