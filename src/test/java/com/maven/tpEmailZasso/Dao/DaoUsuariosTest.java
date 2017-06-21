package com.maven.tpEmailZasso.Dao;

import com.maven.tpEmailZasso.Login.UserSesion;
import com.maven.tpEmailZasso.Modelo.Usuario;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by martin on 20/06/17.
 */
@RunWith(PowerMockRunner.class)
public class DaoUsuariosTest extends TestCase{

    DaoUsuarios daoUsuarios;


    @Before
    public void setUp() throws ParseException
    {
        try {


            Statement statement = Mockito.mock(Statement.class);
            Connection conn = Mockito.mock(Connection.class);
            PreparedStatement preparedStatement1 = Mockito.mock(PreparedStatement.class);

            //MOCKEO CONSULTA GET
            String cmd1 = "select id,nombre,contrasenia from Usuarios where nombre = 'prueba' and contrasenia = '123456'";
            ResultSet resultSet1 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet1.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet1.getInt("id")).thenReturn(1);
            Mockito.when(resultSet1.getString("nombre")).thenReturn("prueba");
            Mockito.when(resultSet1.getString("contrasenia")).thenReturn("123456");


            //MOCKEO CONSULTA LISTAR USUARIOS
            String cmd2 = "SELECT * FROM Usuarios";
            ResultSet resultSet2 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet2.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet2.getInt("id")).thenReturn(1);
            Mockito.when(resultSet2.getString("nombre")).thenReturn("pruebaNombre");
            Mockito.when(resultSet2.getString("apellido")).thenReturn("pruebaApellido");
            Mockito.when(resultSet2.getString("direccion")).thenReturn("pruebaDireccion");
            Mockito.when(resultSet2.getString("telefono")).thenReturn("pruebaTelefono");
            Mockito.when(resultSet2.getString("ciudad")).thenReturn("pruebaCiudad");
            Mockito.when(resultSet2.getString("pais")).thenReturn("pruebaPais");
            Mockito.when(resultSet2.getString("provincia")).thenReturn("pruebaProvincia");
            Mockito.when(resultSet2.getString("contrasenia")).thenReturn("pruebaContrasenia");
            Mockito.when(resultSet2.getString("mail")).thenReturn("pruebaMail");
            Mockito.when(resultSet2.getBoolean("eliminado")).thenReturn(false);

            //MOCKEO USUARIO POR NOMBRE
            String cmd3 = "select * from muestra_usuarios where nombre = ?";
            ResultSet resultSet3 = Mockito.mock(ResultSet.class);
            Mockito.when(resultSet3.next()).thenReturn(true).thenReturn(false);
            Mockito.when(resultSet3.getInt("id")).thenReturn(1);
            Mockito.when(resultSet3.getString("nombre")).thenReturn("pruebaNombre");
            Mockito.when(resultSet3.getString("apellido")).thenReturn("pruebaApellido");
            Mockito.when(resultSet3.getString("direccion")).thenReturn("pruebaDireccion");
            Mockito.when(resultSet3.getString("telefono")).thenReturn("pruebaTelefono");
            Mockito.when(resultSet3.getString("ciudad")).thenReturn("pruebaCiudad");
            Mockito.when(resultSet3.getString("pais")).thenReturn("pruebaPais");
            Mockito.when(resultSet3.getString("provincia")).thenReturn("pruebaProvincia");
            Mockito.when(resultSet3.getString("contrasenia")).thenReturn("pruebaContrasenia");
            Mockito.when(resultSet3.getString("mail")).thenReturn("pruebaMail");
            Mockito.when(resultSet3.getBoolean("eliminado")).thenReturn(false);

            //MOCKEO AGREGAR USUARIO
            String cmd4 = "INSERT INTO Usuarios (nombre,apellido,direccion,telefono,ciudad,pais,provincia,contrasenia,mail) VALUES (?,?,?,?,?,?,?,?,?)";
            Mockito.doThrow(new SQLException()).when(preparedStatement1).setString(1,"nombre_usuario1");
            Mockito.when(conn.prepareStatement(cmd4)).thenReturn(preparedStatement1);

