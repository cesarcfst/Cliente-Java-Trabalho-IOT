/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.iot.app;

/**
 *
 * @author Cesar Augusto
 */
public class Mensagem {
    private String horarioServidor;
    private String horarioLocal;
    private String texto;

    public String getHorarioServidor() {
        return horarioServidor;
    }

    public void setHorarioServidor(String horarioServidor) {
        this.horarioServidor = horarioServidor;
    }

    public String getHorarioLocal() {
        return horarioLocal;
    }

    public void setHorarioLocal(String horarioLocal) {
        this.horarioLocal = horarioLocal;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
