/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.tsi.iot.app;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Gustavo
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        JanelaPricipal jp = new JanelaPricipal();
        jp.setVisible(true);
    }
}
