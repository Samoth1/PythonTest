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

    @PostMapping
    public ResponseEntity<?> guardarProveedor(@RequestBody PythonTestEntity pregunta){
        pythonTestService.createPythonTest(pregunta.getCodigo(), pregunta.getRespuesta() , pregunta.getRespuesta());
        return ResponseEntity.ok().build();
    }

}
