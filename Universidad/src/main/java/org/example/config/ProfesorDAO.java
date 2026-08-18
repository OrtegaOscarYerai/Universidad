package org.example.dao;

import org.example.config.Conexion;
import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDAO {

    public void agregarProfesor(Profesor profesor){

        String sql = "INSERT INTO profesor(nombre,apellido,correo,carrera) VALUES(?,?,?,?)";

        try{

            Connection conexion = Conexion.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setString(3, profesor.getCorreo());
            ps.setString(4, profesor.getCarrera());

            ps.executeUpdate();

            System.out.println("Profesor agregado correctamente.");

            ps.close();
            conexion.close();

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

    }

}