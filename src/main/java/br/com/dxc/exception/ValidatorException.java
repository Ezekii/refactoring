package br.com.dxc.exception;

import com.fasterxml.jackson.databind.JsonNode;

public class ValidatorException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private JsonNode json;

    public ValidatorException(final JsonNode json) {
        super(json.toString());
        this.json = json;
    }

    public JsonNode getJson() {
        return this.json;
    }
}
