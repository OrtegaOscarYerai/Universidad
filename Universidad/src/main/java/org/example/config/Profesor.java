package org.example.modelo;

public class Profesor {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String carrera;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, String correo, String carrera) {
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setCarrera(carrera);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if(id > 0)
            this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if(nombre != null && !nombre.trim().isEmpty()){

            this.nombre = formato(nombre);

        }else{

            this.nombre = "Sin nombre";

        }

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {

        if(apellido != null && !apellido.trim().isEmpty()){

            this.apellido = formato(apellido);

        }else{

            this.apellido = "Sin apellido";

        }

    }

    public String getCorreo() {

        return correo.toLowerCase();

    }

    public void setCorreo(String correo) {

        if(correo.contains("@")){

            this.correo = correo;

        }else{

            this.correo = "correo@invalido.com";

        }

    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {

        if(carrera != null && !carrera.trim().isEmpty()){

            this.carrera = formato(carrera);

        }else{

            this.carrera = "Sin carrera";

        }

    }

    private String formato(String texto){

        texto = texto.toLowerCase();

        return texto.substring(0,1).toUpperCase()+texto.substring(1);

    }

    @Override
    public String toString() {

        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';

    }
}