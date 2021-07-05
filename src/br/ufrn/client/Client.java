package br.ufrn.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

import br.ufrn.interfaces.ClientInterface;
import br.ufrn.interfaces.ServerInterface;
import br.ufrn.model.Message;


public class Client extends UnicastRemoteObject implements ClientInterface {
    int id;
    private final Database database;
    private final ServerInterface server;
    
    protected Client(ServerInterface server) throws RemoteException {
        super();
        this.server = server;
        database = new Database();
    }
    
    void run() throws RemoteException {
        String input;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            menu();
            input = scanner.nextLine();
            
            while (input.matches("[1-2]]")) {
                System.out.println("entrada inválida. Digite novamente.");
                input = scanner.nextLine();
            }
            
            switch (Integer.parseInt(input)) {
                case 1:
                    addWord(scanner.nextLine());
                    break;
                case 2:
                    findWord(scanner.nextLine());
                    break;
                default:
                    break;
            }
        }
    }
    
    private void findWord(String word) throws RemoteException {
        List<ClientInterface> clients = this.server.containsWord(word);
        
        if (clients.isEmpty())
            System.out.println("Palavra não encontrada em nenhum repositório");
        
        else {
            System.out.println("Palavra encontrada nos repositórios:");
            for (ClientInterface client : clients) {
                System.out.println("- " + client.getClientID());
            }
        }
    }
    
    private void menu() {
        System.out.println("Menu:");
        System.out.println("1 - Add word");
        System.out.println("2 - Search word");
    }
    
    @Override
    public void printMessage(Message message) throws RemoteException {
        System.out.println(message);
    }
    
    @Override
    public void addWord(String word) throws RemoteException {
        database.addWord(word);
    }
    
    @Override
    public boolean containsWord(String word) throws RemoteException {
        return database.containsWord(word);
    }
    
    @Override
    public int getClientID() {
        return id;
    }
    
    @Override
    public void setClientID(int id) {
        this.id = id;
    }
}