/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author cesar
 */
public class GerenciadorCalendar {
    public Calendar atualizarHorarioDaData(String horario, Calendar calendar) {
        Date dataParaColocarHora = new Date();
        int hora = Integer.parseInt(horario.substring(0, 2));
        int minuto = Integer.parseInt(horario.substring(3, 5));
        dataParaColocarHora.setHours(hora);
        dataParaColocarHora.setMinutes(minuto);
        dataParaColocarHora.setSeconds(0);
        calendar.setTime(dataParaColocarHora);

        return calendar;
    }

    /**
     * Método atualizarCalendario(). Esse método receber duas String´s a 1ª é a dada que do no formato dd/mm/yyyy e o 2ª é a 
     * hora no formato hh:mm. Sua finalidade é instânciar um objeto Calendar e atribuir a data e hora que recebeu entre parametros
     * na data e hora do Calendar, atualizando-o. Após a atualização ele retorna o objeto Calendar atualizado.
     * @param data
     * @param hora
     * @return 
     */
    public Calendar atulizarCalendario(String data, String hora){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora.substring(0, 2)));
        calendar.set(Calendar.MINUTE, Integer.parseInt(hora.substring(3, 5)));
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data.substring(0, 2)));
        calendar.set(Calendar.MONTH, Integer.parseInt(data.substring(3, 5)) - 1);
        calendar.set(Calendar.YEAR, Integer.parseInt(data.substring(6, 10)));

       
        return calendar;
    }
    
    public Calendar atualizarDataHorarioDoServidor(DadosCalendar d){
        Calendar calendar = Calendar.getInstance();
        String hora = d.getHorario();
        String data = d.getData();
        
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora.substring(0, 2)));
        calendar.set(Calendar.MINUTE, Integer.parseInt(hora.substring(3, 5)));
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data.substring(8, 10)));
        calendar.set(Calendar.MONTH, Integer.parseInt(data.substring(5, 7)) - 1);
        calendar.set(Calendar.YEAR, Integer.parseInt(data.substring(0, 4)));
        return calendar;
                
    }
    
    public Calendar novoAtualizarDataHorarioDoServidor(DadosCalendar d){
        Calendar calendar = Calendar.getInstance();
        String hora = d.getHorario();
        String data = d.getData();
        
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora.substring(11, 13)) - 4);
        calendar.set(Calendar.MINUTE, Integer.parseInt(hora.substring(14, 16)));
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data.substring(8, 10))+1);
        calendar.set(Calendar.MONTH, Integer.parseInt(data.substring(5, 7)) - 1);
        calendar.set(Calendar.YEAR, Integer.parseInt(data.substring(0, 4)));
        
        System.out.println(calendar.getTime());
        return calendar;
                
    }
    
    public DadosCalendar atualizarDataHorarioParaServidor(DadosCalendar d){
        Date date = new Date(d.getDataHorario().getTimeInMillis());
        d.setData(String.valueOf(date.getTime()));
        d.setHorario(String.valueOf(date.getTime()));
        DadosCalendar d1 = d;
        
        return d1;
    }
    
    
    public Calendar tranformarMilissegundoEmDate(DadosCalendar d){
        DadosCalendar dado = new DadosCalendar();
        Long horaLong = Long.parseLong(d.getHorario());
        Long dataLong = Long.parseLong(d.getData());
        Date hora = new Date(horaLong);
        Date data = new Date(dataLong);
        
        Calendar calendar = Calendar.getInstance();
        
        calendar.set(Calendar.HOUR_OF_DAY, hora.getHours());
        calendar.set(Calendar.MINUTE, hora.getMinutes());
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.DAY_OF_MONTH, data.getDay()+24);
        calendar.set(Calendar.MONTH, data.getMonth());
        calendar.set(Calendar.YEAR, data.getYear()+1900);
        
        return calendar;
    }
    
    
    public List<DadosCalendar> ordenarDadosPorDataHoriario(List<DadosCalendar> list){
        list.sort(new CompararCalendar());
        return list;
    }
    
    
}
