package com.franchise.manager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductBranchDTO {
    private int productId;
    private String productName;
    private int stock;
    private int branchId;
    private String branchName;
}
