package com.maven.tpEmailZasso.Controladora;

import com.maven.tpEmailZasso.Modelo.Mensaje;
import com.maven.tpEmailZasso.Request.MensajeRequest;
import com.maven.tpEmailZasso.Servicio.ServiceMensaje;
import com.maven.tpEmailZasso.Wrappers.MensajeWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by martin on 21/06/17.
 */
@RunWith(PowerMockRunner.class)
public class controlaMensajesTest {

    Mensaje msj;
    Mensaje msjE;
    ServiceMensaje sm;
    controlaMensajes control;
    Date fecha;
    List list;
    ResponseEntity reNuevomsj;
    ResponseEntity reMensajeR;
    ResponseEntity reMensajeEnviadoPor;
    ResponseEntity recibidosEliminadosUsr;
    ResponseEntity renviadosEliminados;
    ResponseEntity reliminarMensajeRecibido;
    ResponseEntity reliminarMensajeEnviado;
    MensajeRequest msjR;
    ResponseEntity renviomail;

    ResponseEntity<List<Mensaje>> lm;


    @Before
    public void setUp() throws Exception {
        try
        {
            msjR = new MensajeRequest();
            msj = new Mensaje();
            list = new ArrayList<Mensaje>();

            msj.setId(1);
            msj.setUserIdFrom(1);
            msj.setUserIdTo(2);
            msj.setRemitente("martin");
            msj.setRecipiente("sergio");
            fecha = new Date();
            msj.setFecha(fecha);
            msj.setAsunto("hola");
            msj.setCuerpo("chau");
            msj.setRecibidoBborrado(false);
            msj.setEnviadoBorrado(false);
            list.add(msj);

            msjR.setUserIdFrom(1);
            msjR.setUserIdTo(2);
            msjR.setRemitente("martin");
            msjR.setRecipiente("sergio");
            msjR.setAsunto("hola");
            msjR.setCuerpo("chau");



            sm = Mockito.mock(ServiceMensaje.class);
            when(sm.allMessagesService()).thenReturn(list);
            when(sm.msjRecibidosXusuarioService(1)).thenReturn(list);
            when(sm.msjeEnviadosXusuarioService(1)).thenReturn(list);
            when(sm.msjRecibidosBorradosService(1)).thenReturn(list);
            when(sm.msjEnviadosBorradosService(1)).thenReturn(list);

            lm = new ResponseEntity<List<Mensaje>>(list, HttpStatus.OK);
            reNuevomsj = new ResponseEntity(HttpStatus.CREATED);
            reMensajeR = new ResponseEntity<List<Mensaje>>(list, HttpStatus.OK);
            reMensajeEnviadoPor = new ResponseEntity<List<Mensaje>>(list, HttpStatus.OK);
            recibidosEliminadosUsr = new ResponseEntity<List<Mensaje>>(list, HttpStatus.OK);
            renviadosEliminados = new ResponseEntity<List<Mensaje>>(list, HttpStatus.OK);
            reliminarMensajeRecibido = new ResponseEntity(HttpStatus.OK);
            reliminarMensajeEnviado = new ResponseEntity(HttpStatus.OK);
            renviomail = new ResponseEntity(HttpStatus.CREATED);


            control = new controlaMensajes();
            control.setServiceMensaje(sm);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Test
    public void getALLMessages() throws Exception {
        ResponseEntity<List<Mensaje>> re = null;
        try
        {
            re = control.getALLMessages();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(lm.getBody().get(0).getAsunto(),re.getBody().get(0).getAsunto());
    }

    @Test
    public void nuevoMensaje() throws Exception {
        ResponseEntity re = null;
        try {
            re = control.nuevoMensaje(msjR);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),renviomail.getBody());
    }

    @Test
    public void mensajesRecibidosPor() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.mensajesRecibidosPor(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),reMensajeR.getBody());
    }

    @Test
    public void mensajesEnviadosPor() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.mensajesRecibidosPor(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),reMensajeEnviadoPor.getBody());
    }

    @Test
    public void recibidos_eliminados_user() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.recibidos_eliminados_user(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void enviados_eliminados_user() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.enviados_eliminados_user(1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),renviadosEliminados.getBody());
    }

    @Test
    public void eliminarMensajeRecibido() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.eliminarMensajeRecibido(1,1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),reliminarMensajeRecibido.getBody());
    }

    @Test
    public void eliminarMensajeEnviado() throws Exception {
        ResponseEntity re = null;
        try
        {
            re = control.eliminarMensajeEnviado(1,1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals(re.getBody(),reliminarMensajeEnviado.getBody());
    }

}