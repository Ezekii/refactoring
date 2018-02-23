package br.com.dxc.exception;

public enum Severity {

    WARNING, INFO, ERROR, DANGER, SUCCESS;

    public String getType(){
        return this.name().toLowerCase();
    }
}
