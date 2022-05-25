import java.io.*;
import java.net.*;
import java.nio.*;

public class Server {
	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket serverSocket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			serverSocket = new ServerSocket(1111);
		} catch(IOException e) {
			System.out.println("Port is already opened");
		}
	}

}
