package com.reportes.Marcaje2.controller;

import com.reportes.Marcaje2.repository.EmployeeRepository;
import com.reportes.Marcaje2.service.EmployeeService;
import com.reportes.Marcaje2.service.reportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private reportService service;

    @GetMapping("/getEmployees")
    public ResponseEntity<Object> index() throws ParseException {
        return ResponseEntity.ok(this.employeeService.findAll());
    }

    // endpoint de Reporte General
    @GetMapping("/reporte/reportGeneral")
    public String generateReportEmployee() throws JRException, FileNotFoundException {
        return service.exportReport();
    }

    // endpoint de Reporte por empleado
    @GetMapping("/reporte/employee/{id_empleado}")
    public ResponseEntity<Object> getEmployee(@PathVariable(value="id_empleado") int id_empleado) throws JRException, FileNotFoundException {
        return ResponseEntity.ok(this.service.exportReportEmpleado(id_empleado));
    }

    // endpoint de Reporte por departamento
    @GetMapping("/reporte/departament/{id_departament}")
    public ResponseEntity<Object> getDepartament(@PathVariable(value="id_departament") int id_departament) throws JRException, FileNotFoundException {
        return ResponseEntity.ok(this.service.exportReportDepartament(id_departament));
    }

    @GetMapping("/report/getEmployees/horaEntrada")
    public ResponseEntity<Object> horaEntrada() throws ParseException, JRException, FileNotFoundException {
        return ResponseEntity.ok(this.service.getAllfechaEntrada());
    }

    @GetMapping("/report/getEmployees/horaSalida")
    public ResponseEntity<Object> horaSalida() throws ParseException, JRException, FileNotFoundException {
        return ResponseEntity.ok(this.service.getAllfechaSalida());
    }
}

//http://localhost:63342/Marcaje2/com/reportes/Marcaje2/html/index.html?_ijt=fgnjosag2htgq4kfovkus3dal&_ij_reload=RELOAD_ON_SAVE