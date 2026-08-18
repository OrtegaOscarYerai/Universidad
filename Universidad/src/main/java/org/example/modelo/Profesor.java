package org.example.modelo;

import java.util.Locale;

public class Profesor {
    private int numEmpleado;
    private String nombre;
    private int edad;
    private String puesto;
    private String cedulaProfesional;

    private static final String[] PUESTOS_VALIDOS = {"GERENTE", "DOCENTE", "DIRECTOR"};

    public Profesor() {}

    public Profesor(int numEmpleado, String nombre, int edad, String puesto, String cedulaProfesional) {
        setNumEmpleado(numEmpleado);
        setNombre(nombre);
        setEdad(edad);
        setPuesto(puesto);
        setCedulaProfesional(cedulaProfesional);
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre.toUpperCase(Locale.ROOT);
    }

    public void setNombre(String nombre) {
        if (nombre.isBlank() || nombre.isEmpty()) {
            System.out.println("Error el nombre es requerido ");
        } else {
            this.nombre = nombre;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 18 && edad < 110) { // Ajustado a 18 por ser profesor
            this.edad = edad;
        } else {
            System.out.println("La edad debe de ser de 18 a 110");
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (validarPuestos(puesto)) {
            this.puesto = puesto.toUpperCase(Locale.ROOT);
        } else {
            System.out.println("Puesto no valido");
        }
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        if (cedulaProfesional.isBlank() || cedulaProfesional.isEmpty()) {
            System.out.println("Error la cédula profesional es requerida ");
        } else {
            this.cedulaProfesional = cedulaProfesional;
        }
    }

    @Override
    public String toString() {
        return "numEmpleado="       + numEmpleado + '\n' +
                "nombre="            + nombre + '\n' +
                "edad="              + edad + '\n' +
                "puesto="            + puesto + '\n' +
                "cedulaProfesional=" + cedulaProfesional + '\n' +
                "--------------------------------------";
    }

    public boolean validarPuestos(String puesto) {
        boolean puestoValido = false;
        for (String validar : PUESTOS_VALIDOS) {
            if (puesto.equalsIgnoreCase(validar)) {
                return true;
            }
        }
        return puestoValido;
    }
