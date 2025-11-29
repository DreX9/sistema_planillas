package com.proyecto.planillas.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;


import com.proyecto.planillas.empleado.EmpleadoRepository;
import com.proyecto.planillas.security.CustomUserDetail;
import com.proyecto.planillas.usuario.Usuario;
import com.proyecto.planillas.usuario.UsuarioRepository;
import com.proyecto.planillas.util.AuthenticationRequest;
import com.proyecto.planillas.util.AuthenticationResponse;
import com.proyecto.planillas.util.RefreshTokenRequest;
import com.proyecto.planillas.util.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
       private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        // 1. Obtener empleado existente
        var empleado = empleadoRepository.findById(request.idEmpleado())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        // 2. Crear usuario
        var usuario = Usuario.builder()
                .user(request.usuario())                           // tu campo real
                .password(passwordEncoder.encode(request.password()))
                .empleado(empleado)                             // Aquí viene el rol REAL
                .build();

        usuarioRepository.save(usuario);

        // 3. UserDetails real
        var userDetails = new CustomUserDetail(usuario);

        // 4. Generar tokens
        var token = jwtService.generateToken(userDetails);
        var refresh = jwtService.generateRefreshToken(userDetails);

        return new AuthenticationResponse(token, refresh);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        // 1. Validar credenciales
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.usuario(),
                        request.password()
                )
        );

        // 2. Buscar usuario
        var usuario = usuarioRepository.findByUser(request.usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var userDetails = new CustomUserDetail(usuario);

        // 3. Tokens
        var token = jwtService.generateToken(userDetails);
        var refresh = jwtService.generateRefreshToken(userDetails);

        return new AuthenticationResponse(token, refresh);
    }

    public AuthenticationResponse refreshToken(RefreshTokenRequest request) {

        var userName = jwtService.extractUsername(request.refreshToken());

        var usuario = usuarioRepository.findByUser(userName)
                .orElseThrow();

        var userDetails = new CustomUserDetail(usuario);

        if (jwtService.isTokenValid(request.refreshToken(), userDetails)) {

            var newAccessToken = jwtService.generateToken(userDetails);

            return new AuthenticationResponse(
                    newAccessToken,
                    request.refreshToken()
            );
        }

        throw new RuntimeException("Token de refresco inválido");
    }
}