/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.iot.app;

import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Cesar Augusto
 */
public class JanelaPricipal extends JFrame {

    private Session session;
    private static Gson gson;
    private JButton botao;
    private JTextField campo;

    public JanelaPricipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 100);
        botao = new JButton("Ok");
        campo = new JTextField(10);
        JPanel painel = new JPanel();
        gson = new Gson();
        painel.add(campo);
        painel.add(botao);
        this.add(painel, BorderLayout.CENTER);
        conectarComWebSocket();
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Mensagem mensagem = new Mensagem();
                mensagem.setTexto(campo.getText());
                mensagem.setHorarioLocal(new Date().toString());

                session.getAsyncRemote().sendText(gson.toJson(mensagem));//para manda a mesagem para webSecket eu que transforma em obj GSON com o método toGson
            }
        });
    }

    private void conectarComWebSocket() {
        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer(); //conseguimos instanciar um com ContainerProvider.getWebSocketContainer()
        try {
            session = webSocketContainer.connectToServer(JanelaPricipal.MyEndpoint.class,
                    URI.create("ws://teste-websockets.herokuapp.com/teste/websocket"));
            System.out.println("Conectado com WebSocket");
        } catch (DeploymentException | IOException ex) {
            System.out.println(ex);
        }
    }

    @ClientEndpoint
    public static class MyEndpoint {// nesse caso é melhor que a classe 

        @OnMessage
        public void onMessage(String message, Session session) { // toda vez que chegar uma msg do servidor isso será executado
            // mesagem vai vim na String message 

            Mensagem msg = gson.fromJson(message, Mensagem.class);// vai transformar a msg que vem do servidor em um Obj do tipo Mesagem
            if (msg.getTexto() != null) {// para aceitar somente msg que vinherem com texto as demais serão rejetadas
                System.out.println("Mensagem: " + msg.getTexto());
                System.out.println("Horário do Envio: " + msg.getHorarioLocal());
                System.out.println("Horário do servidor: "+msg.getHorarioServidor());
            }
        }
    }
}
