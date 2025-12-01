package com.proyecto.planillas.planilla;



import com.fasterxml.jackson.annotation.JsonProperty;

public record PlanillaViewDTO(

    Long id,
    @JsonProperty("estado_planilla")
    PlanillaEstado estado

) {

}
