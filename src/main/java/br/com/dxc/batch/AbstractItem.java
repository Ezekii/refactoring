package br.com.dxc.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.text.StrBuilder;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.dxc.exception.BusinessValidatorException;

public abstract class AbstractItem {

    @JsonIgnore
    protected String line;

    @JsonIgnore
    protected Integer lineNumber;

    @JsonIgnore
    protected List<FieldError> errors;

    public AbstractItem() {

        super();
        this.errors = new ArrayList<FieldError>();
    }

    public AbstractItem addError(final String fieldName, final String message) {
        this.errors.add(new FieldError("item", fieldName, message));
        return this;
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    public BusinessValidatorException exceptionError() {
        final StrBuilder builder = new StrBuilder();
        for (final ObjectError error : this.errors) {
            if (error instanceof FieldError) {
                builder.append(((FieldError) error).getField());
                builder.append(": [").append(error.getDefaultMessage()).append("] ");
            } else {
                builder.append(error.getObjectName());
                builder.append(": [").append(error.getDefaultMessage()).append("] ");
            }
            builder.appendNewLine();
        }
        throw new BusinessValidatorException(builder.toString());
    }

    public String getLine() {
        return this.line;
    }

    public Integer getLineNumber() {
        return this.lineNumber;
    }

    public List<FieldError> getErrors() {
        return this.errors;
    }

    public void setLine(final String line) {
        this.line = line;
    }

    public void setLineNumber(final Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setErrors(final List<FieldError> errors) {
        this.errors = errors;
    }
}
