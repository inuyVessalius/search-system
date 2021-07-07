package br.ufrn.client;

import br.ufrn.interfaces.ServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        ServerInterface server = (ServerInterface) Naming.lookup("rmi://" + args[0] + ":1098/server");
        
        Client client = new Client(server);
        
        server.registerClient(client);
        
        client.run();
    }
}