package br.com.dxc.exception;

import br.com.dxc.util.MessagesUtils;

public enum ApplicationBusinessExceptionCode implements ExceptionCode {

    CRESOL_ERROR_MENSAGEM_DEFAULT("1000", Severity.ERROR),
    CRESOL_ERROR_SEND_MESSAGE("1001", Severity.ERROR),
    CRESOL_ERROR_SEND_MESSAGE_PARAMETER("1002", Severity.ERROR),
    CRESOL_ERROR_SEND_MESSAGE_PATH_TO_ATTACHMENT("1003", Severity.ERROR),
    CRESOL_LOG_SEND_MESSAGE("1004", Severity.INFO),
    CRESOL_ERROR_CERTIFICADO_DIGITAL("1005", Severity.ERROR),
    CRESOL_ERROR_SERVIDOR_FTP("1006", Severity.ERROR),
    CRESOL_ERROR_CONEXAO_FTP("1007", Severity.ERROR),
    CRESOL_LOG_FTP_CONNECTION("1008", Severity.INFO),
    CRESOL_ERROR_RESPOSTA_FTP("1009", Severity.ERROR),
    CRESOL_ERROR_JOB_ESTA_EXECUTANDO("1010", Severity.WARNING),
    CRESOL_ERROR_JOB_JA_EXISTE_NAO_RESTARAVEL("1011", Severity.WARNING),
	CRESOL_COB_ERROR_JOB_CONCLUIDO("1012", Severity.WARNING),
	CRESOL_ERROR_JOB_PARAMETRO_INVALIDO("1013", Severity.WARNING),
	CRESOL_ERROR_JOB_RUN("1014", Severity.WARNING),
	CRESOL_ERROR_JOB_NAO_ENCONTRADO("1015", Severity.WARNING),
	CRESOL_ERROR_JOB_NAO_RESTARTAVEL("1016", Severity.WARNING),
	CRESOL_ERROR_JOB_RESTART("1017", Severity.WARNING),
	CRESOL_ERROR_JOB_NAO_INTERROMPIDO("1018", Severity.WARNING),
	CRESOL_ERROR_JOB_STOP("1019", Severity.WARNING),
	CRESOL_ERROR_JOB_NAO_ABORTADO("1020", Severity.WARNING),
	CRESOL_ERROR_JOB_ABANDON("1021", Severity.WARNING)
    ;


    private String errorCode;
    private Severity severity;

    ApplicationBusinessExceptionCode(String codeError, Severity severity){
        this.errorCode = codeError;
        this.severity = severity;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public Severity getSeverity() {
        return this.severity;
    }

    public String getDescricao(){
        return MessagesUtils.getMessage(this.name());
    }

    public void throwException(Object... params) throws BusinessValidatorException {
        throw new BusinessValidatorException(this, params);
    }

    public void throwException(Throwable cause, Object... params) throws BusinessValidatorException {
        // Tratamento adicional para não esconder a excecao de negocio original
        if (cause instanceof BusinessValidatorException) {
            throw (BusinessValidatorException) cause;
        }
        throw new BusinessValidatorException(this, cause, params);
    }

}
