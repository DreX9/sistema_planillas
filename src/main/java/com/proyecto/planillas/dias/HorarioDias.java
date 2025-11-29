package com.proyecto.planillas.dias;

import java.util.List;

import com.proyecto.planillas.horario.Horario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HorarioDias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dias_id")
    private Long id;
    @Column(nullable = false, length = 10, unique = true)
    private String dia;
    @OneToMany(mappedBy = "horarioDias")
    private List<Horario> horario;
}
