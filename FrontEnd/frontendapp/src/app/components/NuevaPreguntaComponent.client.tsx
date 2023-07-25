"use client";
import React, { useState, ChangeEvent } from 'react';
import PythonTestService from '../services/PythonTestService';
import { Form, ButtonToolbar, Button, SelectPicker } from 'rsuite';

export function NuevaPreguntaComponent () {
  const [codigo, setCodigo] = useState('');
  const [respuesta, setRespuesta] = useState('');
  const [dificultad, setDificultad] = useState('');

  const changeCodigoHandler = (event: ChangeEvent<HTMLInputElement>) => {
    setCodigo(event.target.value);
  };

  const changeRespuestaHandler = (event: ChangeEvent<HTMLInputElement>) => {
    setRespuesta(event.target.value);
  };

  const changeDificultadHandler = (event: ChangeEvent<HTMLInputElement>) => {
    setDificultad(event.target.value);
  };

  const savePregunta = (e: React.FormEvent) => {
    e.preventDefault();
    PythonTestService.nuevaPregunta(codigo, respuesta, dificultad).then((res) => {
      window.alert('Se creó la nueva pregunta');
      window.location.href = '/';
    });
  };

  return (
    <div
      style={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center'
      }}
    >
      <h1>Nuevo Proveedor</h1>
      <div style={{ width: '1000px' }}></div>
      <Form>
        <Form.Group onChange={changeCodigoHandler}>
          <Form.ControlLabel>Codigo</Form.ControlLabel>
          <Form.Control name="codigo" />
        </Form.Group>

        <Form.Group onChange={changeRespuestaHandler}>
          <Form.ControlLabel>Respuesta</Form.ControlLabel>
          <Form.Control name="nombre" />
        </Form.Group>

        <Form.Group onChange={changeDificultadHandler}>
          <Form.ControlLabel>Dificultad</Form.ControlLabel>
          <Form.Control name="codigo" />
        </Form.Group>

        <Form.Group>
          <ButtonToolbar>
            <Button
              appearance="primary"
              style={{ width: 300 }}
              onClick={savePregunta}
            >
              Crear Pregunta
            </Button>
          </ButtonToolbar>
        </Form.Group>
      </Form>
    </div>
  );
};
