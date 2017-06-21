package com.maven.tpEmailZasso.Dao;

import com.maven.tpEmailZasso.Login.UserSesion;
import com.maven.tpEmailZasso.Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by martin on 07/06/17.
 */
@Repository("repo1")
public class DaoUsuarios {

    @Autowired
    private
    Connection con;


    public List<Usuario> listarUsuarios()throws Exception //TRAIGO TODOS LOS USUARIOS DE LA BASE
    {
        try {
            getCon().setAutoCommit(false);
            String sql = "SELECT * FROM Usuarios";
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Usuario> lista = new ArrayList<Usuario>();
            while (rs.next()) {
                Usuario user = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("ciudad"), rs.getString("pais"), rs.getString("provincia"), rs.getString("contrasenia"), rs.getString("mail"), rs.getBoolean("eliminado"));
                lista.add(user);
            }
            getCon().commit();
            return lista;
        } catch (SQLException e) {
            throw e;
        }



    }

    public List<Usuario> usuarioXnombre(String nombre)throws Exception //TRAIGO UN USUARIO POR NOMBRE
    {
        List<Usuario> list = new ArrayList<Usuario>();
        try {
            getCon().setAutoCommit(false);
            String sql = "select * from muestra_usuarios where nombre = ?";
            PreparedStatement st = getCon().prepareStatement(sql);
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("ciudad"), rs.getString("pais"), rs.getString("provincia"), rs.getString("contrasenia"), rs.getString("mail"), rs.getBoolean("eliminado"));
                list.add(user);
            }
            getCon().commit();

        } catch (SQLException e) {
            throw e;
        }
        return list;
    }

    public void agregaUser(String nombre, String apellido, String direccion, String telefono, String ciudad, String pais, String provincia, String contrasenia, String mail) throws Exception // AGREGA UN USUARIO DADO
    {
        try {
            getCon().setAutoCommit(false);
            String sql = "INSERT INTO Usuarios (nombre,apellido,direccion,telefono,ciudad,pais,provincia,contrasenia,mail) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = getCon().prepareStatement(sql);
            st.setString(1, nombre);
            st.setString(2, apellido);
            st.setString(3, direccion);
            st.setString(4, telefono);
            st.setString(5, ciudad);
            st.setString(6, pais);
            st.setString(7, provincia);
            st.setString(8, contrasenia);
            st.setString(9, mail);
            st.execute();
            getCon().commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void eliminaUsuario(int id) throws Exception //ELIMINA DE MANERA LOGICA AL USUARIO POR ID
    {
        try {
            getCon().setAutoCommit(false);
            String sql = "update Usuarios set eliminado = ? where id = ?";
            PreparedStatement st = getCon().prepareStatement(sql);
            st.setBoolean(1, true);
            st.setInt(2, id);
            st.execute();
            getCon().commit();
        } catch (SQLException e) {
            throw e;
        }
    }

    public UserSesion get(String nombreUsuario, String password) throws Exception { //GET DEL USUARIO PARA EL LOGIN
        List<UserSesion> lista = new ArrayList<UserSesion>();
        try {
            String cmd = "select id,nombre,contrasenia from Usuarios where nombre = '" + nombreUsuario + "' and contrasenia = '" + password + "'";
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(cmd);

            while (rs.next()) {
                UserSesion user = new UserSesion(rs.getInt("id"), rs.getString("nombre"), rs.getString("contrasenia"));
                lista.add(user);
            }
        } catch (Exception e) {
            throw e;
        }

        if (lista.size() == 1) {
            return lista.get(0);
        } else {
            return null;
        }

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
