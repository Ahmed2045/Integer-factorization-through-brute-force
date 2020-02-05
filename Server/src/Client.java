import java.net.*; 
import java.io.*; 

public class Client {
	
	public Client(String input, String address, int port) throws IOException {
		
		Socket socket = null;
		DataInputStream inputStream = null;
		DataOutputStream outputStream = null;
		
			socket = new Socket(address, port);
			System.out.println("Client Connected.");
				
			outputStream = new DataOutputStream(socket.getOutputStream());
			
			
			long n = 0;
			
			try {
				n = Long.parseLong(input);
				
			} catch (NumberFormatException e) {
				
				System.out.println("Invalid Input" + e);
				System.exit(1);
				
			} catch (NullPointerException e) {
				System.out.println("Invalid Input" + e);
				System.exit(1);
		    }
			
			outputStream.writeLong(n);
			
			inputStream = new DataInputStream(socket.getInputStream());
			
			String s = inputStream.readUTF();
			
			System.out.println(s);
			
			// Closes streams and socket
			inputStream.close();
			outputStream.close();
			socket.close();
			
	}
	
	public static void main(String args[]) throws IOException {
		
		Client client = new Client(args[0], "127.0.0.1", 56788);
		
	}
	
	
}