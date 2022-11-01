package com.reportes.Marcaje2.service;

import com.reportes.Marcaje2.dto.employeDepartamentDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface EmployeeService {

    // Métodos implementados para obtener los datos
    List<employeDepartamentDTO> findAll();

    List<employeDepartamentDTO> findByid_Empleado(int id_Empleado);

    List<employeDepartamentDTO> findByid_Departament(int id_departament);
}
