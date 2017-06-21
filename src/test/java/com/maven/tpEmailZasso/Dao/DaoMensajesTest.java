package com.maven.tpEmailZasso.Dao;

import com.maven.tpEmailZasso.Modelo.Mensaje;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.*;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by martin on 20/06/17.
 */
@RunWith(PowerMockRunner.class)
public class DaoMensajesTest extends TestCase{

    DaoMensajes daoMensajes;
    Date fecha;

    @Before
    public void setUp() throws ParseException{
        try{

            Connection conn = Mockito.mock(Connection.class);
            Statement statement = Mockito.mock(Statement.class);
            Mockito.when(conn.createStatement()).thenReturn(statement);
            PreparedStatement preparedStatement1 = Mockito.mock(PreparedStatement.class);

            //MOCKEO allMessagesDao
            String cmd1 = "select * from Mensajes";
            fecha = Date.valueOf("2017-06-19");
            ResultSet resultSet1 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet1.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet1.getInt("id")).thenReturn(1);
            Mockito.when(resultSet1.getInt("userIdFrom")).thenReturn(1);
            Mockito.when(resultSet1.getInt("userIdTo")).thenReturn(2);
            Mockito.when(resultSet1.getString("remitente")).thenReturn("pruebaRemitente");
            Mockito.when(resultSet1.getString("recipiente")).thenReturn("pruebaRecipiente");
            Mockito.when(resultSet1.getDate("fecha")).thenReturn(fecha);
            Mockito.when(resultSet1.getString("asunto")).thenReturn("pruebaAsunto");
            Mockito.when(resultSet1.getString("cuerpo")).thenReturn("pruebaCuerpo");
            Mockito.when(resultSet1.getBoolean("recibidoBborrado")).thenReturn(false);
            Mockito.when(resultSet1.getBoolean("enviadoBorrado")).thenReturn(false);

            //MOCKEO msjEnviadosBorradosDao
            String cmd2 = "select * from Mensajes where userIdFrom =1 and enviadoBorrado = 1";
            fecha = Date.valueOf("2017-06-19");
            ResultSet resultSet2 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet2.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet2.getInt("id")).thenReturn(1);
            Mockito.when(resultSet2.getInt("userIdFrom")).thenReturn(1);
            Mockito.when(resultSet2.getInt("userIdTo")).thenReturn(2);
            Mockito.when(resultSet2.getString("remitente")).thenReturn("pruebaRemitente");
            Mockito.when(resultSet2.getString("recipiente")).thenReturn("pruebaRecipiente");
            Mockito.when(resultSet2.getDate("fecha")).thenReturn(fecha);
            Mockito.when(resultSet2.getString("asunto")).thenReturn("pruebaAsunto");
            Mockito.when(resultSet2.getString("cuerpo")).thenReturn("pruebaCuerpo");
            Mockito.when(resultSet2.getBoolean("recibidoBborrado")).thenReturn(false);
            Mockito.when(resultSet2.getBoolean("enviadoBorrado")).thenReturn(false);

