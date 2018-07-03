/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cesar
 */
public class DadosCalendar implements Serializable{
    private int id;
    private Calendar dataHorario;
    private String ventilador;
    private String luzDaSala;
    private String tv;
    private String luzDoQuarto;
    private String situacao;
    private List<DadosCalendar> agendamento;
    private String horarioServidor;
    private String horario;
    private String data;
    private String operacao;
    private String solicitacao;

    public String getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(String solicitacao) {
        this.solicitacao = solicitacao;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    

    public String getHorarioServidor() {
        return horarioServidor;
    }

    public void setHorarioServidor(String horarioServidor) {
        this.horarioServidor = horarioServidor;
    }

    public List<DadosCalendar> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<DadosCalendar> agendamento) {
        this.agendamento = agendamento;
    }

    public Calendar getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Calendar dataHorario) {
        this.dataHorario = dataHorario;
    }

    public String getVentilador() {
        return ventilador;
    }

    public void setVentilador(String ventilador) {
        this.ventilador = ventilador;
    }

    public String getLuzDaSala() {
        return luzDaSala;
    }

    public void setLuzDaSala(String luzDaSala) {
        this.luzDaSala = luzDaSala;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getLuzDoQuarto() {
        return luzDoQuarto;
    }

    public void setLuzDoQuarto(String luzDoQuarto) {
        this.luzDoQuarto = luzDoQuarto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
