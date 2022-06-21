package com.example.productmanagement.reponsitory;

import com.example.productmanagement.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryReponsitory extends JpaRepository<Category,Long> {

}
