package com.reportes.Marcaje2.service;

import com.reportes.Marcaje2.dto.employeDepartamentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<employeDepartamentDTO> findAll();

    List<employeDepartamentDTO> findByidEmpleado(String idEmpleado);
}
