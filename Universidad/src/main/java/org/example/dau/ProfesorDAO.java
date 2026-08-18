package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfesorDAO {

    public boolean nuevoProfesor(Profesor profesor){

        boolean registrado=false;

        String sql="INSERT INTO profesor VALUES (?,?,?,?,?,?)";

        try(Connection conexion= Conexion.conectar();
            PreparedStatement stm=conexion.prepareStatement(sql)){

            stm.setInt(1, profesor.getNumEmpleado());
            stm.setString(2, profesor.getNombre());
            stm.setInt(3, profesor.getEdad());
            stm.setString(4, profesor.getPuesto());
            stm.setString(5, profesor.getCedulaProfesional());
            stm.setString(6, profesor.getCurp());
            stm.executeUpdate();

            registrado=true;

            System.out.println("Profesor agregado correctamente");

        }catch(SQLException err){

            System.out.println("Error al registrar profesor: "+err.getMessage());

        }

        return registrado;

    }

    public ArrayList<Profesor> extraerProfesores(){

        ArrayList<Profesor> profesores=new ArrayList<>();

        String sql="SELECT * FROM profesor";

        try(Connection conexion=Conexion.conectar();
            PreparedStatement stm=conexion.prepareStatement(sql);
            ResultSet rs=stm.executeQuery()){

            while(rs.next()){

                Profesor profesor=new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setCedulaProfesional(rs.getString("cedulaProfesional"));
                profesor.setCurp(rs.getString("curp"));
                profesores.add(profesor);

            }

        }catch(SQLException err){

            System.out.println("Error al consultar profesores: "+err.getMessage());

        }

        return profesores;

    }
    public boolean actualizarProfesor(Profesor profesor){

        boolean actualizado = false;

        String sql = "UPDATE profesor SET nombre=?, edad=?, puesto=?, cedulaProfesional=?, curp=? WHERE numEmpleado=?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setString(1, profesor.getNombre());
            stm.setInt(2, profesor.getEdad());
            stm.setString(3, profesor.getPuesto());
            stm.setString(4, profesor.getCedulaProfesional());
            stm.setString(5, profesor.getCurp());
            stm.setInt(6, profesor.getNumEmpleado());

            int registrosAfectados = stm.executeUpdate();

            if(registrosAfectados > 0){
                System.out.println("PROFESOR ACTUALIZADO CORRECTAMENTE");
                actualizado = true;
            }else{
                System.out.println("NO SE ENCONTRO EL NUMERO DE EMPLEADO");
            }

        }catch(SQLException err){

            System.out.println("ERROR AL ACTUALIZAR PROFESOR: " + err.getMessage());

        }

        return actualizado;
    }
    public boolean borrarProfesor(int numEmpleado){

        boolean eliminado = false;
        String sql = "DELETE FROM profesor WHERE numEmpleado=?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){
            stm.setInt(1, numEmpleado);
            int registrosAfectados = stm.executeUpdate();

            if(registrosAfectados > 0){
                eliminado = true;
                System.out.println("PROFESOR ELIMINADO CORRECTAMENTE");
            }else{

                System.out.println("NO SE ENCONTRO EL NUMERO DE EMPLEADO");

            }

        }catch(SQLException err){

            System.out.println("ERROR AL ELIMINAR PROFESOR: " + err.getMessage());

        }

        return eliminado;
    }
    public Profesor buscarProfesor(int numEmpleado){

        Profesor profesor = null;

        String sql = "SELECT * FROM profesor WHERE numEmpleado=?";

        try(Connection conexion = Conexion.conectar();
            PreparedStatement stm = conexion.prepareStatement(sql)){

            stm.setInt(1, numEmpleado);

            ResultSet rs = stm.executeQuery();

            if(rs.next()){

                profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setCedulaProfesional(rs.getString("cedulaProfesional"));

            }else{

                System.out.println("NO SE ENCONTRO EL PROFESOR");

            }

        }catch(SQLException err){

            System.out.println("ERROR AL BUSCAR PROFESOR: " + err.getMessage());

        }

        return profesor;
    }

}
