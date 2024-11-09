package com.franchise.manager.service;

import com.franchise.manager.model.FranchiseModel;

public interface FranchiseService {

    FranchiseModel createFranchise(FranchiseModel franchise);

    FranchiseModel getFranchiseById(int id);
}
