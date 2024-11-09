package com.franchise.manager.service;

import com.franchise.manager.dto.FranchiseDTO;
import com.franchise.manager.model.FranchiseModel;

public interface FranchiseService {

    FranchiseModel createFranchise(FranchiseDTO franchise);

    FranchiseModel getFranchiseById(int id);
}
