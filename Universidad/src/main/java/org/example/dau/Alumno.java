package org.example.modelo;

import java.util.Locale;

public class Alumno {
    private int numExpediente;
    private String nombre;
    private int edad;
    private String carrera;
    private int cuatrimestre;
    private boolean registroCorrecto=false;

    private static final String[] CARRERAS_VALIDAS = {"TI","QUI","MEC","MKT"};
    public Alumno(){}

    public Alumno(int numExpediente, String nombre, int edad, String carrera, int cuatrimestre) {
        setNumExpediente(numExpediente);
        setNombre(nombre);
        setEdad(edad);
        setCarrera(carrera);
        setCuatrimestre(cuatrimestre);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNombre() {
        return nombre.toUpperCase(Locale.ROOT);
    }

    public void setNombre(String nombre) {
        if(nombre.isBlank() || nombre.isEmpty()){
            System.out.println("Error el nombre es requerido ");
        }
        else{
            this.nombre=nombre;
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad>15 && edad< 110){
            this.edad=edad;
        }
        else {
            System.out.println("La edad debe de ser de 15 a 110");
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        if(validarCarreras(carrera)){
            this.carrera=carrera;
        }
        else{
            System.out.println("Carrera no valida");
        }
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        if(cuatrimestre>0 && cuatrimestre<12){
            this.cuatrimestre=cuatrimestre;
        }
        else{
            System.out.println("El cuatrimestre debe ser entre 1 y 12");
        }
    }

    @Override
    public String toString() {
        return "numExpediente=" + numExpediente + '\n' +
                "nombre="       + nombre + '\n' +
                "edad="         + edad +'\n' +
                "carrera="      + carrera + '\n' +
                "cuatrimestre=" + cuatrimestre +'\n'+
                "--------------------------------------";
    }

    public boolean validarCarreras(String carrera){
        boolean carreraValida=false;
        for(String validar : CARRERAS_VALIDAS){
            if(carrera.equalsIgnoreCase(validar)){
                return true;
            }
        }

        return carreraValida;
    }
}
