package com.proyecto.planillas.planilla;



import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PlanillaViewDTO(

    Long id,

    @JsonProperty("fecha_generacion")
    LocalDate fechaGeneracion,

    Integer mes,
    Integer anio,

    // Datos básicos del empleado

    @JsonProperty("empleado_nombre")
    String empleadoNombre,

    @JsonProperty("empleado_apellido")
    String empleadoApellido,

    // Cálculos de planilla
    @JsonProperty("sueldo_base")
    BigDecimal sueldoBase,

    @JsonProperty("total_descuentos")
    BigDecimal totalDescuentos,

    @JsonProperty("sueldo_neto")
    BigDecimal sueldoNeto,

    @JsonProperty("dias_trabajados")
    Integer diasTrabajados,

    Integer tardanzas,
    Integer inasistencias,

    @JsonProperty("estado_planilla")
    PlanillaEstado estado

) {

}
