package Model.messages;
import Model.User;
public class Connected extends Message {
	private static final long serialVersionUID = 2L;

	private String nickname;
	static User sender;
    static String text;

	public String getNickname(){
		return this.nickname;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public Connected(String nickname) {
		super(sender, text);
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Connected [nickname=" + sender.getNom() + sender.getAddr() + "]";
	}
	
	


}

