package com.poly.DAOInterfaces;
import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Product;
public interface ProductDAO extends JpaRepository<Product, Integer> {}
