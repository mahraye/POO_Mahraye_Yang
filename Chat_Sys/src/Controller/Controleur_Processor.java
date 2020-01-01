package Controller;
import java.util.*;


import Controller.Controller_reseau;
import java.net.SocketException;
import java.net.UnknownHostException;
import Model.messages.*;
import Model.Session;

import Model.Historique;
import Model.User;
public class Controleur_Processor {
    private Controller_reseau c_rzo;
    User user;
    Session session;
    Historique history;
    ArrayList<String> historyList ; 
    
    public Controleur_Processor(User utilisateur) throws SocketException, InterruptedException, UnknownHostException {
    
        c_rzo = new Controller_reseau(this, utilisateur);
        user = new User(utilisateur.getNom(), utilisateur.getAddr());
    }

    
    public Controller_reseau get_c_rzo () {
    	return this.c_rzo;
    }
    
    public void processConnected(Message m) {
    	user.checkUserInUserList(m.getSender());
    	c_rzo.sendConnected(m.getSender().getNom());
    	
    	
    }
    
    
    
    public void processDisconnected(Message m) {
    	c_rzo.sendDisconnected(m.getSender().getNom());
    	user.RemoveInUserList(m.getSender());
    	
    }
    
    public void processMsgNormal(MsgNormal m) {
    // envoyer et afficher le message dans l'interface
    	System.out.println("on proccess le msg");
    	System.out.println(m.getMessage());
    }
    
    public void processNameChanged(Message m) {
    	c_rzo.sendNameChanged(m.getSender().getNom());
    }
    
    public void processStar_rq(Message m) {
    	/* checker les sessions precedentes : si déjà démarré une session avec cette user, start session avec historique
    	 * sinon start une nouvelle session et ajouter la session à liste de sessions
    	 */
    	if(session.CheckSession(m.getSender())==true) {
    		historyList=history.getHistory(m.getSender().getAddr());
    	}
    	else{
    		history.createConvHistoryFile(m.getSender().getAddr());
    	}; 
    	
    	
    }
}
    
  