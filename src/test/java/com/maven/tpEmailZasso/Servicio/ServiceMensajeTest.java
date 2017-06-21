package com.maven.tpEmailZasso.Servicio;

import com.maven.tpEmailZasso.Dao.DaoMensajes;
import com.maven.tpEmailZasso.Modelo.Mensaje;
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
public class ServiceMensajeTest extends TestCase{

    ServiceMensaje sm;
    Mensaje m;
    List lista;
    DaoMensajes dmerror = Mockito.mock(DaoMensajes.class);

    @Before
    public void setUp() throws Exception {
        try{
            m = new Mensaje(1, 2, "rteprueba", "rpteprueba","asuntoprueba", "cuerpo_prueba");
            lista = new ArrayList<Mensaje>();
            lista.add(m);
            DaoMensajes dm = Mockito.mock(DaoMensajes.class);
            Mockito.when(dm.allMessagesDao()).thenReturn(lista);
            Mockito.when(dmerror.allMessagesDao()).thenThrow(new Exception());
            Mockito.when(dm.msjRecibidosXusuarioDao(1)).thenReturn(lista);
            Mockito.when(dm.msjRecibidosXusuarioDao(2)).thenThrow(new Exception());
            Mockito.when(dm.msjeEnviadosXusuarioDao(1)).thenReturn(lista);
            Mockito.when(dm.msjeEnviadosXusuarioDao(2)).thenThrow(new Exception());
            Mockito.when(dm.msjRecibidosBorradosDao(1)).thenReturn(lista);
            Mockito.when(dm.msjRecibidosBorradosDao(2)).thenThrow(new Exception());
            Mockito.when(dm.msjRecibidosBorradosDao(1)).thenReturn(lista);
            Mockito.when(dm.msjRecibidosBorradosDao(2)).thenThrow(new Exception());
            Mockito.doThrow(new Exception()).when(dm).mandarMailDao(1, 2, "rteprueba_error", "rpteprueba", "asuntoprueba", "cuerpo_prueba");
            sm = new ServiceMensaje();
            sm.setDao(dm);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Test
    public void allMessagesService() throws Exception {
//        List<Mensaje> l = null;
//        try
//        {
//            l = sm.allMessagesService();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        assertEquals(lista,l);
    }

    @Test
    public void msjRecibidosXusuarioService() throws Exception {
    }

    @Test
    public void msjeEnviadosXusuarioService() throws Exception {
    }

    @Test
    public void msjRecibidosBorradosService() throws Exception {
    }

    @Test
    public void msjEnviadosBorradosService() throws Exception {
    }

    @Test
    public void mandarMailService() throws Exception {
    }

    @Test
    public void borrarMensajeRecibidoService() throws Exception {
    }

    @Test
    public void borrarMensajeEnviadoService() throws Exception {
    }

}