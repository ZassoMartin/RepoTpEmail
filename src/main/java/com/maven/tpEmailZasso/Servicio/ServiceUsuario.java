package com.maven.tpEmailZasso.Servicio;

import com.maven.tpEmailZasso.Dao.DaoUsuarios;
import com.maven.tpEmailZasso.Login.UserSesion;
import com.maven.tpEmailZasso.Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by martin on 08/06/17.
 */
@Service("service")
public class ServiceUsuario {

    @Autowired
    private
    DaoUsuarios dao;

    @Autowired
    ServiceUsuario(DaoUsuarios dao) {
        this.setDao(dao);
    }

    ServiceUsuario(){}

    public List<Usuario> getAll() throws Exception{
        List<Usuario> l= null;
        try {
            l= getDao().listarUsuarios();
        }
        catch (Exception e)
        {
            throw e;
        }
        return l;
    } //RETORNA TODOS LOS USUARIOS

    public List<Usuario> getUsuario(String nombre)throws Exception {
        try
        {
            return getDao().usuarioXnombre(nombre);
        }
        catch (Exception e)
        {
            throw e;
        }

    } //RETORNA UN USUARIO POR NOMBRE

    public void newUser(String nombre,String apellido,String direccion,String telefono,String ciudad,String pais,String provincia,String contrasenia,String mail) throws Exception //AGREGO UN USUARIO POR NOMBRE
    {
        try
        {
            this.getDao().agregaUser(nombre,apellido,direccion,telefono,ciudad,pais,contrasenia,provincia,mail);}
        catch (Exception e)
        {
            throw e;
        }

    }

    public void deleteUser(int id)throws Exception //ELIMINA UN USUARIO POR ID
    {
        try
        {
            this.getDao().eliminaUsuario(id);}
        catch (Exception e)
        {
            throw e;
        }

    }

    public UserSesion login(String nombreUsuario, String password) throws Exception
    {
        UserSesion us = new UserSesion();
        try
        {
            us = getDao().get(nombreUsuario,password);
        }
        catch (Exception e)
        {
            throw e;
        }
        return us;
    }

    public DaoUsuarios getDao() {
        return dao;
    }

    public void setDao(DaoUsuarios dao) {
        this.dao = dao;
    }
}
