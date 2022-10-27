package com.reportes.Marcaje2.controller;

import com.reportes.Marcaje2.dto.employeDepartamentDTO;
import com.reportes.Marcaje2.repository.EmployeeRepository;
import com.reportes.Marcaje2.service.EmployeeService;
import com.reportes.Marcaje2.service.reportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private reportService service;

    @GetMapping("/getEmployees")
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.employeeService.findAll());
    }

    /*
    @GetMapping("/getEmployees/{id_empleado}")
    public List<employeDepartamentDTO> getEmployees(@PathVariable(value="id_empleado") int id_empleado) {
        return repository.findByUser(id_empleado);
    }
     */

    /*
    @GetMapping("/report/{id_departamento}")
    public String generateReport(@PathVariable(value="id_departamento") int id_departamento) throws FileNotFoundException, JRException {
        return service.exportReport(id_departamento);
    }
    */

    @GetMapping("/report")
    public String generateReportEmployee() throws JRException, FileNotFoundException {
        return service.exportReport();
    }
}
