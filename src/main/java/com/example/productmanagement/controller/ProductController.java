package com.example.productmanagement.controller;

import com.example.productmanagement.model.entity.Product;
import com.example.productmanagement.reponsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2.0/product")
public class ProductController {

    @Autowired
    ProductReponsitory reponsitory;

    @GetMapping
    public ResponseEntity getAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
                                 ){
        Page<Product> page1 = reponsitory.findAll(PageRequest.of(page,page_size));
        return ResponseEntity.ok(page1);
    }


    @GetMapping("/search")
    public ResponseEntity searchAndPage(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "page_size") int page_size
    ){

        return ResponseEntity.ok(reponsitory.findBy("%" + name +"%",PageRequest.of(page,page_size)));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Product product){

        return ResponseEntity.ok(reponsitory.save(product));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Product product){

        return ResponseEntity.ok(reponsitory.save(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        reponsitory.deleteById(id);
        return ResponseEntity.ok("thành công");
    }


}
