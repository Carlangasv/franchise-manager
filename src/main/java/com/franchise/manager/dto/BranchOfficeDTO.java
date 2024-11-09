package com.franchise.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BranchOfficeDTO {
    private int id;
    private String name;
    private List<ProductDTO> products;
}
