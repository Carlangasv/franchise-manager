package com.franchise.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FranchiseDTO {
    private String name;
    private List<Integer> branchOffices;
}
