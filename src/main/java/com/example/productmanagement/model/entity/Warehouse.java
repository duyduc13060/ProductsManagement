package com.example.productmanagement.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "warehouse")
public class Warehouse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "district_id")
    @JsonIgnore
    private District district;

    @ManyToOne
    @JoinColumn(name = "province_id")
    @JsonIgnore
    private Province province;

    @OneToMany(mappedBy = "warehouse")
    @JsonIgnore
    private List<WarehouseProduct> warehouseProducts;

}
