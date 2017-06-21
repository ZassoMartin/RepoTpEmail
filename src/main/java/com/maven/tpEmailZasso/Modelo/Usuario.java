package com.maven.tpEmailZasso.Modelo;

/**
 * Created by martin on 07/06/17.
 */
public class Usuario {


    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String pais;
    private String provincia;
    private String contrasenia;
    private String mail;
    private boolean eliminado;

    public Usuario(String nombre, String apellido, String direccion, String telefono, String ciudad, String pais, String provincia, String contrasenia, String mail) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setCiudad(ciudad);
        this.setPais(pais);
        this.setProvincia(provincia);
        this.setContrasenia(contrasenia);
        this.setMail(mail);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Usuario(int id, String nombre, String apellido, String direccion, String telefono, String ciudad, String pais, String provincia, String contrasenia, String mail, boolean eliminado) {
        this.setId(id);

        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setCiudad(ciudad);
        this.setPais(pais);
        this.setProvincia(provincia);
        this.setContrasenia(contrasenia);
        this.setMail(mail);
        this.setEliminado(eliminado);
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", provincia='" + provincia + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", mail='" + mail + '\'' +
                ", eliminado=" + eliminado +
                '}';
    }
}
