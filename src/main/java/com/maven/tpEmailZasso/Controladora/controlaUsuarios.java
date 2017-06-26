package com.maven.tpEmailZasso.Controladora;

import com.maven.tpEmailZasso.Servicio.ServiceUsuario;
import com.maven.tpEmailZasso.Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martin on 08/06/17.
 */
@RestController
@RequestMapping("/api")
//@RequestMapping("/")
public class controlaUsuarios {

    @Autowired
    private
    ServiceUsuario serviceEmail;

    //TRAIGO TODOS LOS USUARIOS Y LOS MUESTRO
    @RequestMapping(value = "/Usuario/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Usuario>> getALL() {

        try {
            List<Usuario> list = getServiceEmail().getAll();
            if (list.size() > 0) {
                return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER http://localhost:8080/api/Usuario/
    }

    //TRAIGO USUARIOS POR NOMBRE
    @RequestMapping(value = "/Usuario/{nombre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Usuario>> getUsuario(@PathVariable("nombre") String nombre) {

        try {
            List<Usuario> list = getServiceEmail().getUsuario(nombre);
            if (list.size() > 0) {
                return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
            } else {
                return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER localhost:8080/api/Usuario/martin
    }

    //AGREGA UN USUARIO NUEVO A BASE
    @RequestMapping(value = "/Usuario/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody Usuario request) {
        try {
            getServiceEmail().newUser(request.getNombre(), request.getApellido(), request.getDireccion(), request.getTelefono(), request.getCiudad(), request.getPais(), request.getProvincia(), request.getContrasenia(), request.getMail());
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        /*
            BROWSER localhost:8080/api/Usuario/

            {
        "nombre": "martin",
        "apellido": "zasso",
        "direccion": "chile3572",
        "telefono": "4788432",
        "ciudad": "mdq",
        "pais": "argentina",
        "provincia": "bsas",
        "contrasenia": "abc",
        "mail": "m@m"
            }

         */
    }

    //BORRO DE MANERA LOGICA UN USUARIO
    @RequestMapping(value = "/Usuario/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE) //ELIMINA USUARIO (de manera logica) X ID
    public ResponseEntity delete(@PathVariable("id") int id) {
        try {
            getServiceEmail().deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //BROWSER localhost:8080/api/Usuario/1
    }


    public ServiceUsuario getServiceEmail() {
        return serviceEmail;
    }

    public void setServiceEmail(ServiceUsuario serviceEmail) {
        this.serviceEmail = serviceEmail;
    }
}
