package com.tingeso.pythontestservice.services;

import com.tingeso.pythontestservice.repositories.PythonTestRepository;
import com.tingeso.pythontestservice.entities.PythonTestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PythonTestService {
    @Autowired
    private PythonTestRepository pythonTestRepository;

    public ArrayList<PythonTestEntity> obtenerData(){
        return (ArrayList<PythonTestEntity>) pythonTestRepository.findAll();
    }

    public PythonTestEntity createPythonTest(String codigo, String respuesta, String dificultad) {
        PythonTestEntity newPythonTest = new PythonTestEntity();
        newPythonTest.setCodigo(codigo);
        newPythonTest.setRespuesta(respuesta);
        newPythonTest.setDificultad(dificultad);

        return pythonTestRepository.save(newPythonTest);
    }

    public ArrayList<PythonTestEntity> getPreguntasByDificultad(String dificultad) {
        List<Integer> ids = pythonTestRepository.findIdsByDificultad(dificultad);
        if (ids.isEmpty()) {
            return null;
        }

        Random random = new Random();
        ArrayList<PythonTestEntity> preguntas = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(ids.size());
            int randomId = ids.get(randomIndex);

            PythonTestEntity pregunta = pythonTestRepository.findByIdent(randomId);
            if (pregunta != null) {
                preguntas.add(pregunta);
                ids.remove(randomIndex);
            }
        }

        return preguntas;
    }

    public double verificarRespuesta(String respuestaUsuario, String respuestaCorrecta) {
        if (respuestaUsuario.equals(respuestaCorrecta)) {
            return 7.0;
        } else {
            return 1.0;
        }
    }

    //Recibe una lista con todas las respuestas de los usuarios (guardarlas en la lista en el frontend),
    // y una lista con TODAS LAS PREGUNTAS que se mouestran por pantalla (generadas en una funcion anterior)
    public double promedio(ArrayList<String> respuestasUsuario, ArrayList<PythonTestEntity> preguntas){
        Double suma = 0.0;
        for (int i = 0; i < 4; i++) {
            Integer num = preguntas.get(i).getIdent();
            String respusuario = respuestasUsuario.get(i);
            String resppregunta = pythonTestRepository.findByIdent(num).getRespuesta();
            Double nota = verificarRespuesta(respusuario, resppregunta);
            suma += nota;
        }
        Double promedio = suma / 4;
        return promedio;
    }

}
