package com.maven.tpEmailZasso.Servicio;

import com.maven.tpEmailZasso.Dao.DaoUsuarios;
import com.maven.tpEmailZasso.Login.UserSesion;
import com.maven.tpEmailZasso.Modelo.Usuario;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by martin on 21/06/17.
 */
@RunWith(PowerMockRunner.class)
public class ServiceUsuarioTest extends TestCase{

    ServiceUsuario su;
    UserSesion us;
    Usuario u;
    List lista;
    DaoUsuarios daoUsuariosError = Mockito.mock(DaoUsuarios.class);

    @Before
    public void setUp() throws Exception {
        try {
            us = new UserSesion();
            us.setId(1);
            us.setNombreUsuario("prueba");
            us.setPassword("123456");
            u = new Usuario();
            u.setId(1);
            u.setNombre("prueba");
            u.setContrasenia("123456");
            u.setNombre("martin");
            u.setApellido("zasso");
            u.setDireccion("chile3572");
            u.setTelefono("4742867");
            u.setCiudad("mdp");
            u.setProvincia("bsas");
            u.setPais("argentina");
            u.setMail("prueba@prueba.com");
            u.setEliminado(false);
            lista = new ArrayList<Usuario>();
            lista.add(u);
            DaoUsuarios du = Mockito.mock(DaoUsuarios.class);
            Mockito.when(du.get("prueba", "123456")).thenReturn(us);
            Mockito.when(du.get("prueba2","123456")).thenThrow(new Exception());
            Mockito.when(du.listarUsuarios()).thenReturn(lista);
            Mockito.when(daoUsuariosError.listarUsuarios()).thenThrow(new Exception());
            Mockito.when(du.usuarioXnombre("martin")).thenReturn(lista);
            Mockito.when(du.usuarioXnombre("martin2")).thenThrow(new Exception());
            Mockito.doThrow(new Exception()).when(du).eliminaUsuario(2);
            su = new ServiceUsuario();
            su.setDao(du);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    public void getAll() throws Exception {
        List<Usuario> l = null;
        try {
            l = su.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getAllError()
    {
        boolean error = false;
        try
        {
            su.setDao(daoUsuariosError);
            List<Usuario> l = su.getAll();
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }

    @Test
    public void getUsuario() throws Exception {
        List<Usuario> l = null;
        try
        {
            l = su.getUsuario("martin");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(lista,l);
    }

    @Test
    public void getUsuario_error()
    {
        boolean error = false;
        try
        {
            List<Usuario> l = su.getUsuario("martin2");
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }

    @Test
    public void newUser() throws Exception {
        boolean ok = false;
        try
        {
            su.newUser("nombre","apellido","direccion","telefono","ciudad","pais","provincia","contrasenia","email");
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);
    }



    @Test
    public void deleteUser() throws Exception {
        boolean ok = false;
        try
        {
            su.deleteUser(1);
            ok = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertTrue(ok);
    }

    @Test
    public void deleteUser_error()
    {
        boolean error = false;
        try
        {
            su.deleteUser(2);
        }
        catch (Exception e)
        {
            error = true;
        }
        assertTrue(error);
    }

    @Test
    public void login() throws Exception {
        UserSesion p = null;
        try {
            p = su.login("prueba", "123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(us, p);
    }

    @Test
    public void login_error() throws Exception {
        {
            boolean error = false;
            try {
                UserSesion p = su.login("prueba2", "123456");
            } catch (Exception e) {
                error = true;
            }
            assertTrue(error);

        }

    }
}