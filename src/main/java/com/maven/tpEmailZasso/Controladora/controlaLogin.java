package com.maven.tpEmailZasso.Controladora;

import com.maven.tpEmailZasso.Login.SessionData;
import com.maven.tpEmailZasso.Login.UserSesion;
import com.maven.tpEmailZasso.Response.LoginResponseWrapper;
import com.maven.tpEmailZasso.Servicio.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by martin on 20/06/17.
 */
@RestController
@RequestMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
public class controlaLogin {
    @Autowired
    ServiceUsuario serviceUser;

    @Autowired
    SessionData sessionData;

    @RequestMapping(value = "/login", method = RequestMethod.GET) //LOGIN DE USUARIO
    public @ResponseBody
    ResponseEntity<LoginResponseWrapper> getById(@RequestParam("user") String nombreUsuario, @RequestParam("pwd") String pwd){
        try {
            UserSesion u = serviceUser.login(nombreUsuario, pwd);
            if (null != u) {
                String sessionId = sessionData.addSession(u);
                return new ResponseEntity<LoginResponseWrapper>(new LoginResponseWrapper(sessionId), HttpStatus.OK);
            }

            //BROWSER http://localhost:8080/login?user=martin&pwd=abc
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);

    }

    @RequestMapping("/logout")
    public @ResponseBody ResponseEntity getById(@RequestHeader("sessionid") String sessionId) {
        sessionData.removeSession(sessionId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
        //BROWSER http://localhost:8080/logout
    }
}
