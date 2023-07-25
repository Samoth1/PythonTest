import React, { Component } from 'react';
import { Grid, Row, Col } from 'rsuite';

export default class HomeComponent extends Component {
  redireccionar(direccion: string) {
    window.location.href = direccion;
  }

  render() {
    return (
      <Grid>
        <Row>
          <Col xs={8}>
            <h1>Crear Pregunta</h1>
            <button onClick={() => this.redireccionar('/nuevoproveedor')}>
              Crear Pregunta
            </button>
          </Col>
          <Col xs={8}>
            <h1>Realizar Prueba</h1>
            <button onClick={() => this.redireccionar('/subirarchivos')}>
                Empezar Prueba
            </button>
          </Col>
        </Row>
        <br /><br /><br /><br /><br /><br />
      </Grid>
    );
  }
}