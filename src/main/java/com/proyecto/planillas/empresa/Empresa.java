package com.proyecto.planillas.empresa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Long id;
   
    @Column(nullable = false, name = "empresa_nombre", length = 100, unique = true)
    private String nombre;
    
    @Column(nullable = false, name = "empresa_ruc", length = 11, unique = true)
    private String ruc;
    
    @Column(nullable = false, name = "empresa_razon")
    private String razonSocial;
    
    @Column(nullable = false, name = "empresa_telefono", length = 9)
    private String telefono;
    
    @Column(nullable = false, name = "empresa_telefono_respaldo", length = 9)
    private String telefonoRespaldo;
    
    @Column(nullable = false, name = "empresa_correo")
    private String correo;
    
    @Column(nullable = false, name = "empresa_direccion")
    private String direccion;

}
