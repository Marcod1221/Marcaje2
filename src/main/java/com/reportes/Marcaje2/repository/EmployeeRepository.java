package com.reportes.Marcaje2.repository;

import com.reportes.Marcaje2.entity.employeDepartament;
import com.reportes.Marcaje2.dto.employeDepartamentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<employeDepartament, Integer> {

}
