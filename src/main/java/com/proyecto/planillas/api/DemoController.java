package com.proyecto.planillas.api;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.subst.Token;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("demo")
public class DemoController {
    @PreAuthorize("user")
    public String sayHello() {
        return "Hello USUARIO from secured endpoint";
    }

    @GetMapping("admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String sayHelloAdmin() {
        return "Hello ADMINISTRADOR from secured endpoint";
    }

    
    
    
}
