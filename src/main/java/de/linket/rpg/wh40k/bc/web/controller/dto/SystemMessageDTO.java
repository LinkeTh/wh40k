package de.linket.rpg.wh40k.bc.web.controller.dto;

import java.io.IOException;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public class SystemMessageDTO implements JsonSerializable
{

    private HttpStatus status;

    private String error;

    private String message;

    public SystemMessageDTO(HttpStatus status, String error, String message)
    {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public HttpStatus getStatus()
    {
        return this.status;
    }

    public String getError()
    {
        return this.error;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setStatus(HttpStatus status)
    {
        this.status = status;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException
    {
        jgen.writeStartObject();
        jgen.writeNumberField("status", this.status.value());
        jgen.writeStringField("error", this.error);
        jgen.writeStringField("message", this.message);
        jgen.writeEndObject();
        jgen.close();
    }

    @Override
    public void serializeWithType(JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException
    {
        this.serialize(jgen, provider);
    }
}
