/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iot;

import static iot.JanelaUtualizada.gerenciadorCalendar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cesar
 */
public class SerializacaoCalendar {
    private List<DadosCalendar> listDados;
    private String nomeDoSerializable;
    
    public SerializacaoCalendar(){
        listDados = new ArrayList<DadosCalendar>();
        inicializarAgendamento(listDados);
    }
    
//    public void gravarUmDados(DadosCalendar dado) throws FileNotFoundException, IOException , NullPointerException, ClassNotFoundException{
//        listDados = buscarListaDeDados();// verificar a situação da busca, se realmento é necessário fazer a busca antes de gravar pq quando eu for add todos uns dados de uma vez irá da erro.
//        dado.setAgendamento(new ArrayList<DadosCalendar>());
//        listDados.add(dado);
//        FileOutputStream out = new FileOutputStream("iot");
//        ObjectOutputStream objOut = new ObjectOutputStream(out);
//
//        objOut.writeObject(listDados);//SALVAR NO OBJETO OBJECTOUTPUTSTREAM
//        objOut.close();
//        System.out.println("Dados inserido com sucesso!!!!");
//    }
    
    public List<DadosCalendar> buscarListaDeDados() throws FileNotFoundException, IOException, ClassNotFoundException, NullPointerException {
        FileInputStream in = new FileInputStream("iot");// 
        ObjectInputStream objIn = new ObjectInputStream(in);
        listDados = (List) objIn.readObject();// pegando o obj salvo no ObjectInputStream e passando para a lista de pessoa.
        return listDados;
        
        
    }
    
    public void gravarUmaListaDeDados(List<DadosCalendar> list) throws FileNotFoundException, IOException{
        inicializarAgendamento(list);
        FileOutputStream out = new FileOutputStream("iot");
        ObjectOutputStream objOut = new ObjectOutputStream(out);

        objOut.writeObject(list);//SALVAR NO OBJETO OBJECTOUTPUTSTREAM
        objOut.close();
        System.out.println("Dados inserido com sucesso!!!!");
    }
    
    public void inicializarAgendamento(List<DadosCalendar> dados){
        for (DadosCalendar dado : dados) {
            dado.setAgendamento(new ArrayList<DadosCalendar>());
        }
    }

    public List<DadosCalendar> getListDados() {
        return listDados;
    }

    public void setListDados(List<DadosCalendar> listDados) {
        this.listDados = listDados;
    }

    public String getNomeDoSerializable() {
        return nomeDoSerializable;
    }

    public void setNomeDoSerializable(String nomeDoSerializable) {
        this.nomeDoSerializable = nomeDoSerializable;
    }
    
//    public static void main(String[] args) {
//        String data2 = "01/10/2050";
//        String horario2 = "22:00";
//        DadosCalendar d2 = new DadosCalendar();
//        d2.setId(1);
//        d2.setAgendamento(new ArrayList<DadosCalendar>());
//        d2.setDataHorario(new GerenciadorCalendar().atulizarCalendario(data2, horario2));
//        d2.setLuzDaSala("D");
//        d2.setLuzDoQuarto("L");
//        d2.setTv("D");
//        d2.setVentilador("L");
//        
//        List<DadosCalendar> l = new ArrayList<DadosCalendar>();
//        l.add(d2);
//        try {
//            new SerializacaoCalendar().gravarUmaListaDeDados(l);
//        } catch (IOException ex) {
//            Logger.getLogger(SerializacaoCalendar.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (NullPointerException ex) {
//            Logger.getLogger(SerializacaoCalendar.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
