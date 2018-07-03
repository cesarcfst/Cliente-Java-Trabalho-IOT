/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class SerializadorTest {
    public static void main(String[] args) {
        DadosCalendar d = new DadosCalendar();
        GerenciadorCalendar ger = new GerenciadorCalendar();
        SerializacaoCalendar seri = new SerializacaoCalendar();
        d.setId(1);
        d.setDataHorario(ger.atulizarCalendario("01/10/2050", "07:30"));
        d.setLuzDaSala("L");
        d.setVentilador("L");
        d.setLuzDoQuarto("L");
        d.setTv("L");
        d.setSituacao("F");
        d.setAgendamento(new ArrayList<DadosCalendar>());
        System.out.println("DADOS SALVOS");
        try {
            seri.gravarDados(d);
        } catch (IOException ex) {
            Logger.getLogger(SerializadorTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(SerializadorTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SerializadorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
