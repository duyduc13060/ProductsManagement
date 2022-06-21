package com.example.productmanagement.controller;

import com.example.productmanagement.model.entity.Category;
import com.example.productmanagement.reponsitory.CategoryReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2.0/category")
public class CategoryController {

    @Autowired
    CategoryReponsitory reponsitory;

    @GetMapping()
    public ResponseEntity getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
    ){
        Page<Category> page1 = reponsitory.findAll(PageRequest.of(page,page_size));
        return ResponseEntity.ok(page1);
    }

    @PostMapping()
    public ResponseEntity create
            (
                    @RequestBody Category categories
            ){
        return ResponseEntity.ok(reponsitory.save(categories));
    }

    @PutMapping()
    public ResponseEntity update
            (
                    @RequestBody Category categories
            ){
        return ResponseEntity.ok(reponsitory.save(categories));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete
            (
                    @PathVariable Long id
            ){
        reponsitory.deleteById(id);
        return ResponseEntity.ok("thanh cong");
    }

}
