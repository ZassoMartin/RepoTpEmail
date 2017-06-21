package com.maven.tpEmailZasso.Wrappers;

import com.maven.tpEmailZasso.Modelo.Mensaje;

import java.util.Date;

/**
 * Created by martin on 20/06/17.
 */
public class MensajeWrapper {

    private String remitente;
    private String recipiente;
    private Date fecha;
    private String asunto;
    private String cuerpo;

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

    public MensajeWrapper(Mensaje msje) {
        this.setRemitente(msje.getRemitente());
        this.setRecipiente(msje.getRecipiente());
        this.setFecha(msje.getFecha());
        this.setAsunto(msje.getAsunto());
        this.setCuerpo(msje.getCuerpo());
    }
}
