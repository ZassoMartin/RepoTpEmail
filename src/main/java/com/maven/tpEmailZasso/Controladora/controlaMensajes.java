package com.maven.tpEmailZasso.Controladora;

import com.maven.tpEmailZasso.Modelo.Mensaje;
import com.maven.tpEmailZasso.Request.MensajeRequest;
import com.maven.tpEmailZasso.Servicio.ServiceMensaje;
import com.maven.tpEmailZasso.Wrappers.MensajeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 20/06/17.
 */
@RestController
@RequestMapping("/api")
//@RequestMapping("/")
public class controlaMensajes {

    @Autowired
    private
    ServiceMensaje serviceMensaje;


    //TRAIGO TODOS LOS MENSAJES Y LOS MUESTRO
    @RequestMapping(value = "/mensajes/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Mensaje>> getALLMessages() {

        List<Mensaje> list = getServiceMensaje().allMessagesService();
        try {
            if (list.size() > 0) {
                return new ResponseEntity<List<Mensaje>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Mensaje>>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER http://localhost:8080/api/mensajes/
    }

    //ENVIO DE MAILS
    @RequestMapping(value = "/mensajes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity nuevoMensaje(@RequestBody MensajeRequest request) {
        try {
            getServiceMensaje().mandarMailService(request.getUserIdFrom(),request.getUserIdTo(),request.getRemitente(),request.getRecipiente(),request.getAsunto(),request.getCuerpo());
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        /*
            BROWSER localhost:8080/api/mensajes
           {
                "userIdFrom": 1,
                "userIdTo": 2,
                "remitente": "carlos",
                "recipiente": "martin",
                "asunto": "chau",
                "cuerpo": "hasta pronto"
            }
         */
    }

    //MENSAJES RECIBIDOS DE X USUARIO
    @RequestMapping(value = "/recibidos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Mensaje>> mensajesRecibidosPor(@PathVariable("id") int id) {
        List<Mensaje> listamails = getServiceMensaje().msjRecibidosXusuarioService(id);
        if (listamails.size() > 0) {
            List<Mensaje> lista = new ArrayList<Mensaje>();
            for (Mensaje m : listamails)
            {

                lista.add(m);
            }
            return new ResponseEntity<List<Mensaje>>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Mensaje>>(HttpStatus.NO_CONTENT);
        }
        //BROWSER localhost:8080/api/recibidos/2
    }

    //MENSAJES ENVIADOS POR X USUARIO
    @RequestMapping(value = "/enviados/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Mensaje>> mensajesEnviadosPor(@PathVariable("id") int idUsuario) {
        List<Mensaje> listamails = getServiceMensaje().msjeEnviadosXusuarioService(idUsuario);
        if (listamails.size() > 0) {
            List<Mensaje> lista = new ArrayList<Mensaje>();
            for (Mensaje m : listamails)
            {

                lista.add(m);
            }
            return new ResponseEntity<List<Mensaje>>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Mensaje>>(HttpStatus.NO_CONTENT);
        }
        //BROWSER localhost:8080/api/enviados/2
    }

    //MENSAJES RECIBIDOS ELIMINADOS POR USUARIO X
    @RequestMapping(value = "/recibidos_eliminados/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Mensaje>> recibidos_eliminados_user(@PathVariable("id") int idUsuario) {
        List<Mensaje> listamails = getServiceMensaje().msjRecibidosBorradosService(idUsuario);
        if (listamails.size() > 0) {
            List<Mensaje> lista = new ArrayList<Mensaje>();
            for (Mensaje m : listamails)
            {

                lista.add(m);
            }
            return new ResponseEntity<List<Mensaje>>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Mensaje>>(HttpStatus.NO_CONTENT);
        }
        //BROWSER http://localhost:8080/api/recibidos_eliminados/3
    }

    //MENSAJES ENVIADOS ELIMINADOS POR USUARIO X
    @RequestMapping(value = "/enviados_eliminados/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Mensaje>> enviados_eliminados_user(@PathVariable("id") int idUsuario) {
        List<Mensaje> listamails = getServiceMensaje().msjEnviadosBorradosService(idUsuario);
        try {
            if (listamails.size() > 0) {
                List<Mensaje> lista = new ArrayList<Mensaje>();
                for (Mensaje m : listamails)
                {

                    lista.add(m);
                }
                return new ResponseEntity<List<Mensaje>>(lista, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Mensaje>>(HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER http://localhost:8080/api/enviados_eliminados/3
    }



    //ELIMINO DE MANERA LOGICA UN MENSAJE RECIBIDO POR USER X
        @RequestMapping(value = "/eliminar_mensaje_recibido", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity eliminarMensajeRecibido(@RequestParam("id_usuario") int idu, @RequestParam ("id_mensaje") int idm) {
        try {
            getServiceMensaje().borrarMensajeRecibidoService(idu,idm);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER localhost:8080/api/eliminar_mensaje_recibido?id_usuario=3&id_mensaje=3
    }

    //ELIMINO DE MANERA LOGICA UN MENSAJE ENVIADO POR USER X
    @RequestMapping(value = "/eliminar_mensaje_enviado", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity eliminarMensajeEnviado(@RequestParam("id_usuario") int idu, @RequestParam ("id_mensaje") int idm) {
        try {
            getServiceMensaje().borrarMensajeEnviadoService(idu,idm);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER localhost:8080/api/eliminar_mensaje_enviado?id_usuario=3&id_mensaje=4
    }

    public ServiceMensaje getServiceMensaje() {
        return serviceMensaje;
    }

    public void setServiceMensaje(ServiceMensaje serviceMensaje) {
        this.serviceMensaje = serviceMensaje;
    }
}
