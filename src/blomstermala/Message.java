package blomstermala;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	static final int Whoisin = 0, Message = 1, Logout = 2, Login = 3; 
	private int type;
	
	public Message(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}
}
