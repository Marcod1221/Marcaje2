package com.reportes.Marcaje2.controller;

import com.reportes.Marcaje2.service.EmployeeService;
import com.reportes.Marcaje2.service.reportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private reportService service;

    @GetMapping("/getEmployees")
    public ResponseEntity<Object> index(){
        return ResponseEntity.ok(this.employeeService.findAll());
    }

    // endpoint de Reporte General
    @GetMapping("/report")
    public String generateReportEmployee() throws JRException, FileNotFoundException {
        return service.exportReport();
    }

    // endpoint de Reporte por empleado
    @GetMapping("/employee/{id_empleado}")
    public ResponseEntity<Object> getEmployee(@PathVariable(value="id_empleado") int id_empleado) throws JRException, FileNotFoundException {
        return ResponseEntity.ok(this.service.exportReportEmpleado(id_empleado));
    }

    // endpoint de Reporte por departamento
    @GetMapping("/departament/{id_departament}")
    public ResponseEntity<Object> getDepartament(@PathVariable(value="id_departament") int id_departament) throws JRException, FileNotFoundException {
        return ResponseEntity.ok(this.service.exportReportDepartament(id_departament));
    }
}
