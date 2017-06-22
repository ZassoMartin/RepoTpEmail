package com.maven.tpEmailZasso.Controladora;

import com.maven.tpEmailZasso.Modelo.Usuario;
import com.maven.tpEmailZasso.Servicio.ServiceUsuario;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by martin on 21/06/17.
 */
@RunWith(PowerMockRunner.class)
public class controlaUsuariosTest extends TestCase {

    Usuario user;
    ServiceUsuario su;
    List lista;
    controlaUsuarios control;
    ResponseEntity<List<Usuario>> lu;
    ResponseEntity reCreado;
    ResponseEntity reEliminado;


    @Before
    public void setUp() throws Exception {

        try
        {
            user = new Usuario();
            lista = new ArrayList<Usuario>();
            user.setId(1);
            user.setNombre("martin");
            user.setApellido("zasso");
            user.setDireccion("chile");
            user.setTelefono("474366");
            user.setCiudad("mdp");
            user.setPais("arg");
            user.setProvincia("bsas");
            user.setContrasenia("123456");
            user.setMail("m@m");
            user.setEliminado(false);
            lista.add(user);
            su = Mockito.mock(ServiceUsuario.class);
            when(su.getAll()).thenReturn(lista);
            when(su.getUsuario("martin")).thenReturn(lista);


            lu = new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
            reCreado = new ResponseEntity(HttpStatus.CREATED);
            reEliminado = new ResponseEntity(HttpStatus.OK);

            control = new controlaUsuarios();
            control.setServiceEmail(su);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    @Test
    public void getALL() throws Exception {
        ResponseEntity<List<Usuario>> re = null;
        try
        {
            re = control.getALL();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(lu.getBody().get(0).getId(),re.getBody().get(0).getId());

    }

    @Test
    public void getUsuario() throws Exception {
        ResponseEntity<List<Usuario>> re = null;
        try
        {
            re = control.getUsuario("martin");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(lu.getBody().get(0).getId(),re.getBody().get(0).getId());
    }

    @Test
    public void addUser() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.addUser(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),reCreado.getBody());
    }

    @Test
    public void delete() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.delete(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),reEliminado.getBody());
    }

}