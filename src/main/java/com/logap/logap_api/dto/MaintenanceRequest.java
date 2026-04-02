package com.logap.logap_api.dto;

import java.time.LocalDate;
import java.math.BigDecimal;

public class MaintenanceRequest {
    private Long veiculoId;
    private LocalDate dataInicio;
    private LocalDate dataFinalizacao;
    private String tipoServico;
    private BigDecimal custoEstimado;
    private String status;

    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public LocalDate getDataFinalizacao() { return dataFinalizacao; }
    public void setDataFinalizacao(LocalDate dataFinalizacao) { this.dataFinalizacao = dataFinalizacao; }
    public String getTipoServico() { return tipoServico; }
    public void setTipoServico(String tipoServico) { this.tipoServico = tipoServico; }
    public BigDecimal getCustoEstimado() { return custoEstimado; }
    public void setCustoEstimado(BigDecimal custoEstimado) { this.custoEstimado = custoEstimado; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}