package com.grp_name.ecom_proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp_name.ecom_proj.model.product;

@Repository
public interface productRepo extends JpaRepository<product,Integer>{

}
