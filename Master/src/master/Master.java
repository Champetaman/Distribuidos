/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package master;

import data.FileInfo;
import data.RemoteServer;
import data.RemoteServerComparator;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import skeleton.MasterSkeleton;
import skeleton.ServerSkeleton;

/**
 *
 * @author TG1604
 */
public class Master implements MasterSkeleton {

    private List<RemoteServer> loadBalancer;
    private Map<String, ServerSkeleton> servers;
    private Map<String, FileInfo> files;
    private int K = 2;

    public Master() throws RemoteException {
        super();
        this.loadBalancer = new ArrayList<>();
        this.servers = new HashMap<>();
        this.files = new HashMap<>();
    }

    private List<RemoteServer> getBestServers(String serverName) {
        loadBalancer.sort(new RemoteServerComparator(serverName));
        return loadBalancer.subList(0, K);
    }

    @Override
    public boolean connect(String serverName, ServerSkeleton server) throws RemoteException {
        try {
            LocateRegistry.getRegistry().rebind(serverName, server);
            loadBalancer.add(new RemoteServer(serverName));
            servers.put(serverName, ((ServerSkeleton) LocateRegistry.getRegistry().lookup(serverName)));
            System.out.println("Conectado: " + serverName);
        } catch (NotBoundException | AccessException ex) {
            Logger.getLogger(Master.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static void main(String args[]) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        Master master = new Master();
        MasterSkeleton masterSkeleton = (MasterSkeleton) UnicastRemoteObject.exportObject(master, 0);
        registry.rebind("Master", masterSkeleton);
        System.out.println("Master running");
    }

    public boolean addFile(String serverName, String fileName, byte[] file) throws RemoteException {
        if (files.get(fileName) == null) {
            System.out.println("Detectado archivo nuevo");
            if (loadBalancer.size() > K - 1) {
                List<RemoteServer> candidates = getBestServers(serverName);
                FileInfo fileInfo = new FileInfo();
                for (RemoteServer candidate : candidates) {
                    System.out.println("Candidate:= "+candidate);
                    if (!candidate.getServerName().equals(serverName)) {
                        System.out.println("Enviando peticion de guardado de copia a " + candidate.getServerName());
                        if (((ServerSkeleton) servers.get(candidate.getServerName())).commitFile(fileName, file)) {
                            fileInfo.addCopy(candidate.getServerName());
                            System.out.println("Added " + candidate.getServerName() + " server as backup from file " + fileName);
                        } else {
                            // ABORT ALL
                        }
                    }
                }
                files.put(fileName, fileInfo);
                return true;
            } else {
                System.out.println("No hay suficientes servidores");
                return false;
            }
        } else {

        }
        return false;
    }

    @Override
    public boolean commitRequest(String serverName, String fileName, byte[] file) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
