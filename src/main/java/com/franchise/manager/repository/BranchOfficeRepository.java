package com.franchise.manager.repository;

import com.franchise.manager.model.BranchOfficeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOfficeModel, Integer> {
}
