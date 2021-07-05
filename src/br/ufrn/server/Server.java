package br.ufrn.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.interfaces.ClientInterface;
import br.ufrn.interfaces.ServerInterface;
import br.ufrn.model.Message;

public class Server extends UnicastRemoteObject implements ServerInterface {
    
    private final List<ClientInterface> clients;
    
    protected Server() throws RemoteException {
        super();
        clients = new ArrayList<>();
    }
    
    @Override
    public void registerClient(ClientInterface client) throws RemoteException {
        clients.add(client);
        client.setClientID(clients.size() - 1);
        System.out.println("Novo cliente registrado com sucesso! Total: " + clients.size());
        client.printMessage(new Message("Hello client " + (clients.size())));
    }
    
    @Override
    public List<ClientInterface> containsWord(String word) {
        List<ClientInterface> clientsWithWord = new ArrayList<>();
        
        for (ClientInterface client : clients) {
            try {
                if (client.containsWord(word))
                    clientsWithWord.add(client);
            } catch (RemoteException e) {
                clients.remove(client);
            }
        }
        
        return clientsWithWord;
    }
}