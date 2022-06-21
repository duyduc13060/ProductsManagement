package com.example.productmanagement.reponsitory;

import com.example.productmanagement.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductReponsitory extends JpaRepository<Product,Long> {
//    api search product với điều kiện price > 50000, tên có chứa chữ ”áo”, có paging, sort giá giảm dần.
    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1 AND p.price > 50000 ORDER BY p.price DESC")
    List<Product> findBy(String name,Pageable pageable);


}
