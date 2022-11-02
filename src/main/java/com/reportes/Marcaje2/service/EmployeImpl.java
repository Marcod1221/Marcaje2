package com.reportes.Marcaje2.service;

import com.fasterxml.jackson.databind.DatabindException;
import com.reportes.Marcaje2.dto.employeDepartamentDTO;
import com.reportes.Marcaje2.entity.employeDepartament;
import com.reportes.Marcaje2.repository.EmployeeRepository;
import com.reportes.Marcaje2.utils.MHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class EmployeImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    Date hora1 = new SimpleDateFormat("HH:mm:ss").parse("00:14:39");
    public EmployeImpl() throws ParseException {
    }

    // Obtenemos todos los registros de los empleados
    @Override
    public List<employeDepartamentDTO> findAll(){

        List<employeDepartamentDTO> dto = new ArrayList<>();
        Iterable<employeDepartament> employeDepartament = this.employeeRepository.findAll();


        // recorremos los datos obtenidos y los mappeamos a nuestro DTO
        for (employeDepartament employee: employeDepartament) {
            employeDepartamentDTO employeDepartamentDTO = MHelpers.modelMapper().map(employee, employeDepartamentDTO.class);

            dto.add(employeDepartamentDTO);
        }

        return dto;
    }

    // método que devuelve los datos por empleado
    @Override
    public List<employeDepartamentDTO> findByid_Empleado(int id_Empleado) {
        List<employeDepartamentDTO> dto = new ArrayList<>();
        Iterable<employeDepartament> employeDepartament = this.employeeRepository.findByUser(id_Empleado);

        // recorremos los datos obtenidos y los mappeamos a nuestro DTO
        for (employeDepartament employee: employeDepartament) {
            employeDepartamentDTO employeDepartamentDTO = MHelpers.modelMapper().map(employee, employeDepartamentDTO.class);
            dto.add(employeDepartamentDTO);
        }
        return dto;
    }

    // método que devuelve los datos por departamento
    @Override
    public List<employeDepartamentDTO> findByid_Departament(int id_departament) {

        List<employeDepartamentDTO> dto = new ArrayList<>();
        Iterable<employeDepartament> employeDepartament = this.employeeRepository.findByDepartamento(id_departament);

        // recorremos los datos obtenidos y los mappeamos a nuestro DTO
        for (employeDepartament departament: employeDepartament) {
            employeDepartamentDTO employeDepartamentDTO = MHelpers.modelMapper().map(departament, employeDepartamentDTO.class);
            dto.add(employeDepartamentDTO);
        }
        return dto;
    }

    @Override
    public List<employeDepartamentDTO> getAllfechaEntrada() {
        List<employeDepartamentDTO> dto = new ArrayList<>();
        Iterable<employeDepartament> employeDepartament = this.employeeRepository.getAllfechaEntrada();

        // recorremos los datos obtenidos y los mappeamos a nuestro DTO
        for (employeDepartament employee: employeDepartament) {
            employeDepartamentDTO employeDepartamentDTO = MHelpers.modelMapper().map(employee, employeDepartamentDTO.class);
            dto.add(employeDepartamentDTO);
        }
        return dto;
    }

    @Override
    public List<employeDepartamentDTO> getAllfechaSalida() {
        List<employeDepartamentDTO> dto = new ArrayList<>();
        Iterable<employeDepartament> employeDepartament = this.employeeRepository.getAllfechaSalida();

        // recorremos los datos obtenidos y los mappeamos a nuestro DTO
        for (employeDepartament employee: employeDepartament) {
            employeDepartamentDTO employeDepartamentDTO = MHelpers.modelMapper().map(employee, employeDepartamentDTO.class);
            dto.add(employeDepartamentDTO);
        }
        return dto;
    }
}
