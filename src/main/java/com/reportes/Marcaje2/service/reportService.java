package com.reportes.Marcaje2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
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
    //private String path = "/home/ronal/reportes";

    @Autowired
    EmployeeService employeeService;

    // Reporte General de los empleados
    public ResponseEntity<ByteArrayResource> exportReport() throws FileNotFoundException, JRException {

        String fileName = "report_General.pdf";

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:reporteGeneral.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findAll());
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");

        // Creamos el cuerpo del pdf
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        return crearPDF(jasperPrint, fileName);
    }

    // Reporte General por empleado
    public ResponseEntity<ByteArrayResource> exportReportEmpleado(int id_empleado) throws FileNotFoundException, JRException{

        String fileName = "report_empleado.pdf";

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:reportEmployee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findByid_Empleado(id_empleado));
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        return crearPDF(jasperPrint,fileName);
    }

    // Reporte General por Departamento
    public ResponseEntity<ByteArrayResource> exportReportDepartament(int id_empleado) throws FileNotFoundException, JRException{

        String fileName = "report_departamento.pdf";

        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:employeeDepartament.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.findByid_Departament(id_empleado));
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        return crearPDF(jasperPrint,fileName);
    }

    public ResponseEntity<ByteArrayResource> getAllfechaEntrada() throws FileNotFoundException, JRException{

        String fileName = "report_fechaEntrada.pdf";
        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:fechas.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.getAllfechaEntrada());
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        return crearPDF(jasperPrint,fileName);
    }

    public ResponseEntity<ByteArrayResource> getAllfechaSalida() throws FileNotFoundException, JRException{

        String fileName = "report_fechaSalida.pdf";
        // Cargamos el archivo y lo compilamos
        File file = ResourceUtils.getFile("classpath:fechas.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        // pasamos la lista
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(this.employeeService.getAllfechaSalida());
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Marco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        return crearPDF(jasperPrint,fileName);
    }

    // Método para crear y descargar el pdf generado
    public ResponseEntity<ByteArrayResource> crearPDF(JasperPrint jasperPrint, String fileName) throws JRException {
        byte [] reporte = JasperExportManager.exportReportToPdf(jasperPrint);

        ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                .filename(fileName).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok().contentLength((long) reporte.length)
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers).body(new ByteArrayResource(reporte));
    }
}
