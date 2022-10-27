package com.reportes.Marcaje2.service;

import com.reportes.Marcaje2.entity.employeDepartament;
import com.reportes.Marcaje2.repository.EmployeeRepository;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
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
    
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;


    public String exportReport() throws FileNotFoundException, JRException{
        // ruta para guardar el reporte
        String path = "C:\\Users\\marpe\\Desktop";

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:employeeDepartament.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findAll());
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Java Techie");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");

        return "Reporte generado en la ruta" + path;

    }
}
