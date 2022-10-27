package com.reportes.Marcaje2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="reportDepartament")
public class employeDepartament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="id_empleado")
    private Long id_empleado;
    @Column(name="nombre")
    private String nombre;
    @Column(name="fecha")
    private Date fecha;
    @Column(name="hora")
    private Time hora;
    @Column(name="id_departamento")
    private Long id_departamento;
    @Column(name="nombre_depto")
    private String nombre_depto;


}
