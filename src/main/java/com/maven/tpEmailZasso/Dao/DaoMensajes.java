package com.maven.tpEmailZasso.Dao;

import com.maven.tpEmailZasso.Modelo.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 16/06/17.
 */
@Repository("repo2")
public class DaoMensajes {

    @Autowired
    private
    Connection con;

    public List allMessagesDao() {
        List<Mensaje> list = new ArrayList<Mensaje>();

        try {
            String cmd = "select * from Mensajes";
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(cmd);

            while (rs.next()) {
                Mensaje msj = new Mensaje(rs.getInt("id"), rs.getInt("userIdFrom"), rs.getInt("userIdTo"), rs.getString("remitente"), rs.getString("recipiente"), rs.getDate("fecha"), rs.getString("asunto"), rs.getString("cuerpo"), rs.getBoolean("recibidoBborrado"), rs.getBoolean("enviadoBorrado"));
                list.add(msj);
            }

        } catch (Exception e) {

        }
        return list;
    }

    public List msjEnviadosBorradosDao(int id) {
        List<Mensaje> list = new ArrayList<Mensaje>();

        try {
            String cmd = "select * from Mensajes where userIdFrom ="+id+" and enviadoBorrado = 1";
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(cmd);

            while (rs.next()) {
                Mensaje msj = new Mensaje(rs.getInt("id"), rs.getInt("userIdFrom"), rs.getInt("userIdTo"), rs.getString("remitente"), rs.getString("recipiente"), rs.getDate("fecha"), rs.getString("asunto"), rs.getString("cuerpo"), rs.getBoolean("recibidoBborrado"),rs.getBoolean("enviadoBorrado"));
                list.add(msj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List msjRecibidosBorradosDao(int id) {
        List<Mensaje> list = new ArrayList<Mensaje>();

        try {
            String cmd = "select * from Mensajes where userIdTo ="+id+" and recibidoBborrado = 1";
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(cmd);

            while (rs.next()) {
                Mensaje msj = new Mensaje(rs.getInt("id"), rs.getInt("userIdFrom"), rs.getInt("userIdTo"), rs.getString("remitente"), rs.getString("recipiente"), rs.getDate("fecha"), rs.getString("asunto"), rs.getString("cuerpo"), rs.getBoolean("recibidoBborrado"), rs.getBoolean("enviadoBorrado"));
                list.add(msj);
            }

        } catch (Exception e) {

        }
        return list;
    }

    public List msjeEnviadosXusuarioDao(int id) {
        List<Mensaje> list = new ArrayList<Mensaje>();

        try {
            String cmd = "select * from Mensajes where userIdFrom ="+id;
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(cmd);

            while (rs.next()) {
                Mensaje msj = new Mensaje(rs.getInt("id"), rs.getInt("userIdFrom"), rs.getInt("userIdTo"), rs.getString("remitente"), rs.getString("recipiente"), rs.getDate("fecha"), rs.getString("asunto"), rs.getString("cuerpo"), rs.getBoolean("recibidoBborrado"), rs.getBoolean("enviadoBorrado"));
                list.add(msj);
            }

        } catch (Exception e) {

        }
        return list;
    }

    public List msjRecibidosXusuarioDao(int id) {
        List<Mensaje> list = new ArrayList<Mensaje>();

        try {
            String cmd = "select * from Mensajes where userIdTo ="+id;
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(cmd);

            while (rs.next()) {
                Mensaje msj = new Mensaje(rs.getInt("id"), rs.getInt("userIdFrom"), rs.getInt("userIdTo"), rs.getString("remitente"), rs.getString("recipiente"), rs.getDate("fecha"), rs.getString("asunto"), rs.getString("cuerpo"), rs.getBoolean("recibidoBborrado"), rs.getBoolean("enviadoBorrado"));
                list.add(msj);
            }

        } catch (Exception e) {

        }
        return list;
    }

    public void mandarMailDao (int iduf, int idut, String rem, String rec, String asunto, String cuerpo)throws Exception
    {
        try {
            getCon().setAutoCommit(false);
            PreparedStatement ps = getCon().prepareStatement("INSERT INTO Mensajes (userIdFrom, userIdTo, remitente, recipiente, asunto, cuerpo) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, iduf);
            ps.setInt(2, idut);
            ps.setString(3, rem);
            ps.setString(4, rec);
            ps.setString(5, asunto);
            ps.setString(6, cuerpo);
            ps.execute();
            getCon().commit();
        } catch (Exception e) {
            throw  e;
        }
    }


    //ELIMINO DE MANERA LOGICA UN MENSAJE RECIBIDO
    public void borrarMensajeRecibidoDao(int iduser,int idmsj) throws Exception
    {
        try {
            getCon().setAutoCommit(false);
            PreparedStatement ps = getCon().prepareStatement("UPDATE Mensajes SET recibidoBborrado = ? WHERE userIdTo = ? AND id = ?");
            ps.setBoolean(1,true);
            ps.setInt(2, iduser);
            ps.setInt(3, idmsj);
            ps.execute();
            getCon().commit();
        } catch (Exception e) {
            throw  e;
        }
    }


    //ELIMINO DE MANERA LOGICA UN MENSAJE RECIBIDO
    public void borrarMensajeEnviadoDao(int iduser,int idmsj) throws Exception
    {
        try {
            getCon().setAutoCommit(false);
            PreparedStatement ps = getCon().prepareStatement("UPDATE Mensajes set enviadoBorrado = ? where userIdFrom = ? AND id = ?");
            ps.setBoolean(1,true);
            ps.setInt(2, iduser);
            ps.setInt(3, idmsj);
            ps.execute();
            getCon().commit();
        } catch (Exception e) {
            throw  e;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
