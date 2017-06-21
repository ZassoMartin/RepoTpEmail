package com.maven.tpEmailZasso.Modelo;

import java.util.Date;

/**
 * Created by martin on 07/06/17.
 */
public class Mensaje {

    private int id;
    private int userIdFrom;
    private int userIdTo;
    private String remitente;
    private String recipiente;
    private Date fecha;
    private String asunto;
    private String cuerpo;// adentro puedo poner html
    private boolean recibidoBborrado;
    private boolean enviadoBorrado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public boolean isRecibidoBborrado() {
        return recibidoBborrado;
    }

    public void setRecibidoBborrado(boolean recibidoBborrado) {
        this.recibidoBborrado = recibidoBborrado;
    }

    public boolean isEnviadoBorrado() {
        return enviadoBorrado;
    }

    public void setEnviadoBorrado(boolean enviadoBorrado) {
        this.enviadoBorrado = enviadoBorrado;
    }

    public Mensaje(int id, int userIdFrom, int userIdTo, String remitente, String recipiente, Date fecha, String asunto, String cuerpo, boolean recibidoBborrado, boolean enviadoBorrado) {
        this.setId(id);
        this.setUserIdFrom(userIdFrom);
        this.setUserIdTo(userIdTo);
        this.setRemitente(remitente);
        this.setRecipiente(recipiente);
        this.setFecha(fecha);
        this.setAsunto(asunto);
        this.setCuerpo(cuerpo);
        this.setRecibidoBborrado(recibidoBborrado);
        this.setEnviadoBorrado(enviadoBorrado);
    }

    public Mensaje(int userIdFrom, int userIdTo, String remitente, String recipiente, String asunto, String cuerpo) {
        this.setUserIdFrom(userIdFrom);
        this.setUserIdTo(userIdTo);
        this.setRemitente(remitente);
        this.setRecipiente(recipiente);
        this.setAsunto(asunto);
        this.setCuerpo(cuerpo);
    }

    public Mensaje(){}

    @Override
    public String toString() {
        return "Mensaje{" +
                "id=" + id +
                ", userIdFrom=" + userIdFrom +
                ", userIdTo=" + userIdTo +
                ", remitente='" + remitente + '\'' +
                ", recipiente='" + recipiente + '\'' +
                ", fecha=" + fecha +
                ", asunto='" + asunto + '\'' +
                ", cuerpo='" + cuerpo + '\'' +
                ", recibidoBborrado=" + recibidoBborrado +
                ", enviadoBorrado=" + enviadoBorrado +
                '}';
    }
}
