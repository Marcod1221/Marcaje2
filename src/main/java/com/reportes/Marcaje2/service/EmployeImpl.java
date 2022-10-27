package com.reportes.Marcaje2.service;

import com.reportes.Marcaje2.dto.employeDepartamentDTO;
import com.reportes.Marcaje2.entity.employeDepartament;
import com.reportes.Marcaje2.repository.EmployeeRepository;
import com.reportes.Marcaje2.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    // Obtenemos los datos
    @Override
    public List<employeDepartamentDTO> findAll() {

        List<employeDepartamentDTO> dto = new ArrayList<>();
        Iterable<employeDepartament> employeDepartament = this.employeeRepository.findAll();

        // recorremos los datos obtenidos y los mappeamos a nuestro DTO
        for (employeDepartament employee: employeDepartament) {
            employeDepartamentDTO employeDepartamentDTO = MHelpers.modelMapper().map(employee, employeDepartamentDTO.class);
            dto.add(employeDepartamentDTO);
        }

        return dto;
    }

    @Override
    public List<employeDepartamentDTO> findByidEmpleado(String idEmpleado) {
        return null;
    }
}
