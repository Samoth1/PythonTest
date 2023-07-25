import axios from 'axios';

const url = 'http://localhost:8080/pythontest';

class PythonTestService {

    obtenerPreguntas(dificultad: string){
        return axios.get(`${url}/preguntas?dificultad=${dificultad}`);
    }

    nuevaPregunta(codigo: string, respuesta: string, dificultad:string){
        console.log(codigo);
        console.log(respuesta);
        console.log(dificultad);
        return axios.post(`${url}?codigo=${codigo}&respuesta=${respuesta}&dificultad=${dificultad}`);
    }

}

const instance = new PythonTestService();
export default instance;