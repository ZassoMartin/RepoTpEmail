package com.maven.tpEmailZasso.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by martin on 17/06/17.
 */
public class MensajeRequest {


    @JsonProperty("userIdFrom")
    private
    int userIdFrom;
    @JsonProperty("userIdTo")
    private
    int userIdTo;
    @JsonProperty("remitente")
    private
    String remitente;
    @JsonProperty("recipiente")
    private
    String recipiente;
    @JsonProperty("asunto")
    private
    String asunto;
    @JsonProperty("cuerpo")
    private
    String cuerpo;


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
}
