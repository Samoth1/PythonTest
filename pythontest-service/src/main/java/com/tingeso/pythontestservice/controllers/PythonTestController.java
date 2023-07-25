package com.tingeso.pythontestservice.controllers;

import com.tingeso.pythontestservice.entities.PythonTestEntity;
import com.tingeso.pythontestservice.services.PythonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/pythontest")
public class PythonTestController {
    @Autowired
    PythonTestService pythonTestService;

    @GetMapping
    public ResponseEntity<ArrayList<PythonTestEntity>> listadoProblemas(){
        ArrayList<PythonTestEntity> listaProblemas = pythonTestService.obtenerData();
        if(listaProblemas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(listaProblemas);
    }

    // PRUEBA PARA VER SI RETORNA LAS PREGUNTAS
    @GetMapping("/preguntas")
    public ResponseEntity<ArrayList<PythonTestEntity>> listadoPreguntas(@RequestParam("dificultad") String dificultad){
        ArrayList<PythonTestEntity> preguntas = pythonTestService.getPreguntasByDificultad(dificultad);
        return ResponseEntity.ok(preguntas);
    }

    @PostMapping
    public ResponseEntity<?> guardarPregunta(@RequestParam("codigo") String codigo,
                                              @RequestParam("respuesta") String respuesta,
                                              @RequestParam("dificultad") String dificultad){
        pythonTestService.createPythonTest(codigo, respuesta, dificultad);
        return ResponseEntity.ok().build();
    }

}
