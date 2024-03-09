package com.rum.ksc_back.Config;

import java.util.Objects;

public class Request {
    private String messageCode;
    private Object body;

    public Request(String messageCode, Object body) {
        this.messageCode = messageCode;
        this.body = body;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(messageCode, request.messageCode) && Objects.equals(body, request.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, body);
    }
}
