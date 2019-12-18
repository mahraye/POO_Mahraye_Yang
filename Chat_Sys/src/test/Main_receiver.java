package test;
import Model.reseau.Receiver;
import Controller.Controller_reseau;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import Controller.Controleur_Processor;
import Model.User;
public class Main_receiver {
	
	public static void main(String arg[]) throws SocketException, InterruptedException, UnknownHostException {
		try {
		User utilisateur = new User("mouloud","127.0.0.1");
		
		Controleur_Processor process = new Controleur_Processor (utilisateur);
		Controller_reseau chat = new Controller_reseau(process, utilisateur);
		Receiver receive = new Receiver(chat) ;
		}
		catch (IOException e)
        {
          System.err.println("Exception:  " + e);
          e.printStackTrace();
          //com
        }
	}

}
