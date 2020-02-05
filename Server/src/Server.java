import java.net.*; 
import java.io.*; 

public class Server {
	
	public Server (int port) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server started");
		
		Socket socket = serverSocket.accept();
		System.out.println("Client accepted");
		
		DataInputStream inputStream = new DataInputStream(socket.getInputStream());
		
		long n = inputStream.readLong();
		
		String s = factorize(n);
		
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		outputStream.writeUTF(s);
		
		inputStream.close();
		socket.close();
		serverSocket.close();
		
	}
	
	public static void main (String args[]) throws IOException {
		
		Server server = new Server(56788);
	}
	public static String factorize (long n) { 
		
		StringBuilder builder = new StringBuilder("");
        int count = 0;
      
        while (!(n % 2 > 0)) {   
            n >>= 1; 
            count++; 
        } 
  
        if (count > 0)
            builder.append("2" + "^" + count+", "); 
  
        for (long i = 3; i <= (long) Math.sqrt(n); i += 2) { 
            count = 0; 
            while (n % i == 0) { 
                count++; 
                n = n / i; 
            } 
            
            if (count > 0)
            	builder.append(i + "^" + count+", "); 

        } 
    
        if (n > 2)
        	builder.append(n + "^" + "1"); 
        
        return builder.toString();
    } 

}
