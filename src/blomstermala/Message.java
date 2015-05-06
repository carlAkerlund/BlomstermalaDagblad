package blomstermala;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	static final int ADDART = 0, ADDCOM = 1, GETCAT = 2, GETHEA = 3, GETART = 4; 
	private int type;
	
	public Message(int type){
		this.type = type;
	}
	
	public int getType(){
		return type;
	}
}
