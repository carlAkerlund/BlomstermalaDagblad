package blomstermala;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnector extends Thread {
	private Socket socket;
	private int port = 3453;
	private Server server;
	
	public ServerConnector(){
		server = new Server();
	}
	
	
	
	public void run(){
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				try {
					socket = serverSocket.accept();
					 new Connection(socket);
				} catch (IOException e) {
					System.err.println(e);
					if (socket != null)
						socket.close();
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	private class Connection extends Thread{
		private ObjectInputStream ois;
		private ObjectOutputStream oos;
		
		public Connection(Socket socket) throws IOException {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.flush();
			start();
		}
		
		public void run(){
			Message msg;
			try {
				while (true) {
					try {
						msg = (Message) ois.readObject();
						switch (msg.getType()) {
//						case Message.WRITER:
//							server.(msg);
//							break;
						}
					} catch (ClassNotFoundException e) {
						System.out.println("fel klass");
					}
				}
			} catch (IOException e) {
				System.out.println("fel inträffade");
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e2) {
					}
				}
			}
		}
		
		public void sendMessage(Message msg) throws IOException{
			oos.writeObject(msg);
		}
		
	}
}
