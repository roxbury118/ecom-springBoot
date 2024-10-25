package com.grp_name.ecom_proj.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

  public product addProduct(product prod, MultipartFile imageFile) {
    if (imageFile != null && !imageFile.isEmpty()) {
      prod.setImageName(imageFile.getOriginalFilename());
      prod.setImageType(imageFile.getContentType());
      try {
        prod.setImageDate(imageFile.getBytes());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return repo.save(prod);
  }

  public product updateProduct(int id, product prod, MultipartFile imageFile) throws IOException {
    product existingProduct = repo.findById(id).orElse(null);
    if (existingProduct == null) {
      return null; // Optionally throw an exception for not found
    }

    // Update fields from prod to existingProduct
    existingProduct.setP_name(prod.getP_name());
    existingProduct.setP_desc(prod.getP_desc());
    existingProduct.setBrand(prod.getBrand());
    existingProduct.setPrice(prod.getPrice());
    existingProduct.setCatogary(prod.getCatogary());
    existingProduct.setRelease_Date(prod.getRelease_Date());
    existingProduct.setAvailable(prod.isAvailable());
    existingProduct.setQuant(prod.getQuant());

    if (imageFile != null && !imageFile.isEmpty()) {
      existingProduct.setImageDate(imageFile.getBytes());
      existingProduct.setImageName(imageFile.getOriginalFilename());
      existingProduct.setImageType(imageFile.getContentType());
    }
    return repo.save(existingProduct);
  }

  public void deleteProduct(int id) {
    repo.deleteById(id);
  }

  public List<product> searchProducts(String keyword) {
    return repo.searchProducts(keyword);
  }
}
