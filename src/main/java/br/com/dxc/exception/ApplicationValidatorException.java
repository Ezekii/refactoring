package br.com.dxc.exception;

import org.json.JSONException;

import br.com.dxc.util.MessagesUtils;

public class ApplicationValidatorException extends RuntimeException {

    private static final long serialVersionUID = -1797415238995087L;

    private static final String CRESOL_ERROR_MENSAGEM_DEFAULT = MessagesUtils.getMessage("CRESOL_ERROR_MENSAGEM_DEFAULT");
    private static final String QUEBRA_LINHA_WEB = " <br /> ";
    private static final String CODIGO = "CÓDIGO ";

    private String type;

    public ApplicationValidatorException(final JSONException e) {
        super(e);
    }

    public ApplicationValidatorException(ExceptionCode code, Object... params) {
        super(Severity.ERROR.name() + ":" + MessagesUtils.getMessage(code.toString(), params));
        this.type = Severity.ERROR.getType();
    }

    public ApplicationValidatorException(ExceptionCode code, Severity s, Object... params) {
        super(s.name() + ":" + MessagesUtils.getMessage(code.toString(), params));
        this.type = Severity.ERROR.getType();
    }

    public ApplicationValidatorException(ApplicationBusinessExceptionCode code, Object... params) {
            super( (Severity.ERROR.equals(code.getSeverity()) ? CODIGO + code.getErrorCode() + " - " + code.getSeverity().name() + " : " : "") + MessagesUtils.getMessage(code.toString(), params));
            this.type = code.getSeverity().getType();
    }

    // preservar o seu StackTrace original
    public ApplicationValidatorException(ApplicationBusinessExceptionCode code, Throwable cause, Object... params) {
        super(getMessagem(code.getSeverity()) + code.getErrorCode() + " - " + code.getSeverity().name() + " : " + MessagesUtils.getMessage(code.toString(), params)
                + QUEBRA_LINHA_WEB + cause.getMessage(), cause);

        this.type = code.getSeverity().getType();
    }

    private static String getMessagem(Severity severity) {
        switch (severity) {
            case WARNING:
                return "";
            case INFO:
                return "";
            case ERROR:
                return CRESOL_ERROR_MENSAGEM_DEFAULT + QUEBRA_LINHA_WEB + QUEBRA_LINHA_WEB + CODIGO;
            case DANGER:
                return "";
            case SUCCESS:
                return "";
            default: return "";
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
