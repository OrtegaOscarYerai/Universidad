package org.example;

import org.example.dao.ProfesorDAO;
import org.example.modelo.Profesor;

public class Main {

    public static void main(String[] args) {

        Profesor profesor = new Profesor(
                "Oscar",
                "Ortega",
                "oscar@gmail.com",
                "Tecnologías de la Información"
        );

        ProfesorDAO dao = new ProfesorDAO();

        dao.agregarProfesor(profesor);

    }

}