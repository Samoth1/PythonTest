import React, { Component, ChangeEvent } from 'react';
import PythonTestService from '../services/PythonTestService';
import { Form, ButtonToolbar, Button, SelectPicker } from 'rsuite';

interface DificultadState {
    dificultad: string;
  }

class DificultadComponent extends Component<{}, DificultadState> {
    constructor(props: {}) {
      super(props);
      this.state = {
        dificultad: ''
      };
    }

    changeCategoriaHandler = (value: any) => {
        this.setState({ dificultad: value });
    };

    getPreguntas = (e: React.FormEvent) => {
        e.preventDefault();
        PythonTestService.obtenerPreguntas(
          this.state.dificultad
        ).then((res) => {
          window.alert('Se obtuvieron las preguntas');
          window.location.href = '/proveedor';
        });
      };

    render() {
        
        const dataDificultad = ['facil', 'medio', 'dificil'].map((dificultad) => ({
            label: dificultad,
            value: dificultad
          }));
    
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
              <Form.Group>
                <p>Categoria</p>
                <SelectPicker
                  data={dataDificultad}
                  searchable={false}
                  style={{ width: 300 }}
                  onChange={this.changeCategoriaHandler}
                />
              </Form.Group>
              <Form.Group>
            <ButtonToolbar>
              <Button
                appearance="primary"
                style={{ width: 300 }}
                onClick={this.getPreguntas}
              >
                Crear Proveedor
              </Button>
            </ButtonToolbar>
          </Form.Group>
        </Form>
        </div>
        );
    }
}