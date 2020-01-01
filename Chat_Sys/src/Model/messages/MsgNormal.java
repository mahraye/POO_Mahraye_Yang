package Model.messages;

import Model.User;

public class MsgNormal extends Message{
	
	private static final long serialVersionUID = 1L;

	private String message;
	private int id;
	static User sender;
	public MsgNormal(String msg, int id)
	{
		super(sender,msg);
	    message = msg;
	    this.id = id;
	}
	
	public String getMessage() {return message;}
	public int getID()         {return id;}

	@Override
	public String toString() {
		return "Message [message=" + message + ", id=" + id + "]";
	}
	

}
