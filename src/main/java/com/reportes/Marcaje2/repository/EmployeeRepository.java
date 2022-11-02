package com.reportes.Marcaje2.repository;

import com.reportes.Marcaje2.entity.employeDepartament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<employeDepartament, Integer> {

    // Reporte Por Departamento
    @Query(
            value = "SELECT * FROM report_departament WHERE id_departamento =:id_departamento",
            nativeQuery = true)
    public List<employeDepartament> findByDepartamento(@Param("id_departamento") int id_departamento);

    // Reporte por usuario
    @Query(
            value = "SELECT * FROM report_departament WHERE id_empleado =:id_empleado",
            nativeQuery = true)
    public List<employeDepartament> findByUser(@Param("id_empleado") int id_empleado);

    @Query(
            value = "SELECT * FROM report_departament where hora between '07:00:00' and '10:00:00'",
            nativeQuery = true)
    public List<employeDepartament> getAllfechaEntrada();

    @Query(
            value = "SELECT * FROM report_departament where hora between '14:00:00' and '18:00:00'",
            nativeQuery = true)
    public List<employeDepartament> getAllfechaSalida();
}
