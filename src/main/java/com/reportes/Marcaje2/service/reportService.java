package com.reportes.Marcaje2.service;

import com.reportes.Marcaje2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class reportService {

    // ruta donde guardaremos el reporte
    //private String path = "C:\\Users\\marpe\\Desktop";
    private String path = "/home/ronal/reportes";

    @Autowired
    EmployeeService employeeService;


    // Reporte General de los empleados
    public String exportReport() throws FileNotFoundException, JRException {

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:reporteGeneral.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findAll());
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\report_General.pdf");

        return "Reporte generado en la ruta: " + path;

    }

    // Reporte General por empleado
    public String exportReportEmpleado(int id_empleado) throws FileNotFoundException, JRException{

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:reportEmployee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findByid_Empleado(id_empleado));
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\report_employee.pdf");

        return "Reporte generado en la ruta: " + path;
    }


    // Reporte General por Departamento
    public String exportReportDepartament(int id_empleado) throws FileNotFoundException, JRException{

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:employeeDepartament.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findByid_Departament(id_empleado));
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\report_employeeDepartament.pdf");

        return "Reporte generado en la ruta: " + path;
    }
}
