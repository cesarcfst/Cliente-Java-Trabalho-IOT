
package javaapplication24;

import br.ifms.tsi.iot.util.RXTX;
import gnu.io.CommPortIdentifier;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class janelaPrincipal2 extends JFrame{
     private JPanel painel;
     private JButton botaoDesligar;
     private JButton botaoLigar;
     private JTextField campo;
     private RXTX rxtx;
     
     public janelaPrincipal2(){
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(200, 100);
         
         painel = new JPanel();
         botaoLigar = new JButton("Ligar");
         botaoDesligar = new JButton("Desligar");
         campo = new JTextField(4);
         
         painel.add(botaoLigar);
         painel.add(botaoDesligar);
         painel.add(campo);
         add(painel, BorderLayout.CENTER);
         
         
         Thread thread=new Thread(new Runnable() {
             @Override
             public void run() {
                String dados;
                while(true){
                    try {
                        dados = rxtx.receberDados();
                        if(dados != null){
                            campo.setText(dados);
                        }
                    } catch (Exception e) {
                    }
                }
             }
         });
         
         try {
             connectarComArduino();
             System.out.println("Conectado!!!");
             thread.start();
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Impossivel Coeneatar");
         }
         
         botaoLigar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     rxtx.enviarDados("1");
                 } catch (IOException ex) {
                     System.out.println("Enviar" + ex);
                 }
             }
         });
         
         botaoDesligar.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     rxtx.enviarDados("0");
                 } catch (IOException ex) {
                     System.out.println("Erroa ao enviar" + ex);
                 }
             }
         });
         
     }

    private void connectarComArduino() throws Exception{
        CommPortIdentifier porta = RXTX.listarPortasSeriais().get(0);
        rxtx  = new RXTX(porta, 9600);
    }
}
