package com.franchise.manager.repository;

import com.franchise.manager.model.FranchiseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<FranchiseModel, Integer> {
}
