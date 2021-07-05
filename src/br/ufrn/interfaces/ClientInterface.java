package br.ufrn.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import br.ufrn.model.Message;

public interface ClientInterface extends Remote {
    void printMessage(Message message) throws RemoteException;
    
    void addWord(String word) throws RemoteException;
    
    boolean containsWord(String word) throws RemoteException;
    
    int getClientID() throws RemoteException;
    
    void setClientID(int id) throws RemoteException;
}