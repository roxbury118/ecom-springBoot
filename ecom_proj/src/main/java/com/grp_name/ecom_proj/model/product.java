package com.grp_name.ecom_proj.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String p_name;
  private String p_desc;
  private String brand;
  private BigDecimal price;
  private String catogary;
  private Date release_Date;
  private boolean available;
  private int quant;
}
