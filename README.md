# Reportes de historial de marcación de empleados

Proyecto desarrollado para generar informes en PDF con Spring Boot utilizando Jasper Reports.

## Tecnologías Utilizadas

- Java
- Jasperreports
- TIBCO Jaspersoft Studio (Edición comunitaria)

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

![image](https://user-images.githubusercontent.com/112280392/199645927-ae265510-9a4a-4441-aa80-60e8ad176c07.png)![image](https://user-images.githubusercontent.com/112280392/199645507-1af6df44-f4a1-4d3f-bc28-5e8bb5f8c63e.png)

