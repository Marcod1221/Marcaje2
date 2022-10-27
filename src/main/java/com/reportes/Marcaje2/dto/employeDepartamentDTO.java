package com.reportes.Marcaje2.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
public class employeDepartamentDTO implements Serializable {
    private Long id_empleado;
    private String nombre;
    private Date fecha;
    private Time hora;
    private Long id_departamento;
    private String nombre_depto;
}
