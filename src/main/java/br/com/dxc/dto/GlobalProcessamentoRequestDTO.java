package br.com.dxc.dto;

import org.joda.time.LocalDate;

import javax.validation.constraints.NotNull;

public class GlobalProcessamentoRequestDTO {

    @NotNull
    private LocalDate dataProcessamento;

    public LocalDate getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(LocalDate dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }
}
