package com.maven.tpEmailZasso.Servicio;

import com.maven.tpEmailZasso.Dao.DaoMensajes;
import com.maven.tpEmailZasso.Modelo.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 20/06/17.
 */
@Service
public class ServiceMensaje {

    @Autowired
    private
    DaoMensajes dao;

    ServiceMensaje(DaoMensajes dao) {
        this.setDao(dao);
    }

    ServiceMensaje(){}

    public List allMessagesService()
    {
        List<Mensaje> lista = new ArrayList<Mensaje>();
        try
        {
            lista =  getDao().allMessagesDao();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }


    public List msjRecibidosXusuarioService (int id)
    {
        List<Mensaje> lista = new ArrayList<Mensaje>();
        try
        {
            lista = getDao().msjRecibidosXusuarioDao(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    public List msjeEnviadosXusuarioService (int id)
    {
        List<Mensaje> lista = new ArrayList<Mensaje>();
        try
        {
            lista = getDao().msjeEnviadosXusuarioDao(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    public List msjRecibidosBorradosService (int id)
    {
        List<Mensaje> lista = new ArrayList<Mensaje>();
        try
        {
            lista = getDao().msjRecibidosBorradosDao(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    public List msjEnviadosBorradosService(int id)
    {
        List<Mensaje> lista = new ArrayList<Mensaje>();
        try
        {
            lista = getDao().msjEnviadosBorradosDao(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    public void mandarMailService(int userIdFrom, int userIdTo, String remitente, String recipiente, String asunto, String cuerpo)
    {
        try
        {
            getDao().mandarMailDao(userIdFrom,userIdTo,remitente,recipiente,asunto,cuerpo);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



    public void borrarMensajeRecibidoService(int iduser,int idmsj)
    {
        try
        {
            getDao().borrarMensajeRecibidoDao(iduser,idmsj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void borrarMensajeEnviadoService(int iduser,int idmsj)
    {
        try
        {
            getDao().borrarMensajeEnviadoDao(iduser,idmsj);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public DaoMensajes getDao() {
        return dao;
    }

    public void setDao(DaoMensajes dao) {
        this.dao = dao;
    }
}
