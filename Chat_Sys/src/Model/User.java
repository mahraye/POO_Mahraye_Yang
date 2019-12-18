package Model;
import java.util.*;

public class User {
	private String nom;
    private String hostaddr;
    private List<User> Userlist;
    public User(String nom, String addr){
    	Userlist = new ArrayList<User>();    
        this.nom=nom;
        this.hostaddr=addr;
    }
    
    public String getNom(){ return this.nom;}
    public void setNom(String name){ nom = name;}
    public String getAddr(){ return this.hostaddr;}
    
    @Override
    public String toString()
    {
        return this.getNom()+" : "+this.getAddr();
    }
    
    @Override
    public boolean equals(Object o)
    {
        User u = null;
        if (o != null && o instanceof User){
            u = (User) o;
        }
        
        if(u != null)
            return ((this.hostaddr.equals( u.getAddr() ) ) );
        else
            return false;
    }
    
    public void checkUserInUserList(User utilisateur ) {
		int username_ok=0;
		while(username_ok==0) {
			for (int i=0; i < Userlist.size(); i++) {
				if(Userlist.get(i) == utilisateur)
				{
					System.out.println("Username déjà existant !");
				}
				else {
					Userlist.add(utilisateur);
					username_ok=1;
				}
			}
		}
	}
    
    public void RemoveInUserList (User utilisateur) {
		Userlist.remove(utilisateur);
    }
    
    
    	 
    	  

}
