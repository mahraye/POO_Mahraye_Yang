package Controller;

import Controller.Controleur_Processor;


import Model.reseau.Receiver;
import Model.reseau.Sender;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;
import Model.messages.*;
import Model.User;

public class Controller_reseau {
	User user;
	Controleur_Processor processor;
    
    private Sender _client;
    private Receiver _server;
    private InetAddress _group;
    final int _port = 16050;
    private boolean _actif;
    
    public Controller_reseau(Controleur_Processor p, User utilisateur) throws SocketException, InterruptedException, UnknownHostException {
        processor = p;
        user= utilisateur;
        _group = InetAddress.getByName("255.255.255.255");
        _actif = false;
        _server = new Receiver(this);
        _server.setName("UDP Receiver");
        _server.start();
        _client = new Sender(this);  
    }
    /*
    public void startServer(){
        _server.start();
    }*/
    
    public int getPort(){
        return _port;
    }
    
    public boolean isActiv(){
        return _actif;
    }
    
    public void setActiv(boolean b){
        _actif=b;
    }



    
    public void messageHandle(Message m, String remoteaddr) throws IOException
    {
        if(_actif){
            
            if(m instanceof Connected) {
            	processor.processConnected((Connected) m);
            }
            else if(m instanceof Disconnected) {
            	processor.processDisconnected((Disconnected) m);
            }
            else if(m instanceof MsgNormal) {
            	processor.processMsgNormal((MsgNormal) m);
            }
            else if(m instanceof NameChanged) {
            	processor.processNameChanged((NameChanged) m);
            }
            else if(m instanceof Start_rq) {
            	processor.processStar_rq((Start_rq) m);
            }
        }
    }
    
    public void sendConnected(String nickname) {
        Message m;
        m = new Connected(nickname);
        _client.sendTo(m,_group.getHostAddress(),_port);
    }

    public void sendDisconnected(String nickname) {
        Message m;
        m = new Disconnected(nickname);
        _client.sendTo(m,_group.getHostAddress(),_port);    
    }
    
    public void sendMsgNormal(String text, int id, String hostname) {
        Message m;
        m = new MsgNormal(text, id);
        _client.sendTo(m,hostname,_port); 
    }

    public void sendNameChanged(String nickname) {
        Message m;
        m = new NameChanged(nickname);
        _client.sendTo(m,_group.getHostAddress(),_port); 
    }
    
    public void sendStart_rq(String nickname,String hostname) {
        Message m;
        m = new Start_rq(nickname);
        _client.sendTo(m,hostname,_port); 
    }
    
    


}
