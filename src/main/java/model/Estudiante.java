package model;

// Modelo de Estudiante. El id es final porque nunca cambia.
// nombre y carrera pueden modificarse, por eso se permiten setters solo para ellos.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Estudiante {

    private final String id;

    @Setter
    private String nombre;

    @Setter
    private String carrera;
}
