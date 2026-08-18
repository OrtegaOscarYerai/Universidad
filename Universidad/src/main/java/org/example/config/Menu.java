package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {
    static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static ProfesorDAO profesorDAO = new ProfesorDAO();

    public static void inscribir() throws IOException {
        Alumno nuevoAlumno = new Alumno();

        System.out.print("Numero expediente: ");
        nuevoAlumno.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        nuevoAlumno.setNombre(leer.readLine());
        System.out.print("Edad: ");
        nuevoAlumno.setEdad(Integer.parseInt(leer.readLine()));
        System.out.print("Carrera : (TI,QUI,MEC,MKT): ");
        nuevoAlumno.setCarrera(leer.readLine());
        System.out.print("Cuatrimestre: ");
        nuevoAlumno.setCuatrimestre(Integer.parseInt(leer.readLine()));

        alumnoDAO.nuevoAlumno(nuevoAlumno);
        System.out.println("Alumno inscrito con éxito.");
    }

    public static void mostrar() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumnos();
        System.out.println("--------Lista de alumnos inscritos--------");
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            for (Alumno al : alumnos) {
                System.out.println(al);
            }
        }
    }

    public static void modificar() throws IOException {
        System.out.println("--- Modificar Alumno ---");
        Alumno alumnoModificar = new Alumno();

        System.out.print("Número de expediente del alumno a modificar: ");
        alumnoModificar.setNumExpediente(Integer.parseInt(leer.readLine()));
        System.out.print("Nuevo Nombre: ");
        alumnoModificar.setNombre(leer.readLine());
        System.out.print("Nueva Edad: ");
        alumnoModificar.setEdad(Integer.parseInt(leer.readLine()));
        System.out.print("Nueva Carrera (TI,QUI,MEC,MKT): ");
        alumnoModificar.setCarrera(leer.readLine());
        System.out.print("Nuevo Cuatrimestre: ");
        alumnoModificar.setCuatrimestre(Integer.parseInt(leer.readLine()));

        alumnoDAO.actualizarAlumno(alumnoModificar);
        System.out.println("Alumno modificado con éxito.");
    }

    public static void borrar() throws IOException {
        System.out.println("--------Borrar alumno--------");
        Alumno alumnoBorrar = new Alumno();
        System.out.print("Número de expediente del alumno a modificar: ");
        alumnoBorrar.setNumExpediente(Integer.parseInt(leer.readLine()));
        alumnoDAO.borrarAlumno(alumnoBorrar);
    }

    public static void buscar() throws IOException {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("--------Buscar alumno--------");
        Alumno alumnoBuscar = new Alumno();
        System.out.print("Número de expediente del alumno a buscar: ");
        alumnoBuscar.setNumExpediente(Integer.parseInt(leer.readLine()));
        boolean encontrado = alumnoDAO.buscarAlumno(alumnoBuscar);
        if (encontrado) {
            System.out.println("\n[¡Alumno encontrado!]");
            System.out.println(alumnoBuscar);
        } else {
            System.out.println("No se encontró ningún alumno con ese número de expediente.");
        }
    }

    public static void registrarProfesor() throws IOException {
        Profesor nuevoProfesor = new Profesor();

        System.out.print("Número empleado: ");
        nuevoProfesor.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.print("Nombre: ");
        nuevoProfesor.setNombre(leer.readLine());
        System.out.print("Edad: ");
        nuevoProfesor.setEdad(Integer.parseInt(leer.readLine()));
        System.out.print("Puesto (gerente, docente, director): ");
        nuevoProfesor.setPuesto(leer.readLine());
        System.out.print("Cédula Profesional: ");
        nuevoProfesor.setCedulaProfesional(leer.readLine());

        profesorDAO.nuevoProfesor(nuevoProfesor);
    }

    public static void mostrarProfesores() {
        ArrayList<Profesor> profesores = profesorDAO.extraerProfesor();
        System.out.println("--------Lista de profesores registrados--------");
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            for (Profesor pr : profesores) {
                System.out.println(pr);
            }
        }
    }

    public static void modificarProfesor() throws IOException {
        System.out.println("--- Modificar Profesor ---");
        Profesor profesorModificar = new Profesor();

        System.out.print("Número de empleado del profesor a modificar: ");
        profesorModificar.setNumEmpleado(Integer.parseInt(leer.readLine()));
        System.out.print("Nuevo Nombre: ");
        profesorModificar.setNombre(leer.readLine());
        System.out.print("Nueva Edad: ");
        profesorModificar.setEdad(Integer.parseInt(leer.readLine()));
        System.out.print("Nuevo Puesto (gerente, docente, director): ");
        profesorModificar.setPuesto(leer.readLine());
        System.out.print("Nueva Cédula Profesional: ");
        profesorModificar.setCedulaProfesional(leer.readLine());

        profesorDAO.updatePro(profesorModificar);
    }

    public static void borrarProfesor() throws IOException {
        System.out.println("--------Borrar profesor--------");
        Profesor profesorBorrar = new Profesor();
        System.out.print("Número de empleado del profesor a eliminar: ");
        profesorBorrar.setNumEmpleado(Integer.parseInt(leer.readLine()));
        profesorDAO.deletePro(profesorBorrar);
    }

    public static void buscarProfesor() throws IOException {
        System.out.println("--------Buscar profesor--------");
        Profesor profesorBuscar = new Profesor();
        System.out.print("Número de empleado del profesor a buscar: ");
        profesorBuscar.setNumEmpleado(Integer.parseInt(leer.readLine()));

        ArrayList<Profesor> resultado = profesorDAO.buscarPro(profesorBuscar);
        if (!resultado.isEmpty()) {
            System.out.println("\n[¡Profesor encontrado!]");
            for (Profesor pr : resultado) {
                System.out.println(pr);
            }
        } else {
            System.out.println("No se encontró ningún profesor con ese número de empleado.");
        }
    }

    public static void menu() throws IOException {
        int salir = 0;
        while (salir != 11) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Inscribir nuevo alumno");
            System.out.println("2. Mostrar todos los alumnos");
            System.out.println("3. Modificar un alumno");
            System.out.println("4. Borrar un alumno");
            System.out.println("5. Buscar un alumno");
            System.out.println("6. Registrar nuevo profesor");
            System.out.println("7. Mostrar todos los profesores");
            System.out.println("8. Modificar un profesor");
            System.out.println("9. Borrar un profesor");
            System.out.println("10. Buscar un profesor");
            System.out.println("11. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                salir = Integer.parseInt(leer.readLine());
                switch (salir) {
                    case 1:
                        inscribir();
                        break;
                    case 2:
                        mostrar();
                        break;
                    case 3:
                        modificar();
                        break;
                    case 4:
                        borrar();
                        break;
                    case 5:
                        buscar();
                        break;
                    case 6:
                        registrarProfesor();
                        break;
                    case 7:
                        mostrarProfesores();
                        break;
                    case 8:
                        modificarProfesor();
                        break;
                    case 9:
                        borrarProfesor();
                        break;
                    case 10:
                        buscarProfesor();
                        break;
                    case 11:
                        System.out.println("Adios");
                        break;
                    default:
                        System.out.println("Teclea una opcion valida");
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }
        }
    }
}