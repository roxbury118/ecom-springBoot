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
    prod.setImageName(imageFile.getOriginalFilename());
    prod.setImageType(imageFile.getContentType());
    try {
      prod.setImageDate(imageFile.getBytes());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
      
    return repo.save(prod);
  }

  public product updateProduct(int id, product prod, MultipartFile imageFile) throws IOException {
    // TODO Auto-generated method stub
    prod.setImageDate(imageFile.getBytes());
    prod.setImageName(imageFile.getOriginalFilename()); 
    prod.setImageType(imageFile.getContentType());
    return repo.save(prod);
    //throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
  }

  public void deleteProduct(int id) {
    // TODO Auto-generated method stub
    repo.deleteById(id);

    //throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
  }

  public List<product> searchProducts(String keyword) {
    // TODO Auto-generated method stub
    return repo.searchProducts(keyword);
   // throw new UnsupportedOperationException("Unimplemented method 'searchProducts'");
  }
}
