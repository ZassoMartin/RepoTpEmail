package com.maven.tpEmailZasso.Login;

import org.joda.time.DateTime;

/**
 * Created by martin on 17/06/17.
 */

public class AuthenticationData {

    private UserSesion usuario;
    private DateTime lastAction;

    public DateTime getLastAction() {
        return lastAction;
    }

    public void setLastAction(DateTime lastAction) {
        this.lastAction = lastAction;
    }

    public UserSesion getUsuario() {
        return usuario;
    }

    public void setUsuario(UserSesion usuario) {
        this.usuario = usuario;
    }
}
