package br.com.dxc.exception;

import org.springframework.validation.BindingResult;

public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private BindingResult bindingResult;

    public InvalidRequestException(final String message, final BindingResult bindingResult) {
        super(message);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return this.bindingResult;
    }
}
