/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author cesar
 */
public class Cerebro {
    static List<DadosCalendar> listaLocal;
    GerenciadorCalendar gerenciadorCalendar;
    Thread thread;
    SerializacaoCalendar serializador;
    static DadosCalendar proxDadoExecutar;
    
    public Cerebro(){
        gerenciadorCalendar = new GerenciadorCalendar();
        listaLocal = new ArrayList<DadosCalendar>();
        serializador = new SerializacaoCalendar();
        proxDadoExecutar = new DadosCalendar();
    }

    public void addNaLista(DadosCalendar d){
        determinarProximoDadoASerExecutadoInserindo(d);
    }
    
    public static void determinarProximoDadoASerExecutadoInserindo(DadosCalendar dados) {
        alterarSituacao(dados);
        if (dados != proxDadoExecutar) {
            listaLocal.add(dados);
        }
    }
    
    public static void alterarSituacao(DadosCalendar d) {
        if (d.getDataHorario().compareTo(Calendar.getInstance()) < 0) {
            d.setSituacao("P");
        }
        if (d.getDataHorario().compareTo(Calendar.getInstance()) > 0) {
            d.setSituacao("F");
        }
    }
    
    public List<DadosCalendar> listaOrdenada(List<DadosCalendar> list) {

        list = gerenciadorCalendar.ordenarDadosPorDataHoriario(list);
        return list;
    }
    
    public static void main(String[] args) {
        
    }
}
