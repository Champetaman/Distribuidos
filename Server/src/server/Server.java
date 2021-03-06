/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Listeners.DecryptThread;
import Listeners.LoadBalancerListener;
import Entities.ServerMessage;
import Entities.Message;
import Entities.PasswordTuple;
import Entities.ResponseMessage;
import Entities.Serverinfo;
import Entities.ServerinfoPK;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.Hack.HashGeneratorUtils;

/**
 *
 * @author david
 */
public class Server {

    public static int MY_PORT = 2029;
    public static int MY_PING_PORT = 4040;
    public static int BALANCER_PORT = 1111;
    public static int BALANCER_RESPONSE_PORT = 1113;
    public static String BALANCER_IP = "localhost";
    public static String MY_IP = "localhost";
    public static List<Integer> caracteres = new ArrayList<>();

    @SuppressWarnings("empty-statement")
    public static void main(String args[]) {

        for (int i = 0; i < 255; i++) {
            caracteres.add(i);
        }
        
        try {
            
            LoadBalancerListener loadBalancerListener = new LoadBalancerListener();
            loadBalancerListener.start();
            
            DecryptThread decryptThread = new DecryptThread();
            decryptThread.start();
            
            // ABRIR PUERTO PARA PINGS
            ServerSocket serverSocketPing = new ServerSocket(MY_PING_PORT);
            
            // SUBSCRIPCION A LOAD BALANCER
            ServerinfoPK serverinfoPK = new ServerinfoPK(MY_IP, MY_PORT);
            Serverinfo serverinfo = new Serverinfo(serverinfoPK, "DESCIFRAR", false);
            Socket socket = new Socket(BALANCER_IP, BALANCER_PORT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(serverinfo);
            objectOutputStream.close();
            socket.close();
            
            while(true){
                socket = serverSocketPing.accept();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    
}
