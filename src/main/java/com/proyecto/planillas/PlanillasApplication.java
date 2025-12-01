package com.proyecto.planillas;

import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proyecto.planillas.area.Area;
import com.proyecto.planillas.area.AreaEstado;
import com.proyecto.planillas.area.AreaRepository;
import com.proyecto.planillas.cargo.Cargo;
import com.proyecto.planillas.cargo.CargoRepository;
import com.proyecto.planillas.empleado.Empleado;
import com.proyecto.planillas.empleado.EmpleadoRepository;
import com.proyecto.planillas.empresa.Empresa;
import com.proyecto.planillas.empresa.EmpresaRepository;
import com.proyecto.planillas.horario.Horario;
import com.proyecto.planillas.horario.HorarioRepository;
import com.proyecto.planillas.usuario.Usuario;
import com.proyecto.planillas.usuario.UsuarioRepository;

@SpringBootApplication
public class PlanillasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanillasApplication.class, args);
    }

    @Bean
    CommandLineRunner createDefaultUsers(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository,
            HorarioRepository horarioRepository, EmpresaRepository empresaRepository, AreaRepository areaRepository,
            CargoRepository cargoRepository, PasswordEncoder encoder) {
        return args -> {
            // 1. Crear horario por defecto
            Horario horarioDefault = horarioRepository.findAll().stream().findFirst()
                    .orElseGet(() -> horarioRepository.save(
                            Horario.builder()
                                    .horaEntrada(LocalTime.of(8, 0))
                                    .horaSalida(LocalTime.of(17, 0))
                                    .dias("Lunes a Viernes")
                                    .turnos("Mañana")
                                    .build()));

            // 4. Buscar si el cargo ADMIN existe
            Cargo cargoAdmin = cargoRepository.findByNombre("ADMIN")
                    .orElseGet(() -> cargoRepository.save(Cargo.builder()
                            .nombre("ADMIN")
                            .descripcion("Administrador del sistema")
                            .build()));

            // 3. Empresa
            Empresa empresaDefault = empresaRepository.findAll().stream().findFirst()
                    .orElseGet(() -> empresaRepository.save(Empresa.builder()
                            .nombre("Empresa Principal")
                            .ruc("12345678901")
                            .razonSocial("Empresa Principal S.A.")
                            .telefono("987654321")
                            .telefonoRespaldo("912345678")
                            .correo("contacto@empresa.com")
                            .direccion("Av. Principal 123")
                            .build()));

            // 2. area creacion de areas con empresa por defecto
            Area areaDefault = areaRepository.findByEstado(AreaEstado.ACTIVO)
                    .orElseGet(() -> areaRepository.save(Area.builder()
                            .nombre("Area General")
                            .estado(AreaEstado.ACTIVO)
                            .empresa(empresaDefault)
                            .build()));

            // 5. Crear usuario admin si no existe
            if (usuarioRepository.findByUser("admin").isEmpty()) {
                Empleado emp = empleadoRepository.save(
                        Empleado.builder()
                                .nombre("Admin")
                                .apellido("Sistema")
                                .rol(cargoAdmin)
                                .horario(horarioDefault)
                                .area(areaDefault)
                                .build());

                usuarioRepository.save(
                        Usuario.builder()
                                .user("admin")
                                .password(encoder.encode("12345"))
                                .empleado(emp)
                                .build());

                System.out.println("Usuario admin creado.");
            }

        };

    }
}
