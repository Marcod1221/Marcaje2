# Reportes de historial de marcación de empleados

Proyecto desarrollado para generar informes en PDF con Spring Boot utilizando Jasper Reports.

## Tecnologías Utilizadas

- Java
- Jasperreports
- TIBCO Jaspersoft Studio (Edición comunitaria)

Informe en PDF

Este proyecto utiliza Jasper Report como herramienta para generar informes en PDF. Las plantillas PDF se diseñaron atravez de TIBCO JasperSoft Studio. Esta nos genera un archivo jrmxl, el cual esta implementado dentro del proyecto.

## Plantilla y Estructura

![image](https://user-images.githubusercontent.com/112280392/199644347-a577b5fc-5131-43e7-a142-3af5b43c3213.png)

## Endpoints para Generar los reportes

- Reporte General 
http://10.8.0.10:8080/reporte/reportGeneral

- Reporte por empleado
http://10.8.0.10:8080/reporte/employee/{id_empleado}

- Reporte por departamento
http://10.8.0.10:8080/reporte/departament/{id_departament}

- Reporte por HoraEntrada
http://10.8.0.10:8080/report/getEmployees/horaEntrada

- Reporte por HoraSalida
http://10.8.0.10:8080/report/getEmployees/horaSalida

## Proyecto Necesario para probar cada enpoint

https://github.com/RonalPerez506/frontend-angular-prod

## preview de los reportes

![image](https://user-images.githubusercontent.com/112280392/199645927-ae265510-9a4a-4441-aa80-60e8ad176c07.png)![image](https://user-images.githubusercontent.com/112280392/199645507-1af6df44-f4a1-4d3f-bc28-5e8bb5f8c63e.png)![image](https://user-images.githubusercontent.com/112280392/199647456-0187b267-1197-460b-9750-89f534dddfd5.png)![image](https://user-images.githubusercontent.com/112280392/199647580-7cc04f59-5da7-4d4a-a799-49c4880db11b.png)