            //MOCKEO ELIMINAR USUARIO
            String cmd5 = "update Usuarios set eliminado = ? where id = ?";
            Mockito.when(conn.prepareStatement(cmd5)).thenReturn(preparedStatement1);
            Mockito.doThrow(new SQLException()).when(preparedStatement1).setInt(2,2);


            Mockito.when(statement.executeQuery(cmd1)).thenReturn(resultSet1);//MOCKEO CONSULTA GET
            Mockito.when(statement.executeQuery(cmd2)).thenReturn(resultSet2);//MOCKEO CONSULTA LISTARUSUARIOS
            Mockito.when(preparedStatement1.executeQuery()).thenReturn(resultSet3);//MOCKEO USUARIO POR NOMBRE

            Mockito.when(conn.createStatement()).thenReturn(statement);
            Mockito.when(conn.prepareStatement(cmd3)).thenReturn(preparedStatement1);

            daoUsuarios = new DaoUsuarios();
            daoUsuarios.setCon(conn);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Test
    public void listarUsuarios() throws Exception {
        Usuario user = new Usuario();
        List<Usuario> list= daoUsuarios.listarUsuarios();
        for(Usuario u : list)
        {
            user = u;
        }
        assertEquals(user.getId(),1);
        assertEquals(user.getNombre(),"pruebaNombre");
        assertEquals(user.getApellido(),"pruebaApellido");
        assertEquals(user.getDireccion(),"pruebaDireccion");
        assertEquals(user.getTelefono(),"pruebaTelefono");
        assertEquals(user.getCiudad(),"pruebaCiudad");
        assertEquals(user.getPais(),"pruebaPais");
        assertEquals(user.getProvincia(),"pruebaProvincia");
        assertEquals(user.getContrasenia(),"pruebaContrasenia");
        assertEquals(user.getMail(),"pruebaMail");
        assertEquals(user.isEliminado(),false);
    }



    @Test
    public void usuarioXnombre() throws Exception {
        Usuario user = new Usuario();
        List<Usuario> list= daoUsuarios.usuarioXnombre("pruebaNombre");
        for(Usuario u : list)
        {
            user = u;
        }
        assertEquals(user.getId(),1);
        assertEquals(user.getNombre(),"pruebaNombre");
        assertEquals(user.getApellido(),"pruebaApellido");
        assertEquals(user.getDireccion(),"pruebaDireccion");
        assertEquals(user.getTelefono(),"pruebaTelefono");
        assertEquals(user.getCiudad(),"pruebaCiudad");
        assertEquals(user.getPais(),"pruebaPais");
        assertEquals(user.getProvincia(),"pruebaProvincia");
        assertEquals(user.getContrasenia(),"pruebaContrasenia");
        assertEquals(user.getMail(),"pruebaMail");
        assertEquals(user.isEliminado(),false);
    }

    @Test
    public void agregaUser() throws Exception {
        boolean ok = false;
        try
        {
            daoUsuarios.agregaUser("nombre","apellido","direccion","telefono","ciudad","pais","provincia","contrasenia","mail");
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);

    }

    @Test
    public void crearUsuario_error() {
        boolean error = false;
        try
        {
            daoUsuarios.agregaUser("nombre_usuario1","apellido","direccion","telefono","ciudad","pais","provincia","contrasenia","mail");
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }



    @Test
    public void eliminaUsuario() throws Exception {
        boolean ok = false;
        try
        {
            daoUsuarios.eliminaUsuario(1);
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);

    }

    @Test
    public void eliminar_usuario_error() {
        boolean error = false;
        try
        {
            daoUsuarios.eliminaUsuario(2);
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }


    @Test
    public void get() throws Exception {
        UserSesion u = daoUsuarios.get("prueba","123456");
        Assert.assertEquals(u.getNombreUsuario(),"prueba");
        Assert.assertEquals(u.getPassword(),"123456");

    }

    @Test
    public void getvacio() {
        UserSesion u = null;
        try {
            u = daoUsuarios.get("prueba2", "654321");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(u == null);
    }


}