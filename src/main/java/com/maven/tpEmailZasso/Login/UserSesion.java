package com.maven.tpEmailZasso.Login;

/**
 * Created by martin on 17/06/17.
 */
public class UserSesion {
    private int id;
    private String nombreUsuario;
    private String password;

    public UserSesion(int id, String nombreUsuario, String password) {
        this.setId(id);
        this.setNombreUsuario(nombreUsuario);
        this.setPassword(password);
    }

    public UserSesion(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
