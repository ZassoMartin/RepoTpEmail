package com.maven.tpEmailZasso.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by martin on 17/06/17.
 */
public class LoginResponseWrapper {
    @JsonProperty
    String sessionId ;

    public LoginResponseWrapper() {

    }

    public LoginResponseWrapper(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
