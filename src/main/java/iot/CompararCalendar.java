/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.util.Comparator;

/**
 *
 * @author cesar
 */
public class CompararCalendar implements Comparator<DadosCalendar>{

    @Override
    public int compare(DadosCalendar o1, DadosCalendar o2) {
        if (o1.getDataHorario().compareTo(o2.getDataHorario()) > 0) {
            return 1;
        }
        if (o1.getDataHorario().compareTo(o2.getDataHorario()) == 0) {
            return 0;
        }
        return -1;
    }
    
}
