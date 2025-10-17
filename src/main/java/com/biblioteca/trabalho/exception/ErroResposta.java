package com.biblioteca.trabalho.exception;

import java.util.Date;
import java.util.List;

public class ErroResposta {

    private Date timestamp;
    private Integer status;
    private String erro;
    private String mensagem;
    private List<String> detalhes;

    public ErroResposta(Date timestamp, Integer status, String erro, String mensagem, List<String> detalhes) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getErro() {
        return erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<String> getDetalhes() {
        return detalhes;
    }
}