            //MOCKEO msjRecibidosBorradosDao
            String cmd3 = "select * from Mensajes where userIdTo =1 and recibidoBborrado = 1";
            fecha = Date.valueOf("2017-06-19");
            ResultSet resultSet3 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet3.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet3.getInt("id")).thenReturn(1);
            Mockito.when(resultSet3.getInt("userIdFrom")).thenReturn(1);
            Mockito.when(resultSet3.getInt("userIdTo")).thenReturn(2);
            Mockito.when(resultSet3.getString("remitente")).thenReturn("pruebaRemitente");
            Mockito.when(resultSet3.getString("recipiente")).thenReturn("pruebaRecipiente");
            Mockito.when(resultSet3.getDate("fecha")).thenReturn(fecha);
            Mockito.when(resultSet3.getString("asunto")).thenReturn("pruebaAsunto");
            Mockito.when(resultSet3.getString("cuerpo")).thenReturn("pruebaCuerpo");
            Mockito.when(resultSet3.getBoolean("recibidoBborrado")).thenReturn(false);
            Mockito.when(resultSet3.getBoolean("enviadoBorrado")).thenReturn(false);

            //MOCKEO msjeEnviadosXusuarioDao
            String cmd4 = "select * from Mensajes where userIdFrom =1";
            fecha = Date.valueOf("2017-06-19");
            ResultSet resultSet4 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet4.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet4.getInt("id")).thenReturn(1);
            Mockito.when(resultSet4.getInt("userIdFrom")).thenReturn(1);
            Mockito.when(resultSet4.getInt("userIdTo")).thenReturn(2);
            Mockito.when(resultSet4.getString("remitente")).thenReturn("pruebaRemitente");
            Mockito.when(resultSet4.getString("recipiente")).thenReturn("pruebaRecipiente");
            Mockito.when(resultSet4.getDate("fecha")).thenReturn(fecha);
            Mockito.when(resultSet4.getString("asunto")).thenReturn("pruebaAsunto");
            Mockito.when(resultSet4.getString("cuerpo")).thenReturn("pruebaCuerpo");
            Mockito.when(resultSet4.getBoolean("recibidoBborrado")).thenReturn(false);
            Mockito.when(resultSet4.getBoolean("enviadoBorrado")).thenReturn(false);

            //MOCKEO msjRecibidosXusuarioDao
            String cmd5 = "select * from Mensajes where userIdTo =1";
            fecha = Date.valueOf("2017-06-19");
            ResultSet resultSet5 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet5.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet5.getInt("id")).thenReturn(1);
            Mockito.when(resultSet5.getInt("userIdFrom")).thenReturn(1);
            Mockito.when(resultSet5.getInt("userIdTo")).thenReturn(2);
            Mockito.when(resultSet5.getString("remitente")).thenReturn("pruebaRemitente");
            Mockito.when(resultSet5.getString("recipiente")).thenReturn("pruebaRecipiente");
            Mockito.when(resultSet5.getDate("fecha")).thenReturn(fecha);
            Mockito.when(resultSet5.getString("asunto")).thenReturn("pruebaAsunto");
            Mockito.when(resultSet5.getString("cuerpo")).thenReturn("pruebaCuerpo");
            Mockito.when(resultSet5.getBoolean("recibidoBborrado")).thenReturn(false);
            Mockito.when(resultSet5.getBoolean("enviadoBorrado")).thenReturn(false);

            //MOCKEO mandarMailDao
            String cmd6 = "INSERT INTO Mensajes (userIdFrom, userIdTo, remitente, recipiente, asunto, cuerpo) VALUES (?,?,?,?,?,?)";
            Mockito.doThrow(new SQLException()).when(preparedStatement1).setString(3,"nombre_usuario1");
            Mockito.when(conn.prepareStatement(cmd6)).thenReturn(preparedStatement1);

            //MOCKEO borrarMensajeRecibidoDao
            String cmd7 = "UPDATE Mensajes SET recibidoBborrado = ? WHERE userIdTo = ? AND id = ?";
            Mockito.doThrow(new SQLException()).when(preparedStatement1).setInt(2,2);
            Mockito.when(conn.prepareStatement(cmd7)).thenReturn(preparedStatement1);

            //MOCKEO borrarMensajeEnviadoDao
            String cmd8 = "UPDATE Mensajes set enviadoBorrado = ? where userIdFrom = ? AND id = ?";
            Mockito.doThrow(new SQLException()).when(preparedStatement1).setInt(2,2);
            Mockito.when(conn.prepareStatement(cmd8)).thenReturn(preparedStatement1);

            Mockito.when(statement.executeQuery(cmd1)).thenReturn(resultSet1);
            Mockito.when(statement.executeQuery(cmd2)).thenReturn(resultSet2);
            Mockito.when(statement.executeQuery(cmd3)).thenReturn(resultSet3);
            Mockito.when(statement.executeQuery(cmd4)).thenReturn(resultSet4);
            Mockito.when(statement.executeQuery(cmd5)).thenReturn(resultSet5);


            daoMensajes = new DaoMensajes();
            daoMensajes.setCon(conn);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    @Test
    public void allMessagesDao() throws Exception {
        Mensaje msj = new Mensaje();
        List<Mensaje> list = daoMensajes.allMessagesDao();
        for(Mensaje m : list)
        {
            msj = m;
        }
        assertEquals(msj.getId(),1);
        assertEquals(msj.getUserIdFrom(),1);
        assertEquals(msj.getUserIdTo(),2);
        assertEquals(msj.getRemitente(),"pruebaRemitente");
        assertEquals(msj.getRecipiente(),"pruebaRecipiente");
        assertEquals(msj.getFecha(),fecha);
        assertEquals(msj.getAsunto(),"pruebaAsunto");
        assertEquals(msj.getCuerpo(),"pruebaCuerpo");
        assertEquals(msj.isRecibidoBborrado(),false);
        assertEquals(msj.isEnviadoBorrado(),false);
    }

    @Test
    public void msjEnviadosBorradosDao() throws Exception {
        Mensaje msj = new Mensaje();
        List<Mensaje> list = daoMensajes.msjEnviadosBorradosDao(1);
        for(Mensaje m : list)
        {
            msj = m;
        }
        assertEquals(msj.getId(),1);
        assertEquals(msj.getUserIdFrom(),1);
        assertEquals(msj.getUserIdTo(),2);
        assertEquals(msj.getRemitente(),"pruebaRemitente");
        assertEquals(msj.getRecipiente(),"pruebaRecipiente");
        assertEquals(msj.getFecha(),fecha);
        assertEquals(msj.getAsunto(),"pruebaAsunto");
        assertEquals(msj.getCuerpo(),"pruebaCuerpo");
        assertEquals(msj.isRecibidoBborrado(),false);
        assertEquals(msj.isEnviadoBorrado(),false);
    }

    @Test
    public void msjRecibidosBorradosDao() throws Exception {
        Mensaje msj = new Mensaje();
        List<Mensaje> list = daoMensajes.msjRecibidosBorradosDao(1);
        for(Mensaje m : list)
        {
            msj = m;
        }
        assertEquals(msj.getId(),1);
        assertEquals(msj.getUserIdFrom(),1);
        assertEquals(msj.getUserIdTo(),2);
        assertEquals(msj.getRemitente(),"pruebaRemitente");
        assertEquals(msj.getRecipiente(),"pruebaRecipiente");
        assertEquals(msj.getFecha(),fecha);
        assertEquals(msj.getAsunto(),"pruebaAsunto");
        assertEquals(msj.getCuerpo(),"pruebaCuerpo");
        assertEquals(msj.isRecibidoBborrado(),false);
        assertEquals(msj.isEnviadoBorrado(),false);
    }

    @Test
    public void msjeEnviadosXusuarioDao() throws Exception {
        Mensaje msj = new Mensaje();
        List<Mensaje> list = daoMensajes.msjeEnviadosXusuarioDao(1);
        for(Mensaje m : list)
        {
            msj = m;
        }
        assertEquals(msj.getId(),1);
        assertEquals(msj.getUserIdFrom(),1);
        assertEquals(msj.getUserIdTo(),2);
        assertEquals(msj.getRemitente(),"pruebaRemitente");
        assertEquals(msj.getRecipiente(),"pruebaRecipiente");
        assertEquals(msj.getFecha(),fecha);
        assertEquals(msj.getAsunto(),"pruebaAsunto");
        assertEquals(msj.getCuerpo(),"pruebaCuerpo");
        assertEquals(msj.isRecibidoBborrado(),false);
        assertEquals(msj.isEnviadoBorrado(),false);
    }

    @Test
    public void msjRecibidosXusuarioDao() throws Exception {
        Mensaje msj = new Mensaje();
        List<Mensaje> list = daoMensajes.msjRecibidosXusuarioDao(1);
        for(Mensaje m : list)
        {
            msj = m;
        }
        assertEquals(msj.getId(),1);
        assertEquals(msj.getUserIdFrom(),1);
        assertEquals(msj.getUserIdTo(),2);
        assertEquals(msj.getRemitente(),"pruebaRemitente");
        assertEquals(msj.getRecipiente(),"pruebaRecipiente");
        assertEquals(msj.getFecha(),fecha);
        assertEquals(msj.getAsunto(),"pruebaAsunto");
        assertEquals(msj.getCuerpo(),"pruebaCuerpo");
        assertEquals(msj.isRecibidoBborrado(),false);
        assertEquals(msj.isEnviadoBorrado(),false);
    }

    @Test
    public void mandarMailDao() throws Exception {
        boolean ok = false;
        try
        {
            daoMensajes.mandarMailDao(1, 2, "remitente", "recipiente", "asunto", "cuerpo");
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);
    }

    @Test
    public void mandarMailDao_error()
    {
        boolean error = false;
        try
        {
            daoMensajes.mandarMailDao(1, 2, "nombre_usuario1", "recipiente", "asunto", "cuerpo");
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }

    @Test
    public void borrarMensajeRecibidoDao() throws Exception {
        boolean ok = false;
        try{
            daoMensajes.borrarMensajeRecibidoDao(1,1);
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);
    }

    @Test
    public void borrarMensajeRecibidoDao_error()throws Exception
    {
        boolean error = false;
        try
        {
            daoMensajes.borrarMensajeRecibidoDao(2,1);
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }


    @Test
    public void borrarMensajeEnviadoDao() throws Exception {
        boolean ok = false;
        try
        {
            daoMensajes.borrarMensajeEnviadoDao(1,1);
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);
    }

    @Test
    public void borrarMensajeEnviadoDao_error()throws Exception{
        boolean error = false;
        try{
            daoMensajes.borrarMensajeEnviadoDao(2,2);
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }


}