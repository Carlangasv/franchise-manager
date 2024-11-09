package com.franchise.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;


@Data
@Entity
public class BranchOfficeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 6, max = 40)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "branchOffice")
    private List<ProductModel> products;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private FranchiseModel franchise;
}
