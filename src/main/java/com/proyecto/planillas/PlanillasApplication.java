package com.proyecto.planillas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proyecto.planillas.cargo.Cargo;
import com.proyecto.planillas.cargo.CargoRepository;
import com.proyecto.planillas.empleado.Empleado;
import com.proyecto.planillas.empleado.EmpleadoRepository;
import com.proyecto.planillas.usuario.Usuario;
import com.proyecto.planillas.usuario.UsuarioRepository;

@SpringBootApplication
public class PlanillasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanillasApplication.class, args);
	}
	@Bean
	CommandLineRunner createDefaultUsers(UsuarioRepository usuarioRepository, EmpleadoRepository empleadoRepository,
        CargoRepository cargoRepository,PasswordEncoder encoder){
		return args -> {
		// 1. Buscar si el cargo ADMIN existe
        Cargo cargoAdmin = cargoRepository.findByNombre("ADMIN")
                .orElseGet(() -> cargoRepository.save(Cargo.builder()
                        .nombre("ADMIN")
                        .descripcion("Administrador del sistema")
                        .build()
                ));

        // 2. Crear usuario admin si no existe
        if (usuarioRepository.findByUser("admin").isEmpty()) {

            Empleado emp = empleadoRepository.save(
                Empleado.builder()
                        .nombre("Admin")
                        .apellido("Sistema")
                        .rol(cargoAdmin)
                        .build()
            );

            usuarioRepository.save(
                Usuario.builder()
                        .user("admin")
                        .password(encoder.encode("12345"))
                        .empleado(emp)
                        .build()
            );

            System.out.println("Usuario admin creado.");
        }
		}; 
	}

}
