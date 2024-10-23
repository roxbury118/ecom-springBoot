package com.grp_name.ecom_proj.repo;

import java.util.List;  // Make sure you're importing java.util.List, not org.hibernate.mapping.List
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grp_name.ecom_proj.model.product;

@Repository
public interface productRepo extends JpaRepository<product, Integer> {
    @Query("SELECT p from product p WHERE " +
           "LOWER(p.p_name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.p_desc) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
           "LOWER(p.catogary) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<product> searchProducts(String keyword);
}