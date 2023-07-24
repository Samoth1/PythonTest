package com.tingeso.pythontestservice.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "pregunta")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PythonTestEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ident;
    private String codigo;
    private String respuesta;
    private String dificultad;
